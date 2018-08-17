package com.controller;

import com.common.Result;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.Forecast;
import com.model.WeatherDetails;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController("/Weather")
public class WeatherController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/CityWeather")
    public Result getByCity(@RequestParam("City") String city) {
        System.out.println("weather-----------------------------------------");
        String url = "http://wthrcdn.etouch.cn/weather_mini?city=" + city;
        HttpClient h = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        StringBuffer sb = null;
        WeatherDetails result = null;
        try {
            HttpResponse response = h.execute(httpGet);
            InputStream inputStream = response.getEntity().getContent();
            sb = new StringBuffer();
            byte[] b = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(b)) > 0) {
                sb.append(new String(b, 0, len, "UTF-8"));
            }
            result = getEntityWrapper(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Result.ok(result);
    }

    public static List<String> parseJson(String json) {

        List<String> result = new ArrayList<>();

        String regex = "\\{\"date\":(.+?)\\}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(json);
        while (matcher.find()) {
            result.add(matcher.group());
        }
        return result;
    }

    @GetMapping("/new")
    public WeatherDetails newGetWeather(){
        WeatherDetails result = new WeatherDetails();
        ObjectMapper mapper = new ObjectMapper();
        ResponseEntity<String> entity = restTemplate.getForEntity("http://wthrcdn.etouch.cn/weather_mini?city=广州", String.class);
        String body = entity.getBody();
        try {
            result = mapper.readValue("{"+body.substring(115,body.length()-27), WeatherDetails.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static WeatherDetails getEntityWrapper(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        WeatherDetails result = null;
        StringBuffer sb = new StringBuffer("{");
        List<Forecast> forecasts = new ArrayList<Forecast>();
        try {
            JsonNode readTree = mapper.readTree(jsonString);
            //readTree相当于加载对象的树形结构，然后一层层解析，当实体中有集合属性时使用
            JsonNode data = readTree.get("data");
            Iterator<Map.Entry<String, JsonNode>> fields = data.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                if (entry.getKey().contains("yesterday")) {
                    forecasts.add(mapper.readValue(entry.getValue().toString().replace("<![CDATA[","").replace("]]>",""), Forecast.class));
                } else if (entry.getKey().contains("forecast")) {
                    List<String> strings = parseJson(entry.getValue().toString());
                    Iterator<String> iterator = strings.iterator();
                    while (iterator.hasNext()) {
                        String s = iterator.next();
                        if(s.contains("fengli") || s.contains("fl")) {
                            s = s.replace("<![CDATA[", "").replace("]]>", "");
                        }
                        forecasts.add(mapper.readValue(s, Forecast.class));
                    }
                } else {
                    sb.append("\""+entry.getKey()+"\""+":"+"\""+entry.getValue().textValue()+"\""+",");
                }
            }
            result = mapper.readValue(sb.substring(0,sb.length()-1)+"}", WeatherDetails.class);
            result.setForecast(forecasts);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

//    public static void main(String... args){
//        newGetWeather();
//    }
}
