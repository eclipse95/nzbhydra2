package org.nzbhydra.searching.db;

/**
 * {@link SearchResultEntityTO} specific assertions - Generated by CustomAssertionGenerator.
 * <p>
 * Although this class is not final to allow Soft assertions proxy, if you wish to extend it,
 * extend {@link AbstractSearchResultEntityTOAssert} instead.
 */
@jakarta.annotation.Generated(value = "assertj-assertions-generator")
public class SearchResultEntityTOAssert extends AbstractSearchResultEntityTOAssert<SearchResultEntityTOAssert, SearchResultEntityTO> {

    /**
     * Creates a new <code>{@link SearchResultEntityTOAssert}</code> to make assertions on actual SearchResultEntityTO.
     *
     * @param actual the SearchResultEntityTO we want to make assertions on.
     */
    public SearchResultEntityTOAssert(SearchResultEntityTO actual) {
        super(actual, SearchResultEntityTOAssert.class);
    }

    /**
     * An entry point for SearchResultEntityTOAssert to follow AssertJ standard <code>assertThat()</code> statements.<br>
     * With a static import, one can write directly: <code>assertThat(mySearchResultEntityTO)</code> and get specific assertion with code completion.
     *
     * @param actual the SearchResultEntityTO we want to make assertions on.
     * @return a new <code>{@link SearchResultEntityTOAssert}</code>
     */
    @org.assertj.core.util.CheckReturnValue
    public static SearchResultEntityTOAssert assertThat(SearchResultEntityTO actual) {
        return new SearchResultEntityTOAssert(actual);
    }
}