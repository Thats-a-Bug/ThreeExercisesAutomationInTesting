package exercises.ExerciseOneLoginPage.stepTwo

import exercises.TestBase
import org.junit.jupiter.api.Test
import assertk.assertThat
import exercises.ExerciseOneLoginPage.stepTwo.pages.LoginPage
import exercises.ExerciseOneLoginPage.stepTwo.pages.SecureAreaPage

class LoginPageTest: TestBase() {

    @Test
    fun performLoginTest() {
        val loginPage = LoginPage(driver)

        val secureAreaPage = loginPage.login(username = "tomsmith", password = "SuperSecretPassword!")

        verifyLoggedPageElements(
            secureAreaPage = secureAreaPage,
            title = "Secure Area",
            subtitle = "Welcome to the Secure Area. When you are done click logout below."
        )
    }

    private fun verifyLoggedPageElements(secureAreaPage: SecureAreaPage, title: String, subtitle: String) {
        verifyTitle(secureAreaPage = secureAreaPage, title = title)
        verifySubTitle(secureAreaPage = secureAreaPage, subtitle = subtitle)
    }

    private fun verifyTitle(title: String, secureAreaPage: SecureAreaPage) {
        assertThat(secureAreaPage.titleText).equals(title)
    }

    private fun verifySubTitle(subtitle: String, secureAreaPage: SecureAreaPage) {
        assertThat(secureAreaPage.subtitleText).equals(subtitle)
    }

}