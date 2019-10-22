package com.alexzh.imbarista.helpers.matchers

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher

/**
 * Mather(s) for [RecyclerView] class.
 */
object RecyclerViewMatchers {

    /**
     * Returns a matcher that matches [View] that contains number of items in RecyclerView
     * associated with the given id.
     *
     * @param count the number of items in [RecyclerView].
     */
    fun withItemCount(count: Int): Matcher<View> {
        return object : BoundedMatcher<View, RecyclerView>(RecyclerView::class.java) {
            override fun describeTo(description: Description?) {
                description?.appendText("$count items")
            }

            override fun matchesSafely(recyclerView: RecyclerView?): Boolean {
                return recyclerView?.adapter?.itemCount == count
            }
        }
    }

    /**
     * Returns a matcher that matches [View] that contains view at specified position
     * in RecyclerView associated with the given id.
     */
    fun atPosition(position: Int, itemMatcher: Matcher<View>): Matcher<View> {
        return object : BoundedMatcher<View, RecyclerView>(RecyclerView::class.java) {
            override fun describeTo(description: Description?) {
                description?.appendText("$itemMatcher at position: $position")
            }

            override fun matchesSafely(recyclerView: RecyclerView?): Boolean {
                val viewHolder = recyclerView?.findViewHolderForAdapterPosition(position)
                return itemMatcher.matches(viewHolder?.itemView)
            }
        }
    }
}