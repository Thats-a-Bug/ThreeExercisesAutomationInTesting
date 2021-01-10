package exercises.exerciseOneLoginPage.stepThree.pages.loginPage

import exercises.exerciseOneLoginPage.stepThree.data.UserCredentials
import exercises.exerciseOneLoginPage.stepThree.pages.Page
import exercises.exerciseOneLoginPage.stepThree.pages.secureAreaPage.SecureAreaPage
import exercises.exerciseOneLoginPage.stepThree.pages.loginPage.components.LoginForm
import org.openqa.selenium.WebDriver

class LoginPage(driver: WebDriver): Page(driver) {

    private var loginForm: LoginForm

    init {
        driver.get("https://the-internet.herokuapp.com/login")
        initPage()
        loginForm = LoginForm(baseLocator)
    }

    fun login(userCredentials: UserCredentials): SecureAreaPage {
        loginForm.login(userCredentials)
        return SecureAreaPage(driver)
    }
}