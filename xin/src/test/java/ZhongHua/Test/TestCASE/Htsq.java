package ZhongHua.Test.TestCASE;

import ZhongHua.Test.LiuChengAll.LiuCheng;
import core.Util;
import implement.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static core.Util.*;

public class Htsq {
    private static final Logger logger = LoggerFactory.getLogger(Htsq.class.getName());
    WebDriver wr;
    int pageLoadTime = 10;
    private String time = Util.time();

    public String getTime() {
        return time;
    }

    @BeforeClass
    public void startChrome() throws Exception {
//        System.setProperty("webdriver.ie.driver", "src/test/java/suittool/iedriver.exe");
//        DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
//        ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
//        wr = new InternetExplorerDriver(ieCapabilities);
        URL url = new URL("http://192.168.57.131:6666/wd/hub");
        wr = new RemoteWebDriver(url, DesiredCapabilities.internetExplorer());
        wr.get(Science.URL_UAT5);
        Util.logIn("ganyingying", wr);
//        Util.logInTest("点击", wr);
    }

    @Test
    public void test() throws Exception {
        wr.manage().window().maximize();
        click(Login.PAGE_XMGL, wr);
        Thread.sleep(1000);
        click(Login.PAGE_HTGL, wr);
        Thread.sleep(1000);
        click(Login.PAGE_HTSQ, wr);
        Thread.sleep(1000);
        Switch(ShenQingJieMian.PAGE_FRAME_MAIN, wr);
        //点击合同新增
        click(ShenQingJieMian.PAGE_ADD, wr);
        //点击放大镜
        click(ShenQingJieMian.PAGE_HTSQ_FDJ, wr);
        //选择第一条数据
//        DoubleClick(ShenQingJieMian.PAGE_HTBH,wr);
        click(ShenQingJieMian.PAGE_HTBH, wr);
        //点击确定
        click(ShenQingJieMian.PAHE_FDJ_QD, wr);
        input(ShenQingJieMian.PAGE_HTSQ_SQDH, getTime(), wr);
        //选择上传合同编辑方式
        click(ShenQingJieMian.PAGE_HTSQ_HTBJSF, wr);
        //输入摘要
        input(ShenQingJieMian.PAGE_HTSQ_ZY, getTime(), wr);
        //点击保存按钮
        click(ShenQingJieMian.PAGE_HTSQ_SAVQ, wr);
        alert("acc", wr);
        //点击合同明细新增
        click(ShenQingJieMian.PAGE_HTSQ_ADD, wr);
        //输入合同编号
        input(ShenQingJieMian.PAGE_HTSQ_CONNO, time, wr);
        //输入合同名称
        input(ShenQingJieMian.PAGE_HTSQ_CONNAME, time, wr);
        //选择合同类型
        select(ShenQingJieMian.PAGE_HTSQ_CONTRACTTYPE, wr);
        //点击上传合同
        click(ShenQingJieMian.PAGE_HTSQ_FILE, wr);
        handleUpload("ie", new File("C:\\Users\\Administrator\\Desktop\\12.doc"));
        Thread.sleep(5000);
        //操作保存明细
        click(ShenQingJieMian.PAGE_HTSQ_SAVEDATAL, wr);
        //提交合同
        click(ShenQingJieMian.PAGE_HTSQ_APPLYMASTER, wr);
        //退出当前账户
        quit(wr);
        //登陆下级审批人并点击代办
        xiaJi("ganyingying", time, wr);


        //选择会签部门
        click(DaiBan.HUIQIANBUMEN, wr);
        //选择会签部门
        select(DaiBan.BUMENXUANZE, wr);
        //确认 添加到 已选部门
        click(DaiBan.ADD, wr);
        //会签部门确定
        click(DaiBan.QUEDING, wr);
        //审批通过
        yesorno(DaiBan.NO_BUTTON, wr);
        //alert弹出框选择是
        alert("dis", wr);
        xiaJi("ganyingying", time, wr);
        yesorno(DaiBan.YES_BUTTON, wr);

    }

    /**
     * 明细校验
     *
     * @throws InterruptedException
     */
    @Test
    public void MingXiJiaoYan() throws InterruptedException {
        wr.manage().timeouts().pageLoadTimeout(pageLoadTime, TimeUnit.SECONDS);
        click(Login.PAGE_XMGL, wr);
        Thread.sleep(1000);
        click(Login.PAGE_HTGL, wr);
        Thread.sleep(1000);
        click(Login.PAGE_HTSQ, wr);
        Thread.sleep(1000);
        Switch(ShenQingJieMian.PAGE_FRAME_MAIN, wr);
        click(ShenQingJieMian.PAGE_CLICK_MINGXI, wr);
        Thread.sleep(5000);
        click(ShenQingJieMian.PAGE_BUTTON_YUANBAN, wr);
        Alert a = wr.switchTo().alert();
        System.out.println(a.getText());
    }
}
