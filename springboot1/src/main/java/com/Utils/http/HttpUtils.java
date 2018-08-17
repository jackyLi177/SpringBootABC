package com.Utils.http;

import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Ian
 * @date 18-4-3上午10:30
 */
public class HttpUtils {

    public static URLConnection getUrlConnection(String url) throws IOException {
        URL obj = new URL(url);
        URLConnection conn = obj.openConnection();
        String host = getHostByUrl(url);
        conn.setRequestProperty("Host", host);
        conn.setRequestProperty("Referer", "http://" + host);
        return conn;
    }

    public static URLConnection getUrlConnection(String url, String encode, String cookie)
            throws IOException {
        URL obj = new URL(url);
        URLConnection conn = obj.openConnection();
        setProperty(encode, conn, cookie);
        String host = getHostByUrl(url);
        conn.setRequestProperty("Host", host);
        conn.setRequestProperty("Referer", "http://" + host);
        return conn;
    }

    public static Map<String, List<String>> getHeaderFields(String url) throws IOException {
        URLConnection conn = getUrlConnection(url);
        Map<String, List<String>> map = conn.getHeaderFields();
        return map;
    }

    public static String getCookieByHeaders(Map<String, List<String>> headers) {
        String mcookie = "";
        List<String> server = headers.get("Set-Cookie");
        if (server == null) {
            System.err.println("Key 'Cookie' is not found!");
        } else {
            StringBuilder sb = new StringBuilder();
            for (String values : server) {
                sb.append(values);
            }
            mcookie = sb.toString();
        }
        return mcookie;
    }

