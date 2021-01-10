package exercises.exerciseOneLoginPage.stepTwo.pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class SecureAreaPage(driver: WebDriver): Page(driver) {

    init {
        initPage()
    }

    val titleText: String
        get() = baseLocator.findElement(By.tagName("h2")).text

    val subtitleText: String
        get() = baseLocator.findElement(By.tagName("h4")).text
}