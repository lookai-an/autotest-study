package org.example.mobile

import Element
import io.appium.java_client.android.AndroidDriver
import org.example.mobile.ActionUtil
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

class View(private val driver: AndroidDriver, private val platform: String) {

    private val app = Element()
    private val activity = Element()
    private val customTitle = Element()
    private val leftEditText = Element()
    private val rightEditText = Element()
    private val changeLeftButton = Element()
    private val changeRightButton = Element()

    init {
        app.android("CONTAINS_TEXT", "App")
        activity.android("CONTAINS_TEXT", "Activity")
        customTitle.android("CONTAINS_TEXT", "Custom Title")
        leftEditText.android("CONTAINS_TEXT", "Left is best")
        changeLeftButton.android("CONTAINS_TEXT", "Change Left")
        rightEditText.android("CONTAINS_TEXT", "Right is always right")
        changeRightButton.android("CONTAINS_TEXT", "Change Right")
    }

    fun appStart() {
        tap(app)
    }

    fun navigateToActivity() {
        tap(activity)
    }

    fun openCustomTitle() {
        tap(customTitle)
    }

    fun changeLeftButton() {
        tap(changeLeftButton) // 탭을 통해 포커스 주기
    }


    fun changeRightButton() {
        tap(changeRightButton) // 탭을 통해 포커스 주기
    }

    private fun tap(element: Element) {
        ActionUtil.tap(driver, element.getLocator(platform))
    }
}
