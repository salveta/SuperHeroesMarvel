package superheroes.salvadorperez.com.superheroes;

import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;

import com.jakewharton.espresso.OkHttp3IdlingResource;

import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;

import superheroes.salvadorperez.com.superheroes.rest.OkHttpProvider;
import superheroes.salvadorperez.com.superheroes.ui.superHeroeList.ShListActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.is;


/**
 * Created by Salva on 15/01/2018.
 */

public class ShListActivityTest {

    public static final String USER_NAME = "Captain America";

    @Rule
    public final ActivityTestRule mActivityRule = new ActivityTestRule<>(ShListActivity.class);

    @Test
    public void testExpectedItem()  throws IOException {
        onView(withId(R.id.rv_list_super_heroes)).check(matches(isDisplayed()));
        onView(allOf(isDescendantOfA(withId(R.id.rv_list_super_heroes)), withText(is(USER_NAME))));
    }

    @Test
    public void scrollToPositionAndClick() {
        IdlingResource idlingResource = OkHttp3IdlingResource.create("okhttp", OkHttpProvider.getOkHttpInstance());
        IdlingRegistry.getInstance().register(idlingResource);

        onView(withId(R.id.rv_list_super_heroes)).check(ViewAssertions.matches(isDisplayed()));

        onView(withId(R.id.rv_list_super_heroes)).perform(
                RecyclerViewActions.scrollToPosition(4),
                RecyclerViewActions.actionOnItemAtPosition(4, click())
        );

        IdlingRegistry.getInstance().unregister(idlingResource);
    }
}
