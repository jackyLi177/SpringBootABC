package com.work;

/**
 * @Author : liyongjie
 * @Date : 2018/8/24 0024
 */
public class ExcelEntity {
    //路口名称
    private String crossName;
    //路口编号
    private String crossNo;
    //路口类型
    private String crossType;
    //管理单位
    private String managerUnit;
    //辖区中队
    private String manager;
    //重要程度
    private String degree;
    //启用状态
    private String isEnabled;
    //联网状态
    private String networkEnabled;
    //联网方式
    private String webtype;
    //电子监控编号
    private String electricAnnNo;
    //卡口编号
    private String crossnumber;
    //更新日期
    private String updateTime;
    //备注
    private String note;

    public String getCrossName() {
        return crossName;
    }

    public String getCrossNo() {
        return crossNo;
    }

    public String getCrossType() {
        return crossType;
    }

    public String getManagerUnit() {
        return managerUnit;
    }

    public String getManager() {
        return manager;
    }

    public String getDegree() {
        return degree;
    }

    public String getIsEnabled() {
        return isEnabled;
    }

    public String getNetworkEnabled() {
        return networkEnabled;
    }

    public String getWebtype() {
        return webtype;
    }

    public String getElectricAnnNo() {
        return electricAnnNo;
    }

    public String getCrossnumber() {
        return crossnumber;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public String getNote() {
        return note;
    }

    public ExcelEntity setCrossName(String crossName) {
        this.crossName = crossName;return this;
    }

    public ExcelEntity setCrossNo(String crossNo) {
        this.crossNo = crossNo;return this;
    }

    public ExcelEntity setCrossType(String crossType) {
        this.crossType = crossType;return this;
    }

    public ExcelEntity setManagerUnit(String managerUnit) {
        this.managerUnit = managerUnit;return this;
    }

    public ExcelEntity setManager(String manager) {
        this.manager = manager;return this;
    }

    public ExcelEntity setDegree(String degree) {
        this.degree = degree;return this;
    }

    public ExcelEntity setIsEnabled(String isEnabled) {
        this.isEnabled = isEnabled;return this;
    }

    public ExcelEntity setNetworkEnabled(String networkEnabled) {
        this.networkEnabled = networkEnabled;return this;
    }

    public ExcelEntity setWebtype(String webtype) {
        this.webtype = webtype;return this;
    }

    public ExcelEntity setElectricAnnNo(String electricAnnNo) {
        this.electricAnnNo = electricAnnNo;return this;
    }

    public ExcelEntity setCrossnumber(String crossnumber) {
        this.crossnumber = crossnumber;return this;
    }

    public ExcelEntity setUpdateTime(String updateTime) {
        this.updateTime = updateTime;return this;
    }

    public ExcelEntity setNote(String note) {
        this.note = note;return this;
    }


    /**
     * 信号机设备信息
     */
    public class AnnunciatorInfo{
        //信号机厂家
        private String annfactory;
        //信号机型号
        private String anntype;
        //设备维护单位
        private String devicemaintain;

        public String getAnnfactory() {
            return annfactory;
        }

        public String getAnntype() {
            return anntype;
        }

        public String getDevicemaintain() {
            return devicemaintain;
        }

        public AnnunciatorInfo setAnnfactory(String annfactory) {
            this.annfactory = annfactory;return this;
        }

        public AnnunciatorInfo setAnntype(String anntype) {
            this.anntype = anntype;return this;
        }

        public AnnunciatorInfo setDevicemaintain(String devicemaintain) {
            this.devicemaintain = devicemaintain;return this;
        }
    }


    /**
     * 车道构成
     */
    public class LaneInfo{
        //东进口
        private String laneEEntrance;
        //西进口
        private String laneWEntrance;
        //南进口
        private String laneSEntrance;
        //北进口
        private String laneNEntrance;
        //其他进口
        private String laneotherEntrance;
        //右转程度
        private String turnRightType;


        public String getLaneEEntrance() {
            return laneEEntrance;
        }

        public String getLaneWEntrance() {
            return laneWEntrance;
        }

        public String getLaneSEntrance() {
            return laneSEntrance;
        }

        public String getLaneNEntrance() {
            return laneNEntrance;
        }

        public String getLaneotherEntrance() {
            return laneotherEntrance;
        }

        public String getTurnRightType() {
            return turnRightType;
        }

        public LaneInfo setLaneEEntrance(String laneEEntrance) {
            this.laneEEntrance = laneEEntrance;return this;
        }

        public LaneInfo setLaneWEntrance(String laneWEntrance) {
            this.laneWEntrance = laneWEntrance;return this;
        }

        public LaneInfo setLaneSEntrance(String laneSEntrance) {
            this.laneSEntrance = laneSEntrance;return this;
        }

        public LaneInfo setLaneNEntrance(String laneNEntrance) {
            this.laneNEntrance = laneNEntrance;return this;
        }

        public LaneInfo setLaneotherEntrance(String laneotherEntrance) {
            this.laneotherEntrance = laneotherEntrance;return this;
        }

        public LaneInfo setTurnRightType(String turnRightType) {
            this.turnRightType = turnRightType;return this;
        }
    }


    /**
     * 信号灯组
     */
    public class TrafficLightGroup{
        //东进口
        private String lightEEntrance;
        //西进口
        private String lightWEntrance;
        //南进口
        private String lightSEntrance;
        //北进口
        private String lightNEntrance;
        //其他进口
        private String lightotherEntrance;
        //右转灯控状态
        private String rightTrafficLightControl;

        public String getLightEEntrance() {
            return lightEEntrance;
        }

        public String getLightWEntrance() {
            return lightWEntrance;
        }

        public String getLightSEntrance() {
            return lightSEntrance;
        }

        public String getLightNEntrance() {
            return lightNEntrance;
        }

        public String getLightotherEntrance() {
            return lightotherEntrance;
        }

        public String getRightTrafficLightControl() {
            return rightTrafficLightControl;
        }


        public TrafficLightGroup setLightEEntrance(String lightEEntrance) {
            this.lightEEntrance = lightEEntrance;return this;
        }

        public TrafficLightGroup setLightWEntrance(String lightWEntrance) {
            this.lightWEntrance = lightWEntrance;return this;
        }

        public TrafficLightGroup setLightSEntrance(String lightSEntrance) {
            this.lightSEntrance = lightSEntrance;return this;
        }

        public TrafficLightGroup setLightNEntrance(String lightNEntrance) {
            this.lightNEntrance = lightNEntrance;return this;
        }

        public TrafficLightGroup setLightotherEntrance(String lightotherEntrance) {
            this.lightotherEntrance = lightotherEntrance;return this;
        }

        public TrafficLightGroup setRightTrafficLightControl(String rightTrafficLightControl) {
            this.rightTrafficLightControl = rightTrafficLightControl;return this;
        }
    }


    /**
     * 配时信息
     */
    public class TimingInfo{
        //干线协调
        private String trunkLineCoordination;
        //放行方式
        private String releasetype;
        //特殊控制
        private String specialControl;
        //自适应控制
        private String selfAdaptionControl;
        //黄闪设置
        private String yellowTwinkle;
        //相位数量
        private String flowNum;
        //时段数
        private String phasetimenum;
        //private String something1;   // 方*数
        //最大行人等待时间
        private String maxPersonWaitingTime;
        //最大机动车等待时间
        private String maxCarWaitingTime;
        //最大周期
        private String maxperiod;
        //最小周期
        private String minperiod;
        //private String something2;    //是否*调动路口

        public String getTrunkLineCoordination() {
            return trunkLineCoordination;
        }

        public String getReleasetype() {
            return releasetype;
        }

        public String getSpecialControl() {
            return specialControl;
        }

        public String getSelfAdaptionControl() {
            return selfAdaptionControl;
        }

        public String getYellowTwinkle() {
            return yellowTwinkle;
        }

        public String getFlowNum() {
            return flowNum;
        }

        public String getPhasetimenum() {
            return phasetimenum;
        }

        public String getMaxPersonWaitingTime() {
            return maxPersonWaitingTime;
        }

        public String getMaxCarWaitingTime() {
            return maxCarWaitingTime;
        }

        public String getMaxperiod() {
            return maxperiod;
        }

        public String getMinperiod() {
            return minperiod;
        }

        public TimingInfo setTrunkLineCoordination(String trunkLineCoordination) {
            this.trunkLineCoordination = trunkLineCoordination;return this;
        }

        public TimingInfo setReleasetype(String releasetype) {
            this.releasetype = releasetype;return this;
        }

        public TimingInfo setSpecialControl(String specialControl) {
            this.specialControl = specialControl;return this;
        }

        public TimingInfo setSelfAdaptionControl(String selfAdaptionControl) {
            this.selfAdaptionControl = selfAdaptionControl;return this;
        }

        public TimingInfo setYellowTwinkle(String yellowTwinkle) {
            this.yellowTwinkle = yellowTwinkle;return this;
        }

        public TimingInfo setFlowNum(String flowNum) {
            this.flowNum = flowNum;return this;
        }

        public TimingInfo setPhasetimenum(String phasetimenum) {
            this.phasetimenum = phasetimenum;return this;
        }

        public TimingInfo setMaxPersonWaitingTime(String maxPersonWaitingTime) {
            this.maxPersonWaitingTime = maxPersonWaitingTime;return this;
        }

        public TimingInfo setMaxCarWaitingTime(String maxCarWaitingTime) {
            this.maxCarWaitingTime = maxCarWaitingTime;return this;
        }

        public TimingInfo setMaxperiod(String maxperiod) {
            this.maxperiod = maxperiod;return this;
        }

        public TimingInfo setMinperiod(String minperiod) {
            this.minperiod = minperiod;return this;
        }
    }

}