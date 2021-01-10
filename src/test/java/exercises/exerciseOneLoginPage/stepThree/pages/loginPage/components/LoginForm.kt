package exercises.exerciseOneLoginPage.stepThree.pages.loginPage.components

import exercises.exerciseOneLoginPage.stepThree.data.UserCredentials
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class LoginForm(baseLocator: WebElement) {
    private var baseLocator = baseLocator.findElement(By.id("login"))

    private val usernameField: WebElement
        get() = baseLocator.findElement(By.id("username"))

    private val passwordField: WebElement
        get() = baseLocator.findElement(By.id("password"))

    private val loginButton: WebElement
        get() = baseLocator.findElement(By.tagName("button"))

    fun login(userCredentials: UserCredentials) {
        fillFields(userCredentials)
        performLogin()
    }

    private fun fillFields(userCredentials: UserCredentials) {
        fillUsernameField(userCredentials.username)
        fillPasswordField(userCredentials.password)
    }

    private fun fillUsernameField(username: String) {
        usernameField.sendKeys(username)
    }

    private fun fillPasswordField(password: String) {
        passwordField.sendKeys(password)
    }

    private fun performLogin() {
        loginButton.click()
    }
}
