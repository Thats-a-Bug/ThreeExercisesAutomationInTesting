package exercises.exerciseOneLoginPage.stepTwo.pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class LoginPage(private val driver: WebDriver): Page(driver) {

    init {
        driver.get("https://the-internet.herokuapp.com/login")
        initPage()
    }

    fun login(username: String, password: String): SecureAreaPage {
        fillFields(username = username, password = password)
        performLogin()
        waitLoggedInPage()
        return SecureAreaPage(driver)
    }

    private fun fillFields(username: String, password: String) {
        fillUsernameField(username)
        fillPasswordField(password)
    }

    private fun fillUsernameField(username: String) {
        baseLocator.findElement(By.id("username")).sendKeys(username)
    }

    private fun fillPasswordField(password: String) {
        baseLocator.findElement(By.id("password")).sendKeys(password)
    }

    private fun performLogin() {
        baseLocator.findElement(By.tagName("button")).click()
    }

    private fun waitLoggedInPage() {
        Thread.sleep(2000)
    }
}