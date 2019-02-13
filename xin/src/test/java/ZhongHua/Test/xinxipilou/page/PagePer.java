package ZhongHua.Test.xinxipilou.page;

import core.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PagePer {
    static WebDriver wr;
    private static final Logger logger = LoggerFactory.getLogger(PagePer.class);
    /**
     * @param leibei  报告类别
     * @param leixing 报告类型
     */
    public static void SelectReport(String leibei, String leixing) {
        if (leibei.equals("定期报告")) {
            PagePer.select(ChaiDan.SELECT_reportType, wr,"0");
        }else if (leibei.equals("事务类报告")){
            PagePer.select(ChaiDan.SELECT_reportType, wr,"1");
        }else if(leibei.equals("临时报告")){
            PagePer.select(ChaiDan.SELECT_reportType, wr,"2");
        }else {
            logger.info("输入错误");
        }

    }

    /**
     * 有下拉框操作，默认第一条
     *
     * @param Xpatch
     * @param wr
     */
    public static void select(String Xpatch, WebDriver wr, String i) {
        WebElement element_province = wr.findElement(By.xpath(Xpatch));
        Select province = new Select(element_province);
        province.selectByValue(i); //根据value值来选择下拉框的值
    }
}
