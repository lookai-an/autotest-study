package org.example.mobile

import io.appium.java_client.android.AndroidDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

class AppiumTest {

    private lateinit var driver: AndroidDriver
    private lateinit var view: View
    private val platform = "android"

    @BeforeMethod
    fun setUp() {
        driver = DriverManager.createDriver(DriverManager.Platform.ANDROID) as AndroidDriver
        view = View(driver, platform)  // View 클래스 초기화
    }

    @Test
    fun sampleTest3() {
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))
        // View 파일에 정의된 동작들 호출
        view.appStart()
        view.navigateToActivity()
        view.openCustomTitle()

        // "Left is best" EditText 찾기 및 "타이틀" 입력
        val leftEditText = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@content-desc='Left is best']")))
        leftEditText.clear()
        leftEditText.sendKeys("타이틀")
        view.changeLeftButton()

        // "Right is always right" EditText 찾기 및 "서브타이틀" 입력
        val rightEditText = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@content-desc='Right is always right']")))
        rightEditText.clear()
        rightEditText.sendKeys("서브타이틀")
        view.changeRightButton()

        Thread.sleep(1000)
    }

    @AfterMethod
    fun tearDown() {
        DriverManager.quitDriver()
    }
}
