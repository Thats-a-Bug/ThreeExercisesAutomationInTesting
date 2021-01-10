package exercises.`1LoginPage`.stepZero

import exercises.TestBase
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import assertk.assertThat

class LoginPageTest: TestBase() {

    @Test
    fun performLoginTest() {
        driver.get("https://the-internet.herokuapp.com/login")

        driver.findElement(By.id("username")).sendKeys("tomsmith")
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!")
        driver.findElement(By.tagName("button")).click()

        Thread.sleep(2000)

        assertThat(driver.findElement(By.tagName("h2")).equals("Secure Area"))
        assertThat(driver.findElement(By.tagName("h4")).equals("Welcome to the Secure Area. When you are done click logout below."))
    }
}