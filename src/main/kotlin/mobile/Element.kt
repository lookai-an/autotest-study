import io.appium.java_client.android.AndroidDriver
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class Element {
    private var androidBy: By? = null
    private var iosBy: By? = null

    fun android(strategy: String, value: String) {
        androidBy = when (strategy) {
            "CONTAINS_TEXT" -> By.xpath("//*[contains(@text, '$value')]")
            else -> throw IllegalArgumentException("Unknown strategy: $strategy")
        }
    }

    fun ios(strategy: String, value: String) {
        iosBy = when (strategy) {
            "CONTAINS_TEXT" -> By.xpath("//*[contains(@label, '$value')]")
            else -> throw IllegalArgumentException("Unknown strategy: $strategy")
        }
    }

    fun getLocator(platform: String): By {
        return when (platform) {
            "android" -> androidBy ?: throw IllegalStateException("Android locator not set")
            "ios" -> iosBy ?: throw IllegalStateException("iOS locator not set")
            else -> throw IllegalArgumentException("Unknown platform: $platform")
        }
    }

    // WebElement 반환 메서드 추가
    fun getWebElement(driver: AndroidDriver, wait: WebDriverWait): WebElement {
        return wait.until(ExpectedConditions.presenceOfElementLocated(getLocator("android"))) // 플랫폼에 따라 조건을 설정
    }
}
