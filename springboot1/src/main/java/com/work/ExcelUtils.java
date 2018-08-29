package com.work;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fundway.trafficsignal.business.tc.entity.ExcelDemo;
import com.fundway.trafficsignal.business.tc.entity.ExcelModel;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @date 18-5-23上午9:29
 */
public class ExcelUtils {
	
	public static void ExcelExport(Workbook workbook, HttpServletResponse response, String fileName){
        OutputStream out = null;  
        try {      
        	response.setCharacterEncoding("UTF-8");
        	out = response.getOutputStream();  
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename="  
                                                    +  URLEncoder.encode(fileName, "UTF-8"));  
            workbook.write(out);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {    
            try {     
                out.close();    
            } catch (IOException e) {    
                e.printStackTrace();  
            }    
        }   
        
	}
	
	/**
	 *
	 * @param title 标题
	 * @param sheetName 表标签名
	 * @param pojoClass 实体类
	 * @param data 数据
	 * @return
	 */
	public static Workbook getWorkbook(String title,String sheetName,Class<?> pojoClass,Collection<?> data){
		return ExcelExportUtil.exportExcel(new ExportParams(title, sheetName), pojoClass, data);
	}


    /**
     * 根据model导出Excel
     */
    public static void exportExcel(/*HttpServletResponse response,*/ ExcelModel model){

        int rowNum = 1;
        int colNum = 0;
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("路口信息表");

        List<ExcelDemo> excelEntityList = model.getDemoList();

        boolean updateFlag = false;
        boolean noteFlag = false;
        String headersStr = getNotNullFieldNames(excelEntityList);

        if (headersStr == null){
            return;
        }

        int headerNum = headersStr.split("|").length;
        createHeaders(sheet,headersStr);

        //自动调整列宽,这个必须在最后设置，否则可能无效
        for(int n=0;n<headerNum;n++){
            sheet.autoSizeColumn(n);
        }
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);

        File savefile = new File("E:/");
        if (!savefile.exists()) {
            savefile.mkdirs();
        }
        try {
            FileOutputStream fos = new FileOutputStream("E:/test.xls");
            workbook.write(fos);
            fos.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
//        ExcelExport(workbook,response,"信号路口详情列表.xls");
    }
    
