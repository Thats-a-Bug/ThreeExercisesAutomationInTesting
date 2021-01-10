package exercises.exerciseOneLoginPage.stepFour.pages.secureAreaPage

import exercises.exerciseOneLoginPage.stepFour.pages.Page
import exercises.exerciseOneLoginPage.stepFour.pages.loginPage.LoginPage
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class SecureAreaPage(driver: WebDriver): Page(driver) {

    init {
        initPage()
        waitElements()
    }

    private val logoutButton: WebElement
        get() = baseLocator.findElement(By.cssSelector(".button.secondary.radius"))


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

    private fun waitTitle(wait: WebDriverWait) {
        wait.until(ExpectedConditions.visibilityOf(titleElement))
    }

    private fun waitSubtitle(wait: WebDriverWait) {
        wait.until(ExpectedConditions.visibilityOf(subTitleElement))
    }

    fun logout(): LoginPage {
        logoutButton.click()
        return LoginPage(driver)
    }
}