package mobile.android.codechalangeandroid.activity;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import mobile.android.codechalangeandroid.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class LowestPathActivityTest {

    @Rule
    public ActivityTestRule<LowestPathActivity> mActivityTestRule = new ActivityTestRule<>(LowestPathActivity.class);

    @Test
    public void lowestPathActivityTest() {
        ViewInteraction editText = onView(
                allOf(withId(R.id.matrixX), withText("0"), isDisplayed()));
        editText.perform(click());

        ViewInteraction editText2 = onView(
                allOf(withId(R.id.matrixX), withText("0"), isDisplayed()));
        editText2.perform(replaceText("2"));

        ViewInteraction editText3 = onView(
                allOf(withId(R.id.matrixY), withText("0"), isDisplayed()));
        editText3.perform(replaceText("2"));

        ViewInteraction button = onView(
                allOf(withId(R.id.openTable), withText("Open Table"), isDisplayed()));
        button.perform(click());



        ViewInteraction button2 = onView(
                allOf(withId(R.id.button_one), withText("6"), isDisplayed()));
        button2.perform(click());

        ViewInteraction button3 = onView(
                allOf(withId(R.id.button_two), withText("7"), isDisplayed()));
        button3.perform(click());

        ViewInteraction button4 = onView(
                allOf(withId(R.id.button_three), withText("8"), isDisplayed()));
        button4.perform(click());

        ViewInteraction button5 = onView(
                allOf(withId(R.id.button_four), withText("9"), isDisplayed()));
        button5.perform(click());

        ViewInteraction button6 = onView(
                allOf(withId(R.id.button_two), withText("2"), isDisplayed()));
        button6.perform(click());

        ViewInteraction button7 = onView(
                allOf(withId(R.id.button_four), withText("4"), isDisplayed()));
        button7.perform(click());

        ViewInteraction button8 = onView(
                allOf(withId(R.id.output), withText("Output"), isDisplayed()));
        button8.perform(click());

    }

}
