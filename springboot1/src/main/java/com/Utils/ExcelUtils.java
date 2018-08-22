package com.Utils;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.List;

/**
 * @date 18-5-23上午9:29
 */
public class ExcelUtils {

    public static void ExcelExport(Workbook workbook,HttpServletResponse response,String fileName){
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
    public static <T> void exportExcel(Class<T> pojoClass, List<T> data){

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("sheetname");

//        List<User> list = new ArrayList<>();
//        User user = new User();
//        user.setUsername("test").setPhone("1235468415").setPassword("testpassword").setEqUsername("fsadfdsaf");
//        list.add(user);

        Field[] fields = pojoClass.getDeclaredFields();
        StringBuilder sb = new StringBuilder();

        //将非空字段选出来，作为Excel的表头
        try {
            for(Field f : fields){
                f.setAccessible(true);
                String value = null;
                value = (String) f.get(data.get(0));
                if(value == null || value.trim().equals("")){
                    continue;
                }
                sb.append(f.getName()+",");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        //headers表示excel表中第一行的表头
        String[] headers = sb.toString().split(",");

        String fileName = "信号路口详情列表"  + ".xls";
        //新增数据行，并且设置单元格数据
        int rowNum = 1;

        //在excel表中添加第一行表头
        HSSFRow row = sheet.createRow(0);

        for(int i=0;i<headers.length;i++){
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

        //在表中存放查询到的数据放入对应的列
        try {
            for (T entity : data) {
                HSSFRow row1 = sheet.createRow(rowNum);
                for(int n=0;n<headers.length;n++){
                    Field field = pojoClass.getDeclaredField(headers[n]);
                    field.setAccessible(true);
                    Object o = field.get(entity);
                    row1.createCell(n).setCellValue(o.toString());
                }
                rowNum++;
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        //自动调整列宽,这个必须在最后设置，否则可能无效
        for(int n=0;n<headers.length;n++){
            sheet.autoSizeColumn(n);
        }

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("e:\\"+fileName);
            workbook.write(fos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args){
//        List<User> list = new ArrayList<>();
//        User user = new User();
//        user.setPhone("122333333").setUsername("jacky").setToken("1351613asf5dsda5fsfgdgfdgafgsdfgfdvcxzvddfgregfbfvadfgafdagragfvafadsfsadvasdgaefadf").setIsVail("8");
//        list.add(user);
//        exportExcel(User.class,list);
//    }
}
