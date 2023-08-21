package com.example.myapplicationcompara

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    @Rule
    @JvmField
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
        // Configuración previa a las pruebas
    }

    @After
    fun tearDown() {
        // Limpieza después de las pruebas
    }

    @Test
    fun btnRestart_ok() {
        Espresso.onView(
            ViewMatchers.withId(R.id.inputTextPrimero)
        ).perform(
            ViewActions.typeText("Hola")
        )
        Espresso.onView(
            ViewMatchers.withId(R.id.inputTextSegundo)
        ).perform(
            ViewActions.typeText("Pocho")
        )
        Espresso.closeSoftKeyboard()

        Espresso.onView(
            ViewMatchers.withId(R.id.btnCompara)
        ).perform(
            ViewActions.click()
        )
        Espresso.onView(
            ViewMatchers.withId(R.id.btnRestart)
        ).perform(
            ViewActions.click()
        )

        //Ahora el chack de todo
        Espresso.onView(
            ViewMatchers.withId(R.id.inputTextPrimero)
        ).check(ViewAssertions.matches(ViewMatchers.withText("")))

        Espresso.onView(
            ViewMatchers.withId(R.id.inputTextSegundo)
        ).check(ViewAssertions.matches(ViewMatchers.withText("")))

        Espresso.onView(
            ViewMatchers.withId(R.id.txtRespuesta)
        ).check(ViewAssertions.matches(ViewMatchers.withText("")))
    }

    @Test
    fun compara_ok() {
        Espresso.onView(
            ViewMatchers.withId(R.id.inputTextPrimero)
        ).perform(
            ViewActions.typeText("Hola")
        )
        Espresso.onView(
            ViewMatchers.withId(R.id.inputTextSegundo)
        ).perform(
            ViewActions.typeText("Hola   ")
        )
        Espresso.closeSoftKeyboard()

        Espresso.onView(
            ViewMatchers.withId(R.id.btnCompara)
        ).perform(
            ViewActions.click()
        )

        //Ver si compara bien con el trim y todo.
        Espresso.onView(
            ViewMatchers.withId(R.id.txtRespuesta)
        ).check(ViewAssertions.matches(ViewMatchers.withText("Los textos son iguales")))
    }

    @Test
    fun compara_distinto() {
        Espresso.onView(
            ViewMatchers.withId(R.id.inputTextPrimero)
        ).perform(
            ViewActions.typeText("Hola")
        )
        Espresso.onView(
            ViewMatchers.withId(R.id.inputTextSegundo)
        ).perform(
            ViewActions.typeText("OtroHola")
        )
        Espresso.closeSoftKeyboard()

        Espresso.onView(
            ViewMatchers.withId(R.id.btnCompara)
        ).perform(
            ViewActions.click()
        )

        //Textos no son iguales test
        Espresso.onView(
            ViewMatchers.withId(R.id.txtRespuesta)
        ).check(ViewAssertions.matches(ViewMatchers.withText("Los textos NO SON IGUALES")))
    }
}


