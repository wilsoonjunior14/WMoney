package wmoney.wilson.com.wmoney

import android.app.Activity
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.provider.ContactsContract
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.*
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import models.User
import org.hamcrest.core.AllOf.*
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import utils.Database
import wmoney.wilson.com.wmoney.utils.Builders.UserBuilder

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    lateinit var user: User
    lateinit var activity: Class<MainActivity>
    lateinit var email: String
    lateinit var password: String
    lateinit var database: Database
    lateinit var context: Context

    @Before
    fun init(){
        activity = MainActivity::class.java
        context  = InstrumentationRegistry.getInstrumentation().targetContext
        ActivityScenario.launch(activity)

        user = User(context,
                0,
                "",
                "",
                "")

        database = Database(context)

    }

    fun insert_values(){
        // insert values
        for (item in UserBuilder().getValidUsers(context)){
            user.save(item as Object)
        }
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

    @Test
    fun test_login_with_email_invalid(){

        // insert values on database
        insert_values()

        email    = "wjunior_msnhotmail.com"
        password = "12345"

        val findLogin = user.findLogin(email, password)
        assertNotNull(findLogin)
        Thread.sleep(2000)
    }

    @After
    fun finally(){
        context.deleteDatabase(database.name_database)
    }

}
