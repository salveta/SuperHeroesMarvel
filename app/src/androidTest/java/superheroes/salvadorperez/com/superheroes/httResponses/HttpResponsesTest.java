package superheroes.salvadorperez.com.superheroes.httResponses;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.test.InstrumentationTestCase;

import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import superheroes.salvadorperez.com.superheroes.R;
import superheroes.salvadorperez.com.superheroes.ui.superHeroeList.ShListActivity;
import superheroes.salvadorperez.com.superheroes.ui.superHeroeList.ShModel;
import superheroes.salvadorperez.com.superheroes.ui.superHeroeList.ShPresenter;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.mockito.Mockito.verify;


/**
 * Created by Salva on 15/01/2018.
 */

public class HttpResponsesTest extends InstrumentationTestCase {

    ShPresenter presenter;

    @Mock
    ShListActivity view;

    @Mock
    ShModel model;

    @Rule
    public ActivityTestRule<ShListActivity> mActivityRule = new ActivityTestRule<>(ShListActivity.class, true, false);
    private MockWebServer server;
    private String url = "https://api.myjson.com/bins/bvyob/";

    @Before
    public void setUp() throws Exception {
        super.setUp();
        MockitoAnnotations.initMocks(this);

        presenter = new ShPresenter(view, model);
        server = new MockWebServer();
        server.start();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        url = server.url("/").toString();
    }

    @After
    public void tearDown() throws Exception {
        server.shutdown();
    }

    @Test
    public void testSuperHeroeIsShown() throws Exception {
        String fileName = "ok_response.json";
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(RestServiceTestHelper.getStringFromFile(getInstrumentation().getContext(), fileName)));

        Intent intent = new Intent();
        mActivityRule.launchActivity(intent);

        onView(withId(R.id.rv_list_super_heroes)).check(matches(isDisplayed()));
    }

    @Test
    public void testMethodNotAllowed() throws Exception {
        String fileName = "405_not_allowed.json";

        server.enqueue(new MockResponse()
                .setResponseCode(405)
                .setBody(RestServiceTestHelper.getStringFromFile(getInstrumentation().getContext(), fileName)));

        Intent intent = new Intent();
        mActivityRule.launchActivity(intent);

        presenter.onFailure("");
        verify(view).hideLoading();
        verify(view).emptySuperHeroesList();
    }
}
