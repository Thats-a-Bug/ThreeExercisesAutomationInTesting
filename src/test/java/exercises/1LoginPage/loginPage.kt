package exercises.`1LoginPage`

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

class LoginPageTest {

    private lateinit var driver: ChromeDriver

    @BeforeEach
    fun setupBrowser() {
        val options = ChromeOptions()
        options.setBinary("/usr/bin/brave")
        driver = ChromeDriver(options)
        driver.manage().window().maximize()
    }

    @AfterEach
    fun killBrowser() {
        driver.quit()
    }

    @Test
    fun shouldShowSimpleAssertion() {
        driver.get("http://www.thatsabug.com")
    }
}