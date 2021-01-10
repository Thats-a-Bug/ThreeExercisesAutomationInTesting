package exercises.exerciseOneLoginPage.stepFour

import exercises.TestBase
import org.junit.jupiter.api.Test
import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isTrue
import exercises.exerciseOneLoginPage.stepFour.data.UserCredentials
import exercises.exerciseOneLoginPage.stepFour.pages.loginPage.LoginPage
import exercises.exerciseOneLoginPage.stepFour.pages.secureAreaPage.SecureAreaPage

class LoginPageTest: TestBase() {

    @Test
    fun performLoginTest() {
        val loginPage = LoginPage.accessPage(driver)

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

    @Test
    fun logoutTest() {
        val initialLoginPage = LoginPage.accessPage(driver)
        val secureAreaPage = initialLoginPage.login(makeUserCredentials())
        val loginPageAfterLogout = secureAreaPage.logout()
        verifyFlashMessage(loginPageAfterLogout)
    }

    private fun verifyFlashMessage(loginPageAfterLogout: LoginPage) {
        assertThat(loginPageAfterLogout.flashBannerText.contains("You logged out of the secure area!")).isTrue()
    }

}