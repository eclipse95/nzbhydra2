package org.nzbhydra.searching;

import org.junit.Before;
import org.junit.Test;
import org.nzbhydra.config.BaseConfig;
import org.nzbhydra.config.category.CategoriesConfig;
import org.nzbhydra.config.category.Category;
import org.nzbhydra.config.category.Category.Subtype;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CategoryProviderTest {

    CategoryProvider testee = new CategoryProvider();

    @Before
    public void setUp() throws Exception {
        List<Category> categories = new ArrayList<>();
        Category category = new Category();
        category.setName("all");
        category.setNewznabCategories(Collections.emptyList());
        categories.add(category);

        category = new Category();
        category.setName("n/a");
        category.setNewznabCategories(Collections.emptyList());
        categories.add(category);

        category = new Category();
        category.setName("3000,3030");
        category.setNewznabCategories(Arrays.asList(Collections.singletonList(3000), Collections.singletonList(3030)));
        categories.add(category);

        category = new Category();
        category.setName("4000");
        category.setNewznabCategories(Arrays.asList(Collections.singletonList(4000)));
        categories.add(category);

        category = new Category();
        category.setName("4030");
        category.setNewznabCategories(Arrays.asList(Collections.singletonList(4030)));
        categories.add(category);

        category = new Category();
        category.setName("4090");
        category.setSubtype(Subtype.COMIC);
        category.setNewznabCategories(Arrays.asList(Collections.singletonList(4090)));
        categories.add(category);

        category = new Category();
        category.setName("4090&11_000");
        category.setNewznabCategories(Arrays.asList(Arrays.asList(4090, 11_000)));
        categories.add(category);

        category = new Category();
        category.setName("7070&77_000+8080&88_000");
        category.setNewznabCategories(Arrays.asList(Arrays.asList(7070, 77_000), Arrays.asList(8080, 88_000)));
        categories.add(category);

        category = new Category();
        category.setName("10_000&20_000&30_000");
        category.setNewznabCategories(Arrays.asList(Arrays.asList(10_000, 20_000, 30_000)));
        categories.add(category);

        category = new Category();
        category.setName("6060+9090&99_000");
        category.setNewznabCategories(Arrays.asList(Arrays.asList(6060), Arrays.asList(9090, 99_000)));
        categories.add(category);


        category = new Category();
        category.setName("7020,8010");
        category.setSubtype(Subtype.ANIME);
        category.setNewznabCategories(Arrays.asList(Collections.singletonList(7020), Collections.singletonList(8010)));
        categories.add(category);
        BaseConfig baseConfig = new BaseConfig();
        CategoriesConfig categoriesConfig = new CategoriesConfig();
        categoriesConfig.setCategories(categories);
        baseConfig.setCategoriesConfig(categoriesConfig);
        testee.baseConfig = baseConfig;
        testee.initialize();
    }

    @Test
    public void shouldConvertSearchNewznabCategoriesToInternalCategory() throws Exception {
        assertThat(testee.fromSearchNewznabCategories(Arrays.asList(3000), CategoriesConfig.allCategory).getName(), is("3000,3030"));
        assertThat(testee.fromSearchNewznabCategories(Arrays.asList(3030), CategoriesConfig.allCategory).getName(), is("3000,3030"));
        assertThat(testee.fromSearchNewznabCategories(Arrays.asList(7020), CategoriesConfig.allCategory).getName(), is("7020,8010"));
        assertThat(testee.fromSearchNewznabCategories(Arrays.asList(7000, 7020), CategoriesConfig.allCategory).getName(), is("7020,8010"));

        //Different order
        assertThat(testee.fromSearchNewznabCategories(Arrays.asList(7020, 8010), CategoriesConfig.allCategory).getName(), is("7020,8010"));

        //One general category
        assertThat(testee.fromSearchNewznabCategories(Arrays.asList(4000), CategoriesConfig.allCategory).getName(), is("4000"));

        //Generalized (4020 matches 4000)
        assertThat(testee.fromSearchNewznabCategories(Arrays.asList(4020), CategoriesConfig.allCategory).getName(), is("4000"));

        //Specific trumps general
        assertThat(testee.fromSearchNewznabCategories(Arrays.asList(4090), CategoriesConfig.allCategory).getName(), is("4090"));

        //If a main category and a subcategory are supplied use the main category
        assertThat(testee.fromSearchNewznabCategories(Arrays.asList(4000, 4090), CategoriesConfig.allCategory).getName(), is("4000"));

        //No matching found, use all
        assertThat(testee.fromSearchNewznabCategories(Arrays.asList(7090), CategoriesConfig.allCategory).getName(), is("All"));

        //String input
        assertThat(testee.fromSearchNewznabCategories("4000").getName(), is("4000"));
        assertThat(testee.fromSearchNewznabCategories("7020,8010").getName(), is("7020,8010"));

        //No cats
        assertThat(testee.fromSearchNewznabCategories(Collections.emptyList(), CategoriesConfig.allCategory).getName(), is("All"));
        assertThat(testee.fromSearchNewznabCategories("").getName(), is("N/A"));

        //Two subcategories, both of which have a match -> Use the general one
        assertThat(testee.fromSearchNewznabCategories(Arrays.asList(4030, 4090), CategoriesConfig.allCategory).getName(), is("4000"));

        //Two main categories -> Use the higher one (doesn't really matter, one needs to be used)
        assertThat(testee.fromSearchNewznabCategories(Arrays.asList(3000, 4000), CategoriesConfig.allCategory).getName(), is("4000"));
    }

    @Test
    public void shouldConvertIndexerNewznabCategoriesToInternalCategory() throws Exception {
        //Should return N/A on empty list
        assertThat(testee.fromResultNewznabCategories(Collections.emptyList()).getName(), is("N/A"));

        //Should return more specific matching category
        assertThat(testee.fromResultNewznabCategories(Arrays.asList(4000, 4090)).getName(), is("4090"));

        //Should ignore numbers from custom range if not specified in category
        assertThat(testee.fromResultNewznabCategories(Arrays.asList(4000, 4090, 10_000)).getName(), is("4090"));
        assertThat(testee.fromResultNewznabCategories(Arrays.asList(4000, 10_000)).getName(), is("4000"));

        //Should use category that matches custom range if specified
        //Matches both and is more specific than only 4090
        assertThat(testee.fromResultNewznabCategories(Arrays.asList(4090, 11_000)).getName(), is("4090&11_000"));
        //Doesn't use custom range but category with combined is still found
        assertThat(testee.fromResultNewznabCategories(Arrays.asList(6060)).getName(), is("6060+9090&99_000"));
        //Uses combined range and is found
        assertThat(testee.fromResultNewznabCategories(Arrays.asList(6060, 99_000)).getName(), is("6060+9090&99_000"));
        //Does not match both numbers in either combination
        assertThat(testee.fromResultNewznabCategories(Arrays.asList(7070, 88_000)).getName(), is("N/A"));
        //Uses combination of three
        assertThat(testee.fromResultNewznabCategories(Arrays.asList(10_000, 20_000, 30_000)).getName(), is("10_000&20_000&30_000"));
        assertThat(testee.fromResultNewznabCategories(Arrays.asList(10_000, 20_000)).getName(), is("N/A"));

        //Should return matching main category if subcat not found
        assertThat(testee.fromResultNewznabCategories(Arrays.asList(4020)).getName(), is("4000"));

        //Should return N/A if no matching found
        assertThat(testee.fromResultNewznabCategories(Arrays.asList(9999)).getName(), is("N/A"));
    }


    @Test
    public void testcheckCategoryMatchingMainCategory() {
        assertThat(testee.checkCategoryMatchingMainCategory(5030, 5000), is(true));
        assertThat(testee.checkCategoryMatchingMainCategory(5000, 5000), is(true));
        assertThat(testee.checkCategoryMatchingMainCategory(4030, 5000), is(false));
        assertThat(testee.checkCategoryMatchingMainCategory(4000, 5000), is(false));
        assertThat(testee.checkCategoryMatchingMainCategory(4030, 4030), is(false));
    }

    @Test
    public void testThatWorksWithSameNewznabCategoriesAsCategory() {
        testee.baseConfig.getCategoriesConfig().getCategories().clear();
        Category category = new Category();
        category.setName("TV HD");
        category.setNewznabCategories(Arrays.asList(Collections.singletonList(5010), Collections.singletonList(5040)));
        testee.baseConfig.getCategoriesConfig().getCategories().add(category);

        Category category2 = new Category();
        category2.setName("TV UHD");
        category2.setNewznabCategories(Arrays.asList(Collections.singletonList(5045)));
        testee.baseConfig.getCategoriesConfig().getCategories().add(category2);

        testee.initialize();

        Category foundCategory = testee.getCategory(Arrays.asList(5010, 5040), null);

        assertThat(foundCategory.getName(), is(category.getName()));
    }

    @Test
    public void shouldFindBySubtype() {
        Optional<Category> animeOptional = testee.fromSubtype(Subtype.ANIME);
        assertThat(animeOptional.isPresent(), is(true));
        assertThat(animeOptional.get().getName(), is("7020,8010"));

        Optional<Category> magazineOptional = testee.fromSubtype(Subtype.MAGAZINE);
        assertThat(magazineOptional.isPresent(), is(false));
    }

}