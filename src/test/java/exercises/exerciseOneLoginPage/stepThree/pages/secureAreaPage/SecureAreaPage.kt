package exercises.exerciseOneLoginPage.stepThree.pages.secureAreaPage

import exercises.exerciseOneLoginPage.stepThree.pages.Page
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration
import java.time.temporal.TemporalUnit
import java.util.concurrent.TimeUnit

class SecureAreaPage(driver: WebDriver): Page(driver) {

    init {
        initPage()
        waitElements()
    }

    val titleText: String
        get() = titleElement.text

    private val titleElement: WebElement
        get() = baseLocator.findElement(By.tagName("h2"))

    val subtitleText: String
        get() = subTitleElement.text

    private val subTitleElement: WebElement
        get() = baseLocator.findElement(By.tagName("h4"))

    private fun waitElements() {
        val wait = createWait()
        waitTitle(wait)
        waitSubtitle(wait)
    }

    private fun createWait() = WebDriverWait(driver, Duration.ofSeconds(2L))

    private fun waitTitle(wait: WebDriverWait) {
        wait.until(ExpectedConditions.visibilityOf(titleElement))
    }

    private fun waitSubtitle(wait: WebDriverWait) {
        wait.until(ExpectedConditions.visibilityOf(subTitleElement))
    }
}