    /*public static void excelExport(*//*HttpServletResponse response,*//* ExcelModel model){
        List<ExcelDemo> data = model.getDemoList();
        TemplateExportParams params = new TemplateExportParams("e:\\01.xls");
        params.setHeadingStartRow(2);
        params.setHeadingRows(1);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("c1",model.isC1());
        map.put("c2",model.isC2());
        map.put("c3",model.isC3());
        map.put("c4",model.isC4());
        map.put("c5",model.isC5());
        map.put("c6",model.isC6());
        map.put("c7",model.isC7());
        map.put("c8",model.isC8());
        map.put("c9",model.isC9());
        map.put("c10",model.isC10());
        map.put("c11",model.isC11());
        map.put("c12",model.isC12());
        map.put("c13",model.isC13());
        map.put("c14",model.isC14());
        map.put("c15",model.isC15());
        List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();
        for (int i = 0; i < data.size(); i++) {
            Map<String, String> lm = new HashMap<String, String>();
            lm.put("id", i + 1 + "");
            lm.put("crossname", data.get(i).getCrossname());
            lm.put("crossno", data.get(i).getCrossno());
            lm.put("crosstype", data.get(i).getCrosstype());
            lm.put("managerunit",data.get(i).getManagerunit());
            lm.put("manager",data.get(i).getManager());
            lm.put("degree",data.get(i).getDegree());
            lm.put("isenabled",data.get(i).getIsenabled());
            lm.put("networkenabled",data.get(i).getNetworkenabled());
            lm.put("webtype",data.get(i).getWebtype());
            lm.put("electricannno",data.get(i).getElectricannno());
            lm.put("crossnumber",data.get(i).getCrossnumber());
            lm.put("updatetime",data.get(i).getUpdatetime());
            lm.put("note",data.get(i).getNote());
            lm.put("annfactory",data.get(i).getAnnfactory());
            lm.put("anntype",data.get(i).getAnntype());
            lm.put("devicemaintain",data.get(i).getDevicemaintain());
            lm.put("laneEentrance",data.get(i).getLaneEentrance());
            lm.put("laneWentrance",data.get(i).getLaneWentrance());
            lm.put("laneSentrance",data.get(i).getLaneSentrance());
            lm.put("laneNentrance",data.get(i).getLaneNentrance());
            lm.put("laneotherentrance",data.get(i).getLaneotherentrance());
            lm.put("turnrighttype",data.get(i).getTurnrighttype());
            lm.put("lightEentrance",data.get(i).getLightEentrance());
            lm.put("lightWentrance",data.get(i).getLightWentrance());
            lm.put("lightSentrance",data.get(i).getLightSentrance());
            lm.put("lightNentrance",data.get(i).getLightNentrance());
            lm.put("lightotherentrance",data.get(i).getLightotherentrance());
            lm.put("righttrafficlightcontrol",data.get(i).getRighttrafficlightcontrol());
            lm.put("trunklinecoordination",data.get(i).getTrunklinecoordination());
            lm.put("releasetype",data.get(i).getReleasetype());
            lm.put("specialcontrol",data.get(i).getSpecialcontrol());
            lm.put("selfadaptioncontrol",data.get(i).getSelfadaptioncontrol());
            lm.put("yellowtwinkle",data.get(i).getYellowtwinkle());
            lm.put("flownum",data.get(i).getFlownum());
            lm.put("phasetimenum",data.get(i).getPhasetimenum());
            lm.put("maxpersonwaitingtime",data.get(i).getMaxpersonwaitingtime());
            lm.put("maxcarwaitingtime",data.get(i).getMaxcarwaitingtime());
            lm.put("maxperiod",data.get(i).getMaxperiod());
            lm.put("minperiod",data.get(i).getMinperiod());
            lm.put("yellowtwinkle",data.get(i).getYellowtwinkle());
            listMap.add(lm);
        }
        map.put("maplist", listMap);

        Workbook workbook = ExcelExportUtil.exportExcel(params, map);
        File savefile = new File("E:/");
        if (!savefile.exists()) {
            savefile.mkdirs();
        }
        try {
            FileOutputStream fos = new FileOutputStream("E:/test.xls");
            workbook.write(fos);
            fos.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }*/

