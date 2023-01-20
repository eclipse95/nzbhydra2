package org.nzbhydra.historystats.stats;

import org.assertj.core.api.AbstractObjectAssert;
import org.assertj.core.util.Objects;

/**
 * Abstract base class for {@link HistoryRequest} specific assertions - Generated by CustomAssertionGenerator.
 */
@jakarta.annotation.Generated(value = "assertj-assertions-generator")
public abstract class AbstractHistoryRequestAssert<S extends AbstractHistoryRequestAssert<S, A>, A extends HistoryRequest> extends AbstractObjectAssert<S, A> {

    /**
     * Creates a new <code>{@link AbstractHistoryRequestAssert}</code> to make assertions on actual HistoryRequest.
     *
     * @param actual the HistoryRequest we want to make assertions on.
     */
    protected AbstractHistoryRequestAssert(A actual, Class<S> selfType) {
        super(actual, selfType);
    }

    /**
     * Verifies that the actual HistoryRequest is distinct.
     *
     * @return this assertion object.
     * @throws AssertionError - if the actual HistoryRequest is not distinct.
     */
    public S isDistinct() {
        // check that actual HistoryRequest we want to make assertions on is not null.
        isNotNull();

        // check that property call/field access is true
        if (!actual.isDistinct()) {
            failWithMessage("\nExpecting that actual HistoryRequest is distinct but is not.");
        }

        // return the current assertion for method chaining
        return myself;
    }

    /**
     * Verifies that the actual HistoryRequest is not distinct.
     *
     * @return this assertion object.
     * @throws AssertionError - if the actual HistoryRequest is distinct.
     */
    public S isNotDistinct() {
        // check that actual HistoryRequest we want to make assertions on is not null.
        isNotNull();

        // check that property call/field access is false
        if (actual.isDistinct()) {
            failWithMessage("\nExpecting that actual HistoryRequest is not distinct but is.");
        }

        // return the current assertion for method chaining
        return myself;
    }

    /**
     * Verifies that the actual HistoryRequest's filterModel is equal to the given one.
     *
     * @param filterModel the given filterModel to compare the actual HistoryRequest's filterModel to.
     * @return this assertion object.
     * @throws AssertionError - if the actual HistoryRequest's filterModel is not equal to the given one.
     */
    public S hasFilterModel(org.nzbhydra.historystats.FilterModel filterModel) {
        // check that actual HistoryRequest we want to make assertions on is not null.
        isNotNull();

        // overrides the default error message with a more explicit one
        String assertjErrorMessage = "\nExpecting filterModel of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";

        // null safe check
        org.nzbhydra.historystats.FilterModel actualFilterModel = actual.getFilterModel();
        if (!Objects.areEqual(actualFilterModel, filterModel)) {
            failWithMessage(assertjErrorMessage, actual, filterModel, actualFilterModel);
        }

        // return the current assertion for method chaining
        return myself;
    }

    /**
     * Verifies that the actual HistoryRequest's limit is equal to the given one.
     *
     * @param limit the given limit to compare the actual HistoryRequest's limit to.
     * @return this assertion object.
     * @throws AssertionError - if the actual HistoryRequest's limit is not equal to the given one.
     */
    public S hasLimit(int limit) {
        // check that actual HistoryRequest we want to make assertions on is not null.
        isNotNull();

        // overrides the default error message with a more explicit one
        String assertjErrorMessage = "\nExpecting limit of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";

        // check
        int actualLimit = actual.getLimit();
        if (actualLimit != limit) {
            failWithMessage(assertjErrorMessage, actual, limit, actualLimit);
        }

        // return the current assertion for method chaining
        return myself;
    }

    /**
     * Verifies that the actual HistoryRequest is only current user.
     *
     * @return this assertion object.
     * @throws AssertionError - if the actual HistoryRequest is not only current user.
     */
    public S isOnlyCurrentUser() {
        // check that actual HistoryRequest we want to make assertions on is not null.
        isNotNull();

        // check that property call/field access is true
        if (!actual.isOnlyCurrentUser()) {
            failWithMessage("\nExpecting that actual HistoryRequest is only current user but is not.");
        }

        // return the current assertion for method chaining
        return myself;
    }

    /**
     * Verifies that the actual HistoryRequest is not only current user.
     *
     * @return this assertion object.
     * @throws AssertionError - if the actual HistoryRequest is only current user.
     */
    public S isNotOnlyCurrentUser() {
        // check that actual HistoryRequest we want to make assertions on is not null.
        isNotNull();

        // check that property call/field access is false
        if (actual.isOnlyCurrentUser()) {
            failWithMessage("\nExpecting that actual HistoryRequest is not only current user but is.");
        }

        // return the current assertion for method chaining
        return myself;
    }

    /**
     * Verifies that the actual HistoryRequest's page is equal to the given one.
     *
     * @param page the given page to compare the actual HistoryRequest's page to.
     * @return this assertion object.
     * @throws AssertionError - if the actual HistoryRequest's page is not equal to the given one.
     */
    public S hasPage(int page) {
        // check that actual HistoryRequest we want to make assertions on is not null.
        isNotNull();

        // overrides the default error message with a more explicit one
        String assertjErrorMessage = "\nExpecting page of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";

        // check
        int actualPage = actual.getPage();
        if (actualPage != page) {
            failWithMessage(assertjErrorMessage, actual, page, actualPage);
        }

        // return the current assertion for method chaining
        return myself;
    }

    /**
     * Verifies that the actual HistoryRequest's sortModel is equal to the given one.
     *
     * @param sortModel the given sortModel to compare the actual HistoryRequest's sortModel to.
     * @return this assertion object.
     * @throws AssertionError - if the actual HistoryRequest's sortModel is not equal to the given one.
     */
    public S hasSortModel(org.nzbhydra.historystats.SortModel sortModel) {
        // check that actual HistoryRequest we want to make assertions on is not null.
        isNotNull();

        // overrides the default error message with a more explicit one
        String assertjErrorMessage = "\nExpecting sortModel of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";

        // null safe check
        org.nzbhydra.historystats.SortModel actualSortModel = actual.getSortModel();
        if (!Objects.areEqual(actualSortModel, sortModel)) {
            failWithMessage(assertjErrorMessage, actual, sortModel, actualSortModel);
        }

        // return the current assertion for method chaining
        return myself;
    }

}