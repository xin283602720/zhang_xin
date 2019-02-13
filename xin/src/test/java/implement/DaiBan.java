package implement;

public interface DaiBan {
    final static String ONE="//*[@id='table1']/tbody/tr[1]/td[6]";//第一条代办摘要
    final static String ONE_CLICK="//*[@id='table1']/tbody/tr[1]/td[2]/a";
    final static String TWO="//*[@id='table1']/tbody/tr[2]/td[6]";//第二条代办摘要
    final static String TWO_CLICK="//*[@id='table1']/tbody/tr[2]/td[2]/a";
    final static String THREE="//*[@id='table1']/tbody/tr[3]/td[6]";//第三条代办摘要
    final static String THREE_CLICK="//*[@id='table1']/tbody/tr[3]/td[2]/a";
    final static String YES="//*[@id='contractApplyApprove1']";//审批通过
    final static String NO="//*[@id='contractApplyApprove0']";//审批拒绝
    final String SHENPIYIJIAN="//*[@id='commentContent']";//审批意见
    final String HUIQIANBUMEN="//*[@id='contractApplyApprove0']";//点击会签部门
    final String BUMENXUANZE="//*[@id='first']" ;//会签bumenselect列表
    final String ADD="//*[@id='add']";//选中的数据添加到右侧选中部门
    final String QUEDING="//*[@id='table1']/tbody/tr[1]/td/[@name='save']";//会签页面确定按钮
    final String QUICK="//*[@id='passRadio']";//快速审批意见同意
    final static String YES_BUTTON="yes";
    final String NO_BUTTON="no";


}
