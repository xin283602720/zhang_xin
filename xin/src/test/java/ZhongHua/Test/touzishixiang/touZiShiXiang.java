package ZhongHua.Test.touzishixiang;


import core.Base;
import core.Start;
import core.Util;
import implement.Login;
import implement.Science;
import implement.touZi;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

//import static core.Util.click;
public class touZiShiXiang {
    private static final Logger logger = LoggerFactory.getLogger(touZiShiXiang.class.getName());
//    WebDriver wr;
    WebDriver webDriver;
    int pageLoadTime = 15;

    @BeforeTest
    public void chushi() throws Exception {
//封装浏览器启动
        Start startt = new Start();
        webDriver = startt.startChrome(Science.URL_UAT5, "ganyingying");
//        URL url = new URL("http://192.168.57.131:6666/wd/hub");
//        wr = new RemoteWebDriver(url, DesiredCapabilities.internetExplorer());
//        wr.manage().timeouts().pageLoadTimeout(pageLoadTime,TimeUnit.SECONDS);
//        wr.get(Science.URL_UAT5);
//        Util.logIn("ganyingying", wr);
    }

    @Test
    public void add() {
//        wr.manage().timeouts().pageLoadTimeout(pageLoadTime, TimeUnit.SECONDS);
        Base.click(Login.PAGE_XMGL, webDriver);
        Util.click(touZi.TZSH,webDriver);
    }
}
