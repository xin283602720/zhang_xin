package core;

import org.openqa.selenium.WebDriver;

public class UtilTest {
    public static void Want(String string, String xpath, WebDriver driver) {
//        if(string.equals("点击")){
//
//        }
        switch (string) {
            case "点击":
                Util.click(xpath, driver);
                break;
//            case "输入":
//                Util.input();
//                break;
//            case "下拉":
//                Util.select();
//                break;
//            case "弹出框":
//                Util.alert();
//                break;
//            case "上传":
//                Util.handleUpload();
//                break;
        }
    }
}
