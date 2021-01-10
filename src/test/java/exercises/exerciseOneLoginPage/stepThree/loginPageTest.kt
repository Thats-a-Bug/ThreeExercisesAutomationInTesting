package exercises.exerciseOneLoginPage.stepThree

import exercises.TestBase
import org.junit.jupiter.api.Test
import assertk.assertThat
import assertk.assertions.isEqualTo
import exercises.exerciseOneLoginPage.stepThree.data.UserCredentials
import exercises.exerciseOneLoginPage.stepThree.pages.loginPage.LoginPage
import exercises.exerciseOneLoginPage.stepThree.pages.secureAreaPage.SecureAreaPage

class LoginPageTest: TestBase() {

    @Test
    fun performLoginTest() {
        val loginPage = LoginPage(driver)

        val secureAreaPage = loginPage.login(makeUserCredentials())

        verifyLoggedPageElements(
            secureAreaPage = secureAreaPage,
            title = "Secure Area",
            subtitle = "Welcome to the Secure Area. When you are done click logout below."
        )
    }

    private fun makeUserCredentials() = UserCredentials(username = "tomsmith", password = "SuperSecretPassword!")

    private fun verifyLoggedPageElements(secureAreaPage: SecureAreaPage, title: String, subtitle: String) {
        verifyTitle(secureAreaPage = secureAreaPage, title = title)
        verifySubTitle(secureAreaPage = secureAreaPage, subtitle = subtitle)
    }

    private fun verifyTitle(title: String, secureAreaPage: SecureAreaPage) {
        assertThat(secureAreaPage.titleText).isEqualTo(title)
    }

    private fun verifySubTitle(subtitle: String, secureAreaPage: SecureAreaPage) {
        assertThat(secureAreaPage.subtitleText).isEqualTo(subtitle)
    }

}