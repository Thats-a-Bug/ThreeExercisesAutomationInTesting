package exercises.exerciseOneLoginPage.stepThree.pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

abstract class Page(protected val driver: WebDriver) {
    protected lateinit var baseLocator: WebElement

    fun initPage() {
        baseLocator = driver.findElement(By.tagName("body"))
    }

}