package com.work;

/**
 * @Author : liyongjie
 * @Date : 2018/8/28 0028
 */
public class ExcelDemo {

    private String crossname;  //路口名称
    private String crossno;  //路口编号
    private String crosstype;  //路口类型
    private String managerunit;  //管理单位
    private String manager;  //辖区中队
    private String degree;    //重要程度
    private String isenabled;  //启用状态
    private String networkenabled;  //联网状态
    private String webtype;   //联网方式
    private String electricannno;  //电子监控编号
    private String crossnumber;  //卡口编号
    private String updatetime;  //更新日期
    private String note;  //备注

    //信号机设备信息
    private String annfactory; //信号机厂家
    private String anntype;    //信号机型号
    private String devicemaintain; //设备维护单位

    //车道构成
    private String laneEentrance;  //东进口
    private String laneWentrance;  //西进口
    private String laneSentrance;  //南进口
    private String laneNentrance;  //北进口
    private String laneotherentrance;  //其他进口
    private String turnrighttype;  //右转程度

    //信号灯组
    private String lightEentrance;  //东进口
    private String lightWentrance;  //西进口
    private String lightSentrance;  //南进口
    private String lightNentrance;  //北进口
    private String lightotherentrance;  //其他进口
    private String righttrafficlightcontrol;  //右转灯控状态

    //配时信息
    private String trunklinecoordination;  //干线协调
    private String releasetype;  //放行方式
    private String specialcontrol;  //特殊控制
    private String selfadaptioncontrol;  //自适应控制
    private String yellowtwinkle;  //黄闪设置
    private String flownum;  //相位数量
    private String phasetimenum;  //时段数
    private String variance;//方*数
    private String maxpersonwaitingtime;  //最大行人等待时间
    private String maxcarwaitingtime;  //最大机动车等待时间
    private String maxperiod;     //最大周期
    private String minperiod;     //最小周期
    private String isadjustable;//是否*调动路口


    public String getCrossname() {
        return crossname;
    }

    public String getCrossno() {
        return crossno;
    }

    public String getCrosstype() {
        return crosstype;
    }

    public String getManagerunit() {
        return managerunit;
    }

    public String getManager() {
        return manager;
    }

    public String getDegree() {
        return degree;
    }

    public String getIsenabled() {
        return isenabled;
    }

    public String getNetworkenabled() {
        return networkenabled;
    }

    public String getWebtype() {
        return webtype;
    }

    public String getElectricannno() {
        return electricannno;
    }

