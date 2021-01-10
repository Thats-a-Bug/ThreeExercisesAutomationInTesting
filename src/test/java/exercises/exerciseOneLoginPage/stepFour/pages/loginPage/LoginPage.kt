package exercises.exerciseOneLoginPage.stepFour.pages.loginPage

import exercises.exerciseOneLoginPage.stepFour.data.UserCredentials
import exercises.exerciseOneLoginPage.stepFour.pages.Page
import exercises.exerciseOneLoginPage.stepFour.pages.secureAreaPage.SecureAreaPage
import exercises.exerciseOneLoginPage.stepFour.pages.loginPage.components.LoginForm
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class LoginPage(driver: WebDriver): Page(driver) {

    private var loginForm: LoginForm

    val flashBannerText: String
        get() = flashBanner.text

    private val flashBanner
        get() = baseLocator.findElement(By.id("flash"))

    init {
        initPage()
        loginForm = LoginForm(baseLocator)
    }

    fun login(userCredentials: UserCredentials): SecureAreaPage {
        loginForm.login(userCredentials)
        return SecureAreaPage(driver)
    }

    companion object {
        fun accessPage(driver: WebDriver): LoginPage {
            driver.get("https://the-internet.herokuapp.com/login")
            return LoginPage(driver)
        }
    }
}