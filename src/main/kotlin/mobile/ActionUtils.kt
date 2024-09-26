package org.example.mobile

import io.appium.java_client.android.AndroidDriver
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

object ActionUtil {

    fun tap(driver: AndroidDriver, element: By) {
        val webElement: WebElement = driver.findElement(element)
        webElement.click()
    }

    fun swipe(driver: AndroidDriver, startX: Int, startY: Int, endX: Int, endY: Int) {
        val actions = Actions(driver)
        actions.moveByOffset(startX, startY)
            .clickAndHold()
            .moveByOffset(endX - startX, endY - startY)
            .release()
            .perform()
    }

    fun doubleTap(driver: AndroidDriver, element: By) {
        val webElement: WebElement = driver.findElement(element)
        val actions = Actions(driver)
        actions.moveToElement(webElement).click().pause(Duration.ofMillis(100)).click().perform()
    }

    fun pinchZoomIn(driver: AndroidDriver, element: By) {
        val webElement: WebElement = driver.findElement(element)
        // 핀치 줌 인 동작 구현
    }

    fun pinchZoomOut(driver: AndroidDriver, element: By) {
        val webElement: WebElement = driver.findElement(element)
        // 핀치 줌 아웃 동작 구현
    }

    fun sendKeys(driver: AndroidDriver, element: By, text: String) {
        val webElement: WebElement = driver.findElement(element)
        webElement.clear()
        webElement.sendKeys(text)
    }

    fun clearTextField(driver: AndroidDriver, locator: By) {
        val element = driver.findElement(locator)
        element.clear() // 기존 텍스트 지우기
    }

    fun waitForElement(driver: AndroidDriver, by: By, timeout: Long = 10): WebElement {
        return WebDriverWait(driver, Duration.ofSeconds(timeout))
            .until(ExpectedConditions.presenceOfElementLocated(by))
    }
}
