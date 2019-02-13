package ZhongHua.Test.xinxipilou.page;

public interface ChaiDan {
    final String BUTTON_GUOCHENGGUANLI = "//*[@id='menu_td05']/a";//项目管理下过程管理
    final String BUTTON_BAOGAOSHANGCHUAN = "//*[@id='m3']/li/a"; //报告上传
    final String BUTTON_ADD = "//*[@id='menu1']";  //新增按钮
    final String BUTTON_Inquire = "//*[@id='menu2']";//查询按钮
    final String SELECT_reportCategory = "//*[@id='reportCategory']";//报告类别 0定期 1事务 2临时
    final String SELECT_reportType = "//*[@id='reportType']";//报告类型
    //0季度报告 1月度报告 2半年度报告 3年度报告     5事务类报告  4临时报告 6清算报告 7清算报报告(合并)
    final String RADIO_reportGenerationMethod1 = "//*[@id='reportGenerationMethod' and @value='1']";//手工编制
    final String RADIO_reportGenerationMethod2 = "//*[@id='reportGenerationMethod' and @value='2']";//系统编制
    final String RADIO_costAdjustment = "//*[@id='costAdjustment' and value='1']";//费用调整
    final String INPUT_remark = "//*[@id='remark']";//摘要
    final String BUTTON_UPLOAD = "//*[@id='button4']";//附件上传
    final String BUTTON_SWFUpload_0 = "//*[@id-'SWFUpload_0']";//报告上传界面选择文件按钮
    final String BUTTON_sure="//*[@id='doUpload']";//报告上传界面确定按钮
    final String BUTTON_TIJIAO="//*[@id='button2' and value='提交']";//提交按钮

}
