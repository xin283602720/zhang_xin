package core;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
public class Start {
    ;
//    @BeforeMethod
//    public void startChrome() throws Exception {
//        System.setProperty( "webdriver.ie.driver", "src/test/java/suittool/IEDriverServer.exe" );
//        DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
//        ieCapabilities.setCapability( InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true );
//        wr = new InternetExplorerDriver( ieCapabilities );
//    }
    public WebDriver startChrome(String URL, String usercode, WebDriver wr) throws Exception {
//        System.setProperty("webdriver.ie.driver", "src/test/java/suittool/iedriver.exe");
//        DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
//        ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
//        wr = new InternetExplorerDriver(ieCapabilities);
        URL url = new URL("http://192.168.57.131:6666/wd/hub");
        wr = new RemoteWebDriver(url, DesiredCapabilities.internetExplorer());
        wr.manage().window().maximize();
        wr.get(URL);
        Util.logIn(usercode,wr);
//        Util.logInTest("点击", wr);
        return wr;
    }
}