    /**
     *  获取数据的非空字段名字符串
     * @param data 数据
     */
    public static <T> String getNotNullFieldNames(List<T> data){
        if (data.size() <= 0){
            return null;
        }
        T t = data.get(0);
        Class aClass = t.getClass();
        Field[] fields = aClass.getDeclaredFields();
        StringBuilder sb = new StringBuilder();
        //获取非空属性
        try {
            for(Field f : fields){
                f.setAccessible(true);
                Object fieldName;
                fieldName = f.get(data.get(0));
                if(fieldName == null){
                    continue;
                }
                sb.append(fieldName+",");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return sb.toString().length()>0 ? sb.toString() : null;
    }

    /**
     * 根据字符串创建表头
     * @param str
     */
    public static void createHeaders(HSSFSheet sheet,String str){
        String[] headers = str.split("|");
        String annStr = "annfactory|anntype|devicemaintain";
        //TODO
        String timingStr = "trunklinecoordination|releasetype|specialcontrol|selfadaptioncontrol|yellowtwinkle|flownum|" +
                "phasetimenum|maxpersonwaitingtime|maxcarwaitingtime|maxperiod|minperiod|variance|isadjustable";
        String laneStr = "laneEentrance|laneWentrance|laneSentrance|laneNentrance|laneotherentrance|turnrighttype";
        String lightStr = "lightEentrance|lightWentrance|lightSentrance|lightNentrance|lightotherentrance|righttrafficlightcontrol";
        StringBuilder annHeader = new StringBuilder();
        StringBuilder laneHeader = new StringBuilder();
        StringBuilder lightHeader = new StringBuilder();
        StringBuilder timingHeader = new StringBuilder();
        StringBuilder basicHeader = new StringBuilder();
        for (String h : headers){
            if (annStr.contains(h)){
                annHeader.append(h+"|");
            }else if (laneStr.contains(h)){
                laneHeader.append(h+"|");
            }else if (lightStr.contains(h)){
                lightHeader.append(h+"|");
            }else if (timingStr.contains(h)){
                timingHeader.append(h+"|");
            }else {
                basicHeader.append(h+"|");
            }
        }
        int headerNum = basicHeader.toString().split("|").length;
        if (annHeader.toString().length()>0){
            headerNum += 3;
            //id列
            headerNum++;
        }
        if (laneHeader.toString().length()>0){
            headerNum += 6;
        }
        if (lightHeader.toString().length()>0){
            headerNum += 6;
        }
        //TODO
        if (timingHeader.toString().length()>0){
            headerNum += 13;
        }
        boolean updatetimeFlag = false;
        boolean noteFlag = false;
        if (basicHeader.toString().contains("updatetime")){
            updatetimeFlag = true;
        }
        if (basicHeader.toString().contains("note")){
            noteFlag = true;
        }

        //在excel表中添加第一行表头
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell1 = row.createCell(0);
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,headerNum-1));
        cell1.setCellValue("信号路口详情列表");

        int temp = headerNum;
        if (updatetimeFlag){
            temp -= 1;
        }
        if (noteFlag){
            temp -= 1;
        }

        for (int i=0;i<=temp;i++){
            sheet.addMergedRegion(new CellRangeAddress(1,2,i,i));
        }
        int colNum = 0;
        HSSFRow row1 = sheet.createRow(1);
        HSSFRow row2 = sheet.createRow(2);

        //建立的表头拼接字符串，方便以后取值
        StringBuilder headerStr = new StringBuilder();

        row1.createCell(colNum++).setCellValue("序号");
        row1.createCell(colNum++).setCellValue("路口名称");
        row1.createCell(colNum++).setCellValue("路口编号");
        for (String s : headers){
            if (s.contains("crosstype")){
                row1.createCell(colNum++).setCellValue("路口类型");
                headerStr.append("crosstype|");
            }
            if (s.contains("managerunit")){
                row1.createCell(colNum++).setCellValue("管理单位");
                headerStr.append("managerunit|");
            }
            if (s.contains("manager")){
                row1.createCell(colNum++).setCellValue("辖区中队");
                headerStr.append("manager|");
            }
            if (s.contains("degree")){
                row1.createCell(colNum++).setCellValue("重要程度");
                headerStr.append("degree|");
            }
            if (s.contains("isenabled")){
                row1.createCell(colNum++).setCellValue("启用状态");
                headerStr.append("isenabled|");
            }
            if (s.contains("networkenabled")){
                row1.createCell(colNum++).setCellValue("联网状态");
                headerStr.append("networkenabled|");
            }
            if (s.contains("webtype")){
                row1.createCell(colNum++).setCellValue("联网方式");
                headerStr.append("webtype|");
            }
            if (s.contains("electricannno")){
                row1.createCell(colNum++).setCellValue("电子监控编号");
                headerStr.append("electricannno|");
            }
            if (s.contains("crossnumber")){
                row1.createCell(colNum++).setCellValue("卡口编号");
                headerStr.append("crossnumber|");
            }
        }
        if (annHeader.toString().length()>0) {
            sheet.addMergedRegion(new CellRangeAddress(1,2,colNum,colNum+2));
            row1.createCell(colNum).setCellValue("信号机设备信息");
            row2.createCell(colNum++).setCellValue("厂家");
            row2.createCell(colNum++).setCellValue("型号");
            row2.createCell(colNum++).setCellValue("维护单位");
            headerNum += 3;
        }
        if (laneHeader.toString().length()>0) {
            sheet.addMergedRegion(new CellRangeAddress(1,2,colNum,colNum+5));
            row1.createCell(colNum).setCellValue("车道构成");
            row2.createCell(colNum++).setCellValue("东进口");
            row2.createCell(colNum++).setCellValue("西进口");
            row2.createCell(colNum++).setCellValue("南进口");
            row2.createCell(colNum++).setCellValue("北进口");
            row2.createCell(colNum++).setCellValue("其他进口");
            row2.createCell(colNum++).setCellValue("右转程度");
            headerNum += 6;
        }
        if (lightHeader.toString().length()>0) {
            sheet.addMergedRegion(new CellRangeAddress(1,2,colNum,colNum+5));
            row1.createCell(colNum).setCellValue("信号灯组");
            row2.createCell(colNum++).setCellValue("东进口");
            row2.createCell(colNum++).setCellValue("西进口");
            row2.createCell(colNum++).setCellValue("南进口");
            row2.createCell(colNum++).setCellValue("北进口");
            row2.createCell(colNum++).setCellValue("其他进口");
            row2.createCell(colNum++).setCellValue("右转灯控状态");
            headerNum += 6;
        }
        if (timingHeader.toString().length()>0) {
            sheet.addMergedRegion(new CellRangeAddress(1,2,colNum,colNum+12));
            row1.createCell(colNum).setCellValue("配时信息");
            row2.createCell(colNum++).setCellValue("干线协调");
            row2.createCell(colNum++).setCellValue("放行方式");
            row2.createCell(colNum++).setCellValue("特殊控制");
            row2.createCell(colNum++).setCellValue("自适应控制");
            row2.createCell(colNum++).setCellValue("黄闪设置");
            row2.createCell(colNum++).setCellValue("相位数量");
            row2.createCell(colNum++).setCellValue("时段数");
            row2.createCell(colNum++).setCellValue("方*数");
            row2.createCell(colNum++).setCellValue("最大行人等待时间");
            row2.createCell(colNum++).setCellValue("最大机动车等待时间");
            row2.createCell(colNum++).setCellValue("最小周期");
            row2.createCell(colNum++).setCellValue("最大周期");
            row2.createCell(colNum++).setCellValue("是否*调动路口");
            headerNum += 13;
        }
        if (updatetimeFlag){
            sheet.addMergedRegion(new CellRangeAddress(1,2,headerNum-1,headerNum-1));
            row1.createCell(colNum++).setCellValue("更新日期");
        }
        if (noteFlag){
            sheet.addMergedRegion(new CellRangeAddress(1,2,headerNum,headerNum));
            row1.createCell(colNum++).setCellValue("备注");
        }

    }

