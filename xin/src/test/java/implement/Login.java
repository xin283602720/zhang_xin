package implement;

public interface Login {
    final String LOGIN_NAME="//*[@name='user.userCode']";
    final String LOGIN_PASSWORD="//*[@name='user.userPassword']";
    final String LOGIN_SUBMIT="//*[@name='Submit']";
    final String LOGIN_EXIT="//*[@id='exit']";//退出
    final String PAGE_XMGL="//table[@class='button']/tbody/tr[4]/td[@class='bottom-middle' and @colSpan='3']";
    final String PAGE_HTGL="//td[@id='menu_td07']/a[@class='txt']";
    final String PAGE_HTSQ="//ul[@id='m1']/li[1]";
}
