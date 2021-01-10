package exercises

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

abstract class TestBase {
    protected lateinit var driver: ChromeDriver

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
}