    public static void main(String[] args) throws IOException {
        ExcelModel data = new ExcelModel();
        List<ExcelDemo> list = new ArrayList<>();
        ExcelDemo demo = new ExcelDemo();
        String str = "{\"crossname\":\"fassfsaf\",\"crossno\":\"fsasljfl\",\"crosstype\":null,\"managerunit\":null,\"manager\":null,\"degree\":null,\"isenabled\":null,\"networkenabled\":null,\"webtype\":null,\"electricannno\":null,\"crossnumber\":null,\"updatetime\":null,\"note\":null,\"annfactory\":null,\"anntype\":null,\"devicemaintain\":null,\"laneEentrance\":null,\"laneWentrance\":null,\"laneSentrance\":null,\"laneNentrance\":null,\"laneotherentrance\":null,\"turnrighttype\":null,\"lightEentrance\":null,\"lightWentrance\":null,\"lightSentrance\":null,\"lightNentrance\":null,\"lightotherentrance\":null,\"righttrafficlightcontrol\":null,\"trunklinecoordination\":null,\"releasetype\":null,\"specialcontrol\":null,\"selfadaptioncontrol\":null,\"yellowtwinkle\":null,\"flownum\":null,\"phasetimenum\":null,\"variance\":null,\"maxpersonwaitingtime\":null,\"maxcarwaitingtime\":null,\"maxperiod\":null,\"minperiod\":null,\"isadjustable\":null}";
        demo = new ObjectMapper().readValue(str,ExcelDemo.class);
        data.setDemoList(list);
        list.add(demo);
        System.out.println(new ObjectMapper().writeValueAsString(data));
        exportExcel(data);
    }
}
