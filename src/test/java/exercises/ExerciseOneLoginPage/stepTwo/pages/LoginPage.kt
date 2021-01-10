package exercises.ExerciseOneLoginPage.stepTwo.pages

import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver

class LoginPage(private val driver: ChromeDriver) {

    init {
        driver.get("https://the-internet.herokuapp.com/login")
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
        driver.findElement(By.id("username")).sendKeys(username)
    }

    private fun fillPasswordField(password: String) {
        driver.findElement(By.id("password")).sendKeys(password)
    }

    private fun performLogin() {
        driver.findElement(By.tagName("button")).click()
    }

    private fun waitLoggedInPage() {
        Thread.sleep(2000)
    }
}