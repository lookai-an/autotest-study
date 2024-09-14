package org.example.mobile

fun main() {
    // Android 드라이버 생성
    val androidDriver = DriverManager.createDriver(DriverManager.Platform.ANDROID)
    println("Android Driver created: $androidDriver")

    // Android 드라이버를 사용하여 테스트를 수행
    // 예를 들어, driver.findElement(...) 또는 driver.get(...) 등을 사용

    // Android 드라이버 종료
    DriverManager.quitDriver()

    // iOS 드라이버 생성
    val iosDriver = DriverManager.createDriver(DriverManager.Platform.IOS)
    println("iOS Driver created: $iosDriver")

    // iOS 드라이버를 사용하여 테스트를 수행
    // 예를 들어, driver.findElement(...) 또는 driver.get(...) 등을 사용

    // iOS 드라이버 종료
    DriverManager.quitDriver()
}
