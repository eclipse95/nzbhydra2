package org.nzbhydra.searching;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class CategoryProviderTest {

    CategoryProvider testee = new CategoryProvider();



    @Before
    public void setUp() throws Exception {
        List<Category> categories = new ArrayList<>();
        Category category = new Category();
        category.setName("3000,3030");
        category.setNewznabCategories(Arrays.asList(3000,3030));
        categories.add(category);

        category = new Category();
        category.setName("4000");
        category.setNewznabCategories(Arrays.asList(4000));
        categories.add(category);

        category = new Category();
        category.setName("4090");
        category.setNewznabCategories(Arrays.asList(4090));
        categories.add(category);

        category = new Category();
        category.setName("7020,8010");
        category.setNewznabCategories(Arrays.asList(7020, 8010));
        categories.add(category);
        testee.setCategories(categories);
    }

    @Test
    public void fromNewznabCategories() throws Exception {
        assertThat(testee.fromNewznabCategories(Arrays.asList(3000)).getName(), is("3000,3030"));
        assertThat(testee.fromNewznabCategories(Arrays.asList(3030)).getName(), is("3000,3030"));
        assertThat(testee.fromNewznabCategories(Arrays.asList(7020)).getName(), is("7020,8010"));

        //Different order
        assertThat(testee.fromNewznabCategories(Arrays.asList(7020,8010)).getName(), is("7020,8010"));

        //One general category
        assertThat(testee.fromNewznabCategories(Arrays.asList(4000)).getName(), is("4000"));

        //Generalized (4020 matches 4000)
        assertThat(testee.fromNewznabCategories(Arrays.asList(4020)).getName(), is("4000"));

        //Specific trumps general
        assertThat(testee.fromNewznabCategories(Arrays.asList(4090)).getName(), is("4090"));

        //None found
        assertThat(testee.fromNewznabCategories(Arrays.asList(7090)).getName(), is(nullValue()));

        //String input
        assertThat(testee.fromNewznabCategories("4000").getName(), is("4000"));
        assertThat(testee.fromNewznabCategories("7020,8010").getName(), is("7020,8010"));

        //No cats
        assertThat(testee.fromNewznabCategories(Collections.emptyList()).getName(), is(nullValue()));
        assertThat(testee.fromNewznabCategories("").getName(), is(nullValue()));

    }

}