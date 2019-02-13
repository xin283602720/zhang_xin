package ZhongHua.Test.LiuChengAll;

import ZhongHua.Test.TestCASE.Htsq;
import core.Base;
import core.Start;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class LiuCheng extends Base {
    WebDriver wr;
    private static final Logger logger = LoggerFactory.getLogger(LiuCheng.class.getName());
    int pageLoadTime = 10;
    Start start = new Start();

    String s = new Htsq().getTime();

    @Test
    public void WorkShenPi() throws InterruptedException {
        xiaJi("ganyingying", "1535010975", wr);
    }
}