    public String getCrossnumber() {
        return crossnumber;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public String getNote() {
        return note;
    }

    public String getAnnfactory() {
        return annfactory;
    }

    public String getAnntype() {
        return anntype;
    }

    public String getDevicemaintain() {
        return devicemaintain;
    }

    public String getLaneEentrance() {
        return laneEentrance;
    }

    public String getLaneWentrance() {
        return laneWentrance;
    }

    public String getLaneSentrance() {
        return laneSentrance;
    }

    public String getLaneNentrance() {
        return laneNentrance;
    }

    public String getLaneotherentrance() {
        return laneotherentrance;
    }

    public String getTurnrighttype() {
        return turnrighttype;
    }

    public String getLightEentrance() {
        return lightEentrance;
    }

    public String getLightWentrance() {
        return lightWentrance;
    }

    public String getLightSentrance() {
        return lightSentrance;
    }

    public String getLightNentrance() {
        return lightNentrance;
    }

    public String getLightotherentrance() {
        return lightotherentrance;
    }

    public String getRighttrafficlightcontrol() {
        return righttrafficlightcontrol;
    }

    public String getTrunklinecoordination() {
        return trunklinecoordination;
    }

    public String getReleasetype() {
        return releasetype;
    }

    public String getSpecialcontrol() {
        return specialcontrol;
    }

    public String getSelfadaptioncontrol() {
        return selfadaptioncontrol;
    }

    public String getYellowtwinkle() {
        return yellowtwinkle;
    }

    public String getFlownum() {
        return flownum;
    }

    public String getPhasetimenum() {
        return phasetimenum;
    }

    public String getMaxpersonwaitingtime() {
        return maxpersonwaitingtime;
    }

    public String getMaxcarwaitingtime() {
        return maxcarwaitingtime;
    }

    public String getMaxperiod() {
        return maxperiod;
    }

    public String getMinperiod() {
        return minperiod;
    }

    public ExcelDemo setCrossname(String crossname) {
        this.crossname = crossname;return this;
    }

    public ExcelDemo setCrossno(String crossno) {
        this.crossno = crossno;return this;
    }

    public ExcelDemo setCrosstype(String crosstype) {
        this.crosstype = crosstype;return this;
    }

    public ExcelDemo setManagerunit(String managerunit) {
        this.managerunit = managerunit;return this;
    }

    public ExcelDemo setManager(String manager) {
        this.manager = manager;return this;
    }

    public ExcelDemo setDegree(String degree) {
        this.degree = degree;return this;
    }

    public ExcelDemo setIsenabled(String isenabled) {
        this.isenabled = isenabled;return this;
    }

    public ExcelDemo setNetworkenabled(String networkenabled) {
        this.networkenabled = networkenabled;return this;
    }

    public ExcelDemo setWebtype(String webtype) {
        this.webtype = webtype;return this;
    }

    public ExcelDemo setElectricannno(String electricannno) {
        this.electricannno = electricannno;return this;
    }

    public ExcelDemo setCrossnumber(String crossnumber) {
        this.crossnumber = crossnumber;return this;
    }

    public ExcelDemo setUpdatetime(String updatetime) {
        this.updatetime = updatetime;return this;
    }

    public ExcelDemo setNote(String note) {
        this.note = note;return this;
    }

    public ExcelDemo setAnnfactory(String annfactory) {
        this.annfactory = annfactory;return this;
    }

    public ExcelDemo setAnntype(String anntype) {
        this.anntype = anntype;return this;
    }

    public ExcelDemo setDevicemaintain(String devicemaintain) {
        this.devicemaintain = devicemaintain;return this;
    }

    public ExcelDemo setLaneEentrance(String laneEentrance) {
        this.laneEentrance = laneEentrance;return this;
    }

    public ExcelDemo setLaneWentrance(String laneWentrance) {
        this.laneWentrance = laneWentrance;return this;
    }

    public ExcelDemo setLaneSentrance(String laneSentrance) {
        this.laneSentrance = laneSentrance;return this;
    }

    public ExcelDemo setLaneNentrance(String laneNentrance) {
        this.laneNentrance = laneNentrance;return this;
    }

    public ExcelDemo setLaneotherentrance(String laneotherentrance) {
        this.laneotherentrance = laneotherentrance;return this;
    }

    public ExcelDemo setTurnrighttype(String turnrighttype) {
        this.turnrighttype = turnrighttype;return this;
    }

    public ExcelDemo setLightEentrance(String lightEentrance) {
        this.lightEentrance = lightEentrance;return this;
    }

    public ExcelDemo setLightWentrance(String lightWentrance) {
        this.lightWentrance = lightWentrance;return this;
    }

    public ExcelDemo setLightSentrance(String lightSentrance) {
        this.lightSentrance = lightSentrance;return this;
    }

    public ExcelDemo setLightNentrance(String lightNentrance) {
        this.lightNentrance = lightNentrance;return this;
    }

    public ExcelDemo setLightotherentrance(String lightotherentrance) {
        this.lightotherentrance = lightotherentrance;return this;
    }

    public ExcelDemo setRighttrafficlightcontrol(String righttrafficLightcontrol) {
        this.righttrafficlightcontrol = righttrafficLightcontrol;return this;
    }

    public ExcelDemo setTrunklinecoordination(String trunkLinecoordination) {
        this.trunklinecoordination = trunkLinecoordination;return this;
    }

    public ExcelDemo setReleasetype(String releasetype) {
        this.releasetype = releasetype;return this;
    }

    public ExcelDemo setSpecialcontrol(String specialcontrol) {
        this.specialcontrol = specialcontrol;return this;
    }

    public ExcelDemo setSelfadaptioncontrol(String selfadaptioncontrol) {
        this.selfadaptioncontrol = selfadaptioncontrol;return this;
    }

    public ExcelDemo setYellowtwinkle(String yellowtwinkle) {
        this.yellowtwinkle = yellowtwinkle;return this;
    }

    public ExcelDemo setFlownum(String flownum) {
        this.flownum = flownum;return this;
    }

    public ExcelDemo setPhasetimenum(String phasetimenum) {
        this.phasetimenum = phasetimenum;return this;
    }

    public ExcelDemo setMaxpersonwaitingtime(String maxpersonwaitingtime) {
        this.maxpersonwaitingtime = maxpersonwaitingtime;return this;
    }

    public ExcelDemo setMaxcarwaitingtime(String maxcarwaitingtime) {
        this.maxcarwaitingtime = maxcarwaitingtime;return this;
    }

    public ExcelDemo setMaxperiod(String maxperiod) {
        this.maxperiod = maxperiod;return this;
    }

    public ExcelDemo setMinperiod(String minperiod) {
        this.minperiod = minperiod;return this;
    }

    public String getVariance() {
        return variance;
    }

    public ExcelDemo setVariance(String variance) {
        this.variance = variance;return this;
    }

    public String getIsadjustable() {
        return isadjustable;
    }

    public ExcelDemo setIsadjustable(String isadjustable) {
        this.isadjustable = isadjustable;return this;
    }
}
