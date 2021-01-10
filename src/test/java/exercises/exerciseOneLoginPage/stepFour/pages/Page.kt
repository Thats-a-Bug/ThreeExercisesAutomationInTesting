package exercises.exerciseOneLoginPage.stepFour.pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

abstract class Page(protected val driver: WebDriver) {
    protected lateinit var baseLocator: WebElement

    fun initPage() {
        baseLocator = driver.findElement(By.tagName("body"))
    }

    protected fun createWait() = WebDriverWait(driver, Duration.ofSeconds(2L))
}