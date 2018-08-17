package com.c3p0;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Admin;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.*;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.sql.*;
import java.util.*;

/**
 *    ResultSetHandler结果集处理类(8种)
 *         1、ArrayHandler:将结果集的第一行存储到对象数组中 Object[]
 *         2、ArrayListHandler:将结果集的每一行，封装到对象数组中，出现很多对象数组,然后封装到List集合中
 *         3、BeanHandler:将结果集的第一行数据，封装成JavaBean对象
 *         4、BeanListHandler:将数据结果集的每一行数据，封装成JavaBean对象,多个JavaBean对象封装到List集合中
 *         5、ColumnListHandler:指定列的数据，存储到List集合
 *         6、ScalarHandler:对于查询结果，只有一个结果集。用泛型进行封装
 *         7、MapHandler:将结果集第一行数据，放在map中,Map<列名，这列的数据>
 *         8、MapListHandler:将结果集每一行存储到map中 ,再把map集合存储到List集合中
 * @Author : liyongjie
 * @Date : 2018/7/6 0006
 */
public class ResultSetHandlerUtils {
    static QueryRunner qr = new QueryRunner();
    static ObjectMapper mapper = new ObjectMapper();


    /**
     * ArrayListHandler:将结果集的每一行，封装到对象数组中，出现很多对象数组,然后封装到List集合中
     *
     * @param conn
     * @param sql
     */
    public static List arrayListHandler(Connection conn, String sql) {
        List<Object[]> query = null;
        try {
            query = qr.query(conn, sql, new ArrayListHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        query.stream().flatMap((childlist) -> Arrays.stream(childlist))  /* List<Object[]> -> Object[] */
//                .flatMap((array) -> Stream.of(array)).forEach(System.out::println); /* Object[] -> Object */
        return query;
    }


    /**
     * 手动重写ResultSetHandler的handle方法
     *
     * @param conn
     * @param sql
     */
    @Deprecated
    public static void myBeanHandler(Connection conn, String sql) {
        try {
            Admin query = qr.query(conn, sql, new ResultSetHandler<Admin>() {
                @Override
                public Admin handle(ResultSet rs) throws SQLException {
                    Admin admin = null;
                    while (rs.next()) {
                        int id = rs.getInt(1);
                        String name = rs.getString(2);
                        String roles = rs.getString(3);
                        String password = rs.getString(4);
                        String token = rs.getString(5);
                        admin = new Admin(id, name, roles, password, token);
                    }
                    return admin;
                }
            });
            System.out.println(query.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * BeanHandler:将结果集的第一行数据，封装成JavaBean对象
     *
     * @param conn
     * @param sql
     */
    public static Object beanHandler(Connection conn, String sql) {
        try {
            Admin admin = qr.query(conn, sql, new BeanHandler<Admin>(Admin.class));
//            System.out.println(admin.toString());
            return admin;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * BeanListHandler:将数据结果集的每一行数据，封装成JavaBean对象,多个JavaBean对象封装到List集合中
     *
     * @param conn
     * @param sql
     */
    public static List beanListhandler(Connection conn, String sql) {
        try {
            Object o = qr.query(conn, sql, new BeanListHandler<Admin>(Admin.class));
            ArrayList<Admin> admins = (ArrayList<Admin>) o;
//            admins.stream().map(x -> x.toString()).forEach(System.out::print);
            return admins;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * ColumnListHandler:指定列的数据，存储到List集合
     * ColumnListHandler(int columnIndex),colIndex 列序号，从1开始，获取所有结果的第colIndex列
     * columnListHandler(String columnName),columnName 列名
     * @param conn
     * @param sql
     */
    public static List columnListHandler(Connection conn,String sql){
        try {
            List<Object> query = qr.query(conn, sql, new ColumnListHandler(2));
//            query.stream().map(x -> x.toString()).forEach(System.out::println);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }


    /**
     * ScalarHandler:对于查询结果，只有一个结果集。用泛型进行封装
     * 类似于columnListHandler,可以传两个参数，但是结果只返回第一行
     * @param conn
     * @param sql
     */
    public static Object scalarHandler(Connection conn,String sql){
        try {
            Object o = qr.query(conn, sql, new ScalarHandler("roles"));
//            System.out.println(o.toString());
            return o;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * MapHandler:将结果集第一行数据，放在map中,Map<列名，这列的数据>
     * @param conn
     * @param sql
     */
    public static Map mapHandler(Connection conn,String sql){
        try {
            Map<String, Object> map = qr.query(conn, sql, new MapHandler());

//            //entrySet遍历（性能较优）
//            for (Map.Entry<String,Object> entry : map.entrySet()){
//                System.out.println(entry.getKey()+"   "+entry.getValue());
//            }
//            //lambda表达式遍历
//            map.forEach((key,value) -> System.out.println(key+":"+value+"--"));

            return map;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * MapListHandler:将结果集每一行存储到map中 ,再把map集合存储到List集合中
     * @param conn
     * @param sql
     */
    public static List<Map<String, Object>> mapListHandler(Connection conn, String sql){
        try {
            List<Map<String, Object>> query = qr.query(conn, sql, new MapListHandler());

//            for(Map<String,Object> map : query){
//                map.forEach((key,value) -> System.out.print(key+":"+value+"--"));
//                System.out.println();
//            }
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    //    public static void main(String[] args) throws SQLException {
//        String sql = "select * from admin";
//        Connection conn = c3p0Utils.getConn();
//
//        arrayListHandler(conn,sql);
//        myBeanHandler(conn, sql);
//        beanHandler(conn, sql);
//        beanListhandler(conn, sql);
//        columnListHandler(conn,sql);
//        scalarHandler(conn,sql);
//        mapHandler(conn,sql);
//        mapListHandler(conn,sql);
//        RSTest();
//    }

//    /**
//     * resultSet数据处理
//     */
//    @Deprecated
//    public static void RSTest() {
//        try {
//            Connection conn = c3p0Utils.getConn();
//            Statement statement = conn.createStatement();
//            String sql = "select * from admin";
//            ResultSet rs = statement.executeQuery(sql);
//            JSONArray array = new JSONArray();
//            int col = rs.getMetaData().getColumnCount();
//            while (rs.next()) {
//                System.out.println(rs.getRow());
//                JSONObject jsonObject = null;
//                for (int i = 1; i <= col; i++) {
//                    jsonObject = new JSONObject();
//                    try {
//                        jsonObject.put(rs.getMetaData().getColumnLabel(i), rs.getString(i));
//                        array.put(jsonObject);
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.print(rs.getString(i) + "--");
//                }
//                System.out.println();
//            }
//            System.out.println(array.toString());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

//    }
}