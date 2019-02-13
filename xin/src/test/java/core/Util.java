package core;

import implement.DaiBan;
import implement.Login;
import implement.ZhuYe;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import javax.swing.*;
import java.io.File;

import static implement.ShenQingJieMian.PAGE_FRAME_MAIN;

public class Util {
    private static final Logger logger = LoggerFactory.getLogger(Util.class);

    public static void logInTest(String string,WebDriver wr) throws InterruptedException {
        input(Login.LOGIN_NAME, "ganyingying", wr);
        input(Login.LOGIN_PASSWORD, "0", wr);
        UtilTest.Want(string,Login.LOGIN_SUBMIT,wr);
        Thread.sleep(3000);
    }


    public static  void input(String xpath, String in, WebDriver wr) {
        By inputBox = By.xpath(xpath);
//        WebElement webElement = wr.findElement(By.xpath(xpath));
        intelligentWait(wr, 10, inputBox);
        wr.findElement(inputBox).sendKeys(in);
    }

    public static void click(String xpath, WebDriver wr) {
        By clickk = By.xpath(xpath);
        logger.info("元素"+xpath+"未找到");
        intelligentWait(wr, 10, clickk);
        wr.findElement(clickk).click();
    }

    /**
     * @param name      登陆用户
     * @param zaiyao    摘要
     * @param webDriver
     */

    public static void xiaJi(String name, String zaiyao, WebDriver webDriver) {

        input(Login.LOGIN_NAME, name, webDriver);
        input(Login.LOGIN_PASSWORD, "0", webDriver);
        click(Login.LOGIN_SUBMIT, webDriver);
        click(ZhuYe.DAIBAN, webDriver);
        Switch(PAGE_FRAME_MAIN, webDriver);
        String zaiyao1 = webDriver.findElement(By.xpath(DaiBan.ONE)).getText();
        String zaiyao2 = webDriver.findElement(By.xpath(DaiBan.TWO)).getText();
        String zaiyao3 = webDriver.findElement(By.xpath(DaiBan.THREE)).getText();
        if (zaiyao.equals(zaiyao1)) {
            click(DaiBan.ONE_CLICK, webDriver);
        } else if (zaiyao.equals(zaiyao2)) {
            click(DaiBan.TWO_CLICK, webDriver);
        } else if (zaiyao.equals(zaiyao3)) {
            click(DaiBan.THREE_CLICK, webDriver);
        } else {
            Object[] options = {"是", "取消"};
            JOptionPane.showOptionDialog(null, "前三条代办未查询到", "警告",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                    null, options, options[0]);
        }

    }



    /**
     * @param name 登陆用户名
     */
    public static void work(String name, WebDriver wr) throws InterruptedException {
        input(Login.LOGIN_NAME, name, wr);
        input(Login.LOGIN_PASSWORD, "0", wr);
        click(Login.LOGIN_SUBMIT, wr);
        //点击代办
        click(ZhuYe.DAIBAN, wr);
        Switch(PAGE_FRAME_MAIN, wr);
        //审批第一条
        click(ZhuYe.FIRSTDAIBAN, wr);
    }

    /**
     * @param string Y审批通过 N审批拒绝
     *               并且输入摘要
     */
    public static void yesorno(String string, WebDriver wr) {

        Switch(PAGE_FRAME_MAIN, wr);
        input(DaiBan.SHENPIYIJIAN, time(), wr);
        if (string.equals("yes")) {
            By yes = By.xpath(DaiBan.YES);
            intelligentWait(wr, 10, yes);
            wr.findElement(yes).click();
        }
        if (string.equals("no")) {
            By no = By.xpath(DaiBan.NO);
            intelligentWait(wr, 10, no);
            wr.findElement(no).click();
        }
    }


    public static void logIn(String name, WebDriver wr) throws InterruptedException {
        input(Login.LOGIN_NAME, name, wr);
        input(Login.LOGIN_PASSWORD, "0", wr);
        WebElement c = wr.findElement(By.xpath(Login.LOGIN_SUBMIT));
        c.click();
        Thread.sleep(3000);
    }

    public static void quit(WebDriver wr) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wr.switchTo().defaultContent();
        By quit = By.xpath(Login.LOGIN_EXIT);
        intelligentWait(wr, 10, quit);

//        WebElement webElement = wr.findElement(By.xpath(Login.LOGIN_EXIT));
//        webElement.click();
        wr.findElement(quit).click();
    }

    public static void Switch(String xpatch, WebDriver wr) {
        wr.switchTo().defaultContent();
        wr.switchTo().frame(xpatch);
    }

    public static void DoubleClick(String xpatch, WebDriver wr) {
        Actions action = new Actions(wr);
        By byy = By.xpath(xpatch);
        intelligentWait(wr, 10, byy);
        action.moveToElement(wr.findElement(byy)).perform();
        action.doubleClick().perform();
    }

    /**
     * @return 获取10位时间戳
     */
    public static String time() {
        long time = System.currentTimeMillis() / 1000;  //获取系统时间的10位的时间戳
        String str = String.valueOf(time);
        return str;
    }

    /**
     * 有下拉框操作，默认第一条
     *
     * @param Xpatch
     * @param wr
     */
    public static void select(String Xpatch, WebDriver wr) {
        WebElement element_province = wr.findElement(By.xpath(Xpatch));
        Select province = new Select(element_province);
        province.selectByValue("1"); //根据value值来选择下拉框的值
    }

    /**
     * 针对alert弹出框
     *
     * @param string acc确定，dis取消
     */
    public static void alert(String string, WebDriver wr) {
        Alert a = wr.switchTo().alert();

        if (string.equals("acc")) {
            a.accept();
        }
        if (string.equals("dis")) {
            a.dismiss();
        }
    }
    /**
     * 上传文件，需要点击弹出上传照片的窗口才行
     * @param browser 使用的浏览器名称
     * @param file    需要上传的文件及文件名
     */
    public static void handleUpload(String browser, File file) {
        String filePath = file.getAbsolutePath();
        String executeFile = "src/test/java/suittool/upload.exe"; //定义了upload.exe文件的路径
        String cmd = "\"" + executeFile + "\"" + " " + "\"" + browser + "\"" + " " + "\"" + filePath + "\"";
        try {
            Process p = Runtime.getRuntime().exec(cmd);
            p.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void intelligentWait(WebDriver driver, int timeOut, final By by) {


        try {
            (new WebDriverWait(driver, timeOut)).until(new ExpectedCondition<Boolean>() {

                public Boolean apply(WebDriver driver) {
                    WebElement element = driver.findElement(by);
                    return element.isDisplayed();
                }
            });
        } catch (TimeoutException e) {
            Assert.fail("超时!! " + timeOut + " 秒之后还没找到元素 [" + by + "]", e);
        }
    }
}
