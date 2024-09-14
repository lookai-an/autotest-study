import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.ios.IOSDriver
import org.example.mobile.DriverManager
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import java.time.Duration

class AndroidDriverTest {

    private lateinit var driver: AndroidDriver

    @BeforeMethod
    fun setUp() {
        driver = DriverManager.createDriver(DriverManager.Platform.ANDROID) as AndroidDriver
    }

    @Test
    fun sampleTest() {
        val wait = WebDriverWait(driver, Duration.ofSeconds(10))

        // "App" 요소 찾기 및 클릭
        val appElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@content-desc='App']")))
        appElement.click()

        // "Activity" 요소 찾기 및 클릭
        val activityElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@content-desc='Activity']")))
        activityElement.click()

        // "Custom Title" 요소 찾기 및 클릭
        val customTitleElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@content-desc='Custom Title']")))
        customTitleElement.click()

        // "Left is best" EditText 찾기 및 "타이틀" 입력
        val leftEditText = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@content-desc='Left is best']")))
        leftEditText.clear()
        leftEditText.sendKeys("타이틀")

        // "Change Left" 버튼 찾기 및 클릭
        val changeLeftButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@content-desc='Change Left']")))
        changeLeftButton.click()

        // "Right is always right" EditText 찾기 및 "서브타이틀" 입력
        val rightEditText = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@content-desc='Right is always right']")))
        rightEditText.clear()
        rightEditText.sendKeys("서브타이틀")

        // "Change Right" 버튼 찾기 및 클릭
        val changeRightButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@content-desc='Change Right']")))
        changeRightButton.click()

        // 입력 확인을 위한 대기
        Thread.sleep(1000)
    }

    @AfterMethod
    fun tearDown() {
        DriverManager.quitDriver()
    }
}
