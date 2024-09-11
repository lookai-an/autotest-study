import io.appium.java_client.ios.IOSDriver
import org.example.mobile.DriverManager
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import java.time.Duration

class iOSdrivertest {

    private lateinit var driver: IOSDriver

    @BeforeMethod
    fun setUp() {
        driver = DriverManager.createDriver(DriverManager.Platform.IOS) as IOSDriver
    }

    @Test
    fun sampleTest() {
        val wait = WebDriverWait(driver, Duration.ofSeconds(10)) // java.time.Duration.ofSeconds(10)을 사용합니다.

        // IntegerA 텍스트 필드 찾기 및 입력
        val integerAField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeTextField[@name='IntegerA']")))
        integerAField.click()
        integerAField.sendKeys("100")

        // IntegerB 텍스트 필드 찾기 및 입력
        val integerBField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeTextField[@name='IntegerB']")))
        integerBField.click()
        integerBField.sendKeys("100")

        // ComputeSumButton 버튼 찾기 및 클릭
        val computeSumButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeButton[@name='ComputeSumButton']")))
        computeSumButton.click()

        // 결과 확인을 위한 대기
        Thread.sleep(2000)
    }

    @AfterMethod
    fun tearDown() {
        DriverManager.quitDriver()
    }
}