    public static String streamToString(InputStream inStream) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(inStream));
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = in.readLine()) != null) {
            sb.append(line);
        }
        String result = sb.toString();
        in.close();
        return result;
    }

    public static String sendGet(String url, String param, String encoding) {
        return sendGet(url, param, encoding, "");
    }

    public static String sendGet(String url, String param, String encoding, String cookie) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = concatUrl(url, param);
            URL realUrl = new URL(urlNameString);
            HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
            setProperty(encoding, conn, cookie);
            String host = getHostByUrl(url);
            conn.setRequestProperty("Host", host);
            conn.setRequestProperty("Referer", "http://" + host);
            conn.setRequestMethod("GET");
            conn.connect();
            result = streamToString(conn.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Send GET http request exception！" + e.getMessage());
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                System.err.println(e2.getMessage());
            }
        }
        return result;
    }

    public static String sendGet(String url, String param, String encoding, String cookie, String token) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = concatUrl(url, param);
            URL realUrl = new URL(urlNameString);
            HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
            setProperty(encoding, conn, cookie);
            String host = getHostByUrl(url);
            conn.setRequestProperty("FW-TOKEN", token);
            conn.setRequestProperty("Host", host);
            conn.setRequestProperty("Referer", "http://" + host);
            conn.setRequestMethod("GET");
            conn.connect();
            result = streamToString(conn.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Send GET http request exception！" + e.getMessage());
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                System.err.println(e2.getMessage());
            }
        }
        return result;
    }

    public static String sendDelete(String url, String param, String encoding, String cookie, String token){
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = concatUrl(url, param);
            URL realUrl = new URL(urlNameString);
            HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
            setProperty(encoding, conn, cookie);
            String host = getHostByUrl(url);
            conn.setRequestProperty("gisttoken", token);
            conn.setRequestProperty("Host", host);
            conn.setRequestProperty("Referer", "http://" + host);
            conn.setRequestMethod("DELETE");
            conn.connect();
            result = streamToString(conn.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Send GET http request exception！" + e.getMessage());
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                System.err.println(e2.getMessage());
            }
        }
        return result;
    }


    public static String sendPost(String url, String param, String encoding) throws IOException {
        return sendPost(url, param, encoding, "");
    }

    public static String sendPost(String url, String param, String encoding, String cookie)
            throws IOException {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        if (StringUtils.isEmpty(url)) {
            throw new IOException("The request url is not allow empty or null!");
        }
        try {
            URL realUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
            setProperty(encoding, conn, cookie);
            String host = getHostByUrl(url);
            conn.setRequestProperty("Host", host);
            conn.setRequestProperty("Referer", "http://" + host);
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            out = new PrintWriter(new OutputStreamWriter(conn.getOutputStream(), encoding));
            out.print(param);
            out.flush();
            result = streamToString(conn.getInputStream());
        } catch (Exception e) {
            System.err.println("Send http post method exception！" + e);
            throw new IOException(e);
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                throw ex;
            }
        }
        return result;
    }

    public static String readContentFromPost(String url, String param) throws IOException {
        // Post请求的url，与get不同的是不需要带参数
        URL postUrl = new URL(url);
        System.out.println(postUrl);
        // 打开连接
        HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();
        // 设置是否向connection输出，因为这个是post请求，参数要放在
        // http正文内，因此需要设为true
        connection.setDoOutput(true);
        // Read from the connection. Default is true.
        connection.setDoInput(true);
        // 默认是 GET方式
        connection.setRequestMethod("POST");
        // Post 请求不能使用缓存
        connection.setUseCaches(false);
        //设置本次连接是否自动重定向
        connection.setInstanceFollowRedirects(true);
        // 配置本次连接的Content-type，配置为application/x-www-form-urlencoded的
        // 意思是正文是urlencoded编码过的form参数
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        // 连接，从postUrl.openConnection()至此的配置必须要在connect之前完成，
        // 要注意的是connection.getOutputStream会隐含的进行connect。
        connection.connect();
        DataOutputStream out = new DataOutputStream(connection
                .getOutputStream());
        // 正文，正文内容其实跟get的URL中 '? '后的参数字符串一致
        //String content =  URLEncoder.encode(param, "utf-8");
        String content = param;
//        System.out.println(content);
        // DataOutputStream.writeBytes将字符串中的16位的unicode字符以8位的字符形式写到流里面
        out.writeBytes(content);
        //流用完记得关
        out.flush();
        out.close();
        //获取响应
        String result = streamToString(connection.getInputStream());
        //该干的都干完了,记得把连接断了
        connection.disconnect();
        return result;
    }


    public static String sendPost(String url, String param, String encoding, String cookie, String token)
            throws IOException {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        if (StringUtils.isEmpty(url)) {
            throw new IOException("The request url is not allow empty or null!");
        }
        try {
            URL realUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
            setProperty(encoding, conn, cookie);
            String host = getHostByUrl(url);
            conn.setRequestProperty("Host", host);
            conn.setRequestProperty("FW-TOKEN", token);
            conn.setRequestProperty("Referer", "http://" + host);
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            out = new PrintWriter(new OutputStreamWriter(conn.getOutputStream(), encoding));
            out.print(param);
            out.flush();
            result = streamToString(conn.getInputStream());
        } catch (Exception e) {
            System.err.println("Send http post method exception！" + e);
            throw new IOException(e);
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                throw ex;
            }
        }
        return result;
    }

    public static String getHostByUrl(String url) {
        int index = url.indexOf(":");
        String temp = url.substring(index + 3);
        int end = temp.indexOf("/");
        if (end <= 0) {
            end = temp.length();
        }
        String host = temp.substring(0, end);
        System.out.println("host---------->" + host);
        return host;
    }

    private static void setProperty(String encoding, URLConnection conn, String cookie) {
        conn.setRequestProperty("Accept-Charset", encoding);
        conn.setRequestProperty(
                "Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        conn.setRequestProperty("Connection", "keep-alive");
        // conn.setRequestProperty("Content-Type",
        // "application/x-www-form-urlencoded");
        // "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:43.0) Gecko/20100101
        // Firefox/43.0"
        // Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.1.2)
        // Gecko/20090729 Firefox/3.5.2
        // conn.setRequestProperty("user-agent", "Mozilla/5.0 (Windows; U;
        // Windows NT 5.1; zh-CN; rv:1.9.1.2) Gecko/20090729 Firefox/3.5.2");
        conn.setRequestProperty("user-agent", "Mozilla/5.0 (compatible; MSIE 8.0; Windows NT 5.1;SV1)");
        if (StringUtils.isNotBlank(cookie)) {
            conn.setRequestProperty("Cookie", cookie);
        }
        // conn.setRequestProperty("Access-Control-Allow-Origin", "*");
    }

    public static String sendGet(String url, String param) {
        return sendGet(url, param, "gb2312");
    }

    public static String sendPost(String url, String param) throws IOException {
        return sendPost(url, param, "gb2312");
    }

    public static String toFenAndPending(float input) {
        int money = (int) (input * 100);
        String ret = String.valueOf(money);
        if (ret.length() < 12) {
            while (12 > ret.length()) {
                ret = "0" + ret;
            }
        }
        return ret;
    }

    public static String filterHtml(String input, String pattern) {
        Matcher m = Pattern.compile(pattern, 2 | Pattern.DOTALL).matcher(input);
        int i = m.groupCount();
        while (m.find()) {
            return m.group(i);
        }
        return input;
    }

    public static String getFormTagHtml(String result) {
        return HttpUtils.filterHtml(result, "<form [\\s\\S]*</form>");
    }

    public static String getHtmlInput(String input, String key) {
        String pattern = "<input\\s*(?=[^>]*name=\"" + key + "\")(?=[^>]*value=\"([^\"]+)\")[^>]+>";
        Matcher m = Pattern.compile(pattern, 2 | Pattern.DOTALL).matcher(input);
        int i = m.groupCount();
        while (m.find()) {
            return m.group(i);
        }
        return input;
    }

    public static String filterAhref(String input) {
        Pattern pattern = Pattern.compile("<a\\s*href=\"([^<>\"]*)\"[^<>]*>", 2 | Pattern.DOTALL);
        Matcher m = pattern.matcher(input);
        if (m.find()) {
            return m.group(1);
        }
        return input;
    }

    public static String concatUrl(String url, String param) {
        if (StringUtils.isNotBlank(param)) {
            if (url.indexOf("?") > -1) {
                url += "&" + param;
            } else {
                url += "?" + param;
            }
        }
        return url;
    }

    public static String getRequestParam(Map<String, Object> maps) {
        StringBuilder sb = new StringBuilder();
        if (maps != null && maps.size() > 0) {
            Iterator<Map.Entry<String, Object>> entries = maps.entrySet().iterator();
            while (entries.hasNext()) {
                Map.Entry<String, Object> entry = entries.next();
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(entry.getValue());
                sb.append("&");
            }
            return sb.substring(0, sb.length() - 1);
        }
        return null;
    }

}
