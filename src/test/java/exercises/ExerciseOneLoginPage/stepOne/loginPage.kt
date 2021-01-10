package exercises.ExerciseOneLoginPage.stepOne

import exercises.TestBase
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import assertk.assertThat

class LoginPageTest: TestBase() {

    @Test
    fun performLoginTest() {
        accessLoginPage()

        login(username = "tomsmith", password = "SuperSecretPassword!")

        verifyLoggedPageElements(
            title = "Secure Area",
            subtitle = "Welcome to the Secure Area. When you are done click logout below."
        )
    }

    private fun accessLoginPage() {
        driver.get("https://the-internet.herokuapp.com/login")
    }

    private fun login(username: String, password: String) {
        fillFields(username = username, password = password)
        performLogin()
        waitLoggedInPage()
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

    private fun verifyLoggedPageElements(title: String, subtitle: String) {
        verifyTitle(title)
        verifySubTitle(subtitle)
    }

    private fun verifyTitle(title: String) {
        assertThat(driver.findElement(By.tagName("h2")).equals(title))
    }

    private fun verifySubTitle(subtitle: String) {
        assertThat(
            driver.findElement(By.tagName("h4"))
                .equals(subtitle)
        )
    }

}