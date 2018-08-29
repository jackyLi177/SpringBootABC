package com.work;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
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

        String headersStr = getNotNullFieldNames(excelEntityList);

        if (headersStr == null){
            return;
        }

        int headerNum = headersStr.split("\\|").length;
        createHeaders(workbook,sheet,headersStr);

        //自动调整列宽,这个必须在最后设置，否则可能无效
        for(int n=0;n<headerNum;n++){
            sheet.autoSizeColumn(n);
        }

        //TODO 每一行遍历cell进行样式设置
        HSSFRow row = sheet.getRow(2);
        int col_num = row.getPhysicalNumberOfCells();
        for (int col=0;col<col_num;col++){
        }

        File savefile = new File("/home/jackylee/files");
        if (!savefile.exists()) {
            savefile.mkdirs();
        }
        try {
            FileOutputStream fos = new FileOutputStream("/home/jackylee/files/test.xls");
            workbook.write(fos);
            fos.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
//        ExcelExport(workbook,response,"信号路口详情列表.xls");
    }
    
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
                Object obj;
                obj = f.get(data.get(0));
                if(obj == null){
                    continue;
                }
                sb.append(f.getName()+"|");
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
    public static void createHeaders(Workbook workbook,HSSFSheet sheet,String str){
        String[] headers = str.split("\\|");
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
        int headerNum = basicHeader.toString().split("\\|").length;
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
        row.setHeight((short) 700);
        HSSFCell cell1 = row.createCell(0);
        //一级大标题样式
        Font font = workbook.createFont();
        font.setFontName("仿宋_GB2312");
        font.setBold(true);//粗体显示
        font.setFontHeightInPoints((short) 20);
        CellStyle centerStyle = workbook.createCellStyle();
        centerStyle.setFont(font);
        centerStyle.setAlignment(HorizontalAlignment.CENTER_SELECTION);
        centerStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,headerNum));
        cell1.setCellValue("信号路口详情列表");
        cell1.setCellStyle(centerStyle);

        int temp = basicHeader.toString().split("\\|").length;
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
        headerStr.append("crossname|crossno|");
        for (String s : basicHeader.toString().split("\\|")){
            if (s.matches("crosstype")){
                row1.createCell(colNum++).setCellValue("路口类型");
                headerStr.append("crosstype|");
                continue;
            }
            if (s.matches("managerunit")){
                row1.createCell(colNum++).setCellValue("管理单位");
                headerStr.append("managerunit|");
                continue;
            }
            if (s.matches("manager")){
                row1.createCell(colNum++).setCellValue("辖区中队");
                headerStr.append("manager|");
                continue;
            }
            if (s.matches("degree")){
                row1.createCell(colNum++).setCellValue("重要程度");
                headerStr.append("degree|");
                continue;
            }
            if (s.matches("isenabled")){
                row1.createCell(colNum++).setCellValue("启用状态");
                headerStr.append("isenabled|");
                continue;
            }
            if (s.matches("networkenabled")){
                row1.createCell(colNum++).setCellValue("联网状态");
                headerStr.append("networkenabled|");
                continue;
            }
            if (s.matches("webtype")){
                row1.createCell(colNum++).setCellValue("联网方式");
                headerStr.append("webtype|");
                continue;
            }
            if (s.matches("electricannno")){
                row1.createCell(colNum++).setCellValue("电子监控编号");
                headerStr.append("electricannno|");
                continue;
            }
            if (s.matches("crossnumber")){
                row1.createCell(colNum++).setCellValue("卡口编号");
                headerStr.append("crossnumber|");
                continue;
            }
        }
        if (annHeader.toString().length()>0) {
            sheet.addMergedRegion(new CellRangeAddress(1,1,colNum,colNum+2));
            row1.createCell(colNum).setCellValue("信号机设备信息");
            row2.createCell(colNum++).setCellValue("厂家");
            row2.createCell(colNum++).setCellValue("型号");
            row2.createCell(colNum++).setCellValue("维护单位");
            headerNum += 3;
        }
        if (laneHeader.toString().length()>0) {
            sheet.addMergedRegion(new CellRangeAddress(1,1,colNum,colNum+5));
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
            sheet.addMergedRegion(new CellRangeAddress(1,1,colNum,colNum+5));
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
            sheet.addMergedRegion(new CellRangeAddress(1,1,colNum,colNum+12));
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
            sheet.addMergedRegion(new CellRangeAddress(1,2,colNum++,colNum-1));
            row1.createCell(colNum-1).setCellValue("更新日期");
        }
        if (noteFlag){
            sheet.addMergedRegion(new CellRangeAddress(1,2,colNum,colNum));
            row1.createCell(colNum).setCellValue("备注");
        }

    }

    public static void setAlignCenter(Workbook workbook,HSSFCell cell){
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cell.setCellStyle(cellStyle);
    }

    public static void main(String[] args) throws IOException {
        ExcelModel data = new ExcelModel();
        List<ExcelDemo> list = new ArrayList<>();
        ExcelDemo demo = new ExcelDemo();
        String str = "{\"crossname\":\"fassfsaf\",\"crossno\":\"fsasljfl\",\"crosstype\":\"fassfsaf\",\"managerunit\":\"fassfsaf\",\"manager\":\"fassfsaf\",\"degree\":\"fassfsaf\",\"isenabled\":\"fassfsaf\",\"networkenabled\":\"fassfsaf\",\"webtype\":\"fassfsaf\",\"electricannno\":\"fassfsaf\",\"crossnumber\":\"fassfsaf\",\"updatetime\":\"fassfsaf\",\"note\":\"fassfsaf\",\"annfactory\":null,\"anntype\":null,\"devicemaintain\":null,\"laneEentrance\":\"fassfsaf\",\"laneWentrance\":\"fassfsaf\",\"laneSentrance\":\"fassfsaf\",\"laneNentrance\":\"fassfsaf\",\"laneotherentrance\":\"fassfsaf\",\"turnrighttype\":\"fassfsaf\",\"lightEentrance\":null,\"lightWentrance\":null,\"lightSentrance\":null,\"lightNentrance\":null,\"lightotherentrance\":null,\"righttrafficlightcontrol\":null,\"trunklinecoordination\":\"fassfsaf\",\"releasetype\":\"fassfsaf\",\"specialcontrol\":\"fassfsaf\",\"selfadaptioncontrol\":\"fassfsaf\",\"yellowtwinkle\":\"fassfsaf\",\"flownum\":\"fassfsaf\",\"phasetimenum\":\"fassfsaf\",\"variance\":\"fassfsaf\",\"maxpersonwaitingtime\":\"fassfsaf\",\"maxcarwaitingtime\":\"fassfsaf\",\"maxperiod\":\"fassfsaf\",\"minperiod\":\"fassfsaf\",\"isadjustable\":\"fassfsaf\"}";
        demo = new ObjectMapper().readValue(str,ExcelDemo.class);
        data.setDemoList(list);
        list.add(demo);
        System.out.println(new ObjectMapper().writeValueAsString(data));
        exportExcel(data);
    }
}
