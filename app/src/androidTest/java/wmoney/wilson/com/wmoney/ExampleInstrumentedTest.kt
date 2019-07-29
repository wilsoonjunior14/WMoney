package wmoney.wilson.com.wmoney

import android.app.Activity
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.*
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.core.AllOf.*
import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    lateinit var activity: Class<MainActivity>

    @Before
    fun init(){
        activity = MainActivity::class.java
        ActivityScenario.launch(activity)
    }


    @Test
    fun test_label_registry_is_displayed(){

        onView(withId(R.id.add))
                .check(matches(isDisplayed()))
    }

    @Test
    fun test_button_click_and_typing_text_on_email_and_password(){

        onView(withId(R.id.email))
                .perform(typeText("wjunior_msn@hotmail.com"))

        onView(withId(R.id.password))
                .perform(typeText("12345"))

        onView(withId(R.id.btnLogin))
                .perform(click())

    }

}
