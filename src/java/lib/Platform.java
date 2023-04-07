package lib;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Platform {
    private static final String
            APPIUM_URL = "http://127.0.0.1:4723/wd/hub",
            PLATFORM_ANDROID = "android",
            PLATFORM_ANDROID_MOBILE_WEB = "mobile_android_web",
            PLATFORM_MOBILE_WEB_VIEW = "mobile_web_view",
            PLATFORM_WEB = "web",
            PLATFORM_IOS = "ios";
    private static Platform instance;

    private Platform() {
    }

    public static Platform getInstance() {
        if (instance == null) {
            instance = new Platform();
        }
        return instance;
    }

    public RemoteWebDriver getDriver() throws Exception {
        URL URL = new URL(APPIUM_URL);
        if (this.isAndroid()) {
            return new AndroidDriver(URL, this.getAndroidDesireCapabilities());
        } else if (this.isIOS()) {
            return new IOSDriver(URL, this.getIOSDesiredCapabilities());
        } else if (this.isAndroidMobileWeb()){
            return new AndroidDriver<>(URL, this.getAndroidMobileWebCapabilities());
        } else if (this.isMobileWebView()){
            return new ChromeDriver(this.getMWChromeOptions());
        } else if (this.isWEB()){
            return this.getWEBCapabilities();
        }
        else {
            throw new Exception("Cannot detect the type of driver. Platform value: " + this.getPlatformVar());
        }
    }

    public boolean isAndroid() {
        return isPlatform(PLATFORM_ANDROID);
    }

    public boolean isIOS() {
        return isPlatform(PLATFORM_IOS);
    }

    public boolean isWEB(){
        return isPlatform(PLATFORM_WEB);
    }

    public boolean isAndroidMobileWeb(){
        return isPlatform(PLATFORM_ANDROID_MOBILE_WEB);
    }
    public boolean isMobileWebView(){
        return isPlatform(PLATFORM_MOBILE_WEB_VIEW);
    }

    private DesiredCapabilities getAndroidDesireCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Google Nexus 5");
        capabilities.setCapability("platformVersion", "11.0");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "bbc.mobile.news.ww");
        capabilities.setCapability("appActivity", "bbc.mobile.news.v3.app.TopLevelActivity");
        capabilities.setCapability("app", "/Users/bogoutdinovruslan/IdeaProjects/UIAutomationProject/apk/bbc_news.apk");
        capabilities.setCapability("appium:ignoreHiddenApiPolicyError", true);

        if (this.isAndroid()) {
            capabilities.setCapability("noReset", "false");
        } else if (this.isIOS()) {
            capabilities.setCapability("noReset", "false");
        }
        return capabilities;
    }

    private DesiredCapabilities getIOSDesiredCapabilities() {
        // Here should be declared iOS capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        return capabilities;
    }

    private DesiredCapabilities getAndroidMobileWebCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, BrowserType.ANDROID);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus5API29");
        capabilities.setCapability(MobileCapabilityType.VERSION, "12.0");
        capabilities.setCapability("automationName", "UiAutomator2");
        //capabilities.setCapability("chromedriverExecutable", "C:\\Users\\Ruslan\\Desktop\\Automation\\Tools\\chromedrivers\\chromedrivers74\\chromedriver.exe");
        capabilities.setCapability("chromedriverExecutable", "/Users/bogoutdinovruslan/UIAutomationFiles/chromedrivers/chromedriver95/chromedriver");
        capabilities.setCapability("appium:ignoreHiddenApiPolicyError", true);
        return capabilities;
    }

    private ChromeOptions getMWChromeOptions(){
        Map<String, Object> deviceMetrics = new HashMap<>();
        deviceMetrics.put("width", 360);
        deviceMetrics.put("height", 640);
        deviceMetrics.put("pixelRatio", 3.0);

        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceMetrics", deviceMetrics);
        mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("window-size=360,640");

        return chromeOptions;
    }

    private ChromeDriver getWEBCapabilities(){
        System.setProperty("webdriver.chrome.driver","/Users/bogoutdinovruslan/UIAutomationFiles/chromedrivers/chromedriver111/chromedriver");
        ChromeDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.bbc.com/");

        return webDriver;
    }

    private boolean isPlatform(String myPlatform) {
        String platform = this.getPlatformVar();
        return myPlatform.equals(platform);
    }

    public String getPlatformVar() {
        return System.getenv("PLATFORM");
    }
}
