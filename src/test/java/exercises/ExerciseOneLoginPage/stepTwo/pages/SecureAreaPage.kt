package exercises.ExerciseOneLoginPage.stepTwo.pages

import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver

class SecureAreaPage(private val driver: ChromeDriver) {
    val titleText: String
        get() = driver.findElement(By.tagName("h2")).text

    val subtitleText: String
        get() = driver.findElement(By.tagName("h4")).text
}