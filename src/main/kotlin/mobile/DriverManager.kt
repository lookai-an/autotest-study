package org.example.mobile

import io.appium.java_client.AppiumDriver
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.remote.options.BaseOptions
import java.net.MalformedURLException
import java.net.URL

object DriverManager {

    private var driver: AppiumDriver? = null

    enum class Platform {

        ANDROID, IOS
    }

    fun createDriver(platform: Platform): AppiumDriver {
        driver = when (platform) {
            Platform.ANDROID -> createAndroidDriver()
            Platform.IOS -> createIOSDriver()
        }
        return driver ?: throw RuntimeException("Driver creation failed")
    }

    private fun createAndroidDriver(): AndroidDriver {
        val options = BaseOptions().apply {
            amend("platformName", "Android")
            amend("appium:platformVersion", "14.0")
            amend("appium:deviceName", "Pixel 8 Pro API 34")
            amend("appium:automationName", "UiAutomator2")
            amend("appium:udid", "emulator-5554")
            amend("appium:app", "/Users/lookai.an/Downloads/ApiDemos-debug (1).apk")
            amend("appium:ensureWebviewsHavePages", true)
            amend("appium:nativeWebScreenshot", true)
            amend("appium:newCommandTimeout", 3600)
            amend("appium:connectHardwareKeyboard", true)
        }
        return AndroidDriver(getUrl(), options)
    }

    private fun createIOSDriver(): IOSDriver {
        val options = BaseOptions().apply {
            amend("platformName", "iOS")
            amend("appium:platformVersion", "17.5")
            amend("appium:automationName", "XCuiTest")
            amend("appium:udid", "DFCA086C-A7FF-414C-B26D-B965B8692E31")
            amend("appium:app", "/Users/lookai.an/Downloads/TestApp.app")
            amend("appium:includeSafariInWebviews", true)
            amend("appium:newCommandTimeout", 3600)
            amend("appium:connectHardwareKeyboard", true)
        }
        return IOSDriver(getUrl(), options)
    }

    // 드라이버 가져오기
    fun getDriver(): AppiumDriver {
        return driver ?: throw RuntimeException("Driver not initialized")
    }

    // 드라이버 종료
    fun quitDriver() {
        driver?.quit()
        driver = null
    }

    private fun getUrl(): URL {
        return try {
            URL("http://127.0.0.1:4723")
        } catch (e: MalformedURLException) {
            e.printStackTrace()
            throw RuntimeException("Invalid URL")
        }
    }
}
