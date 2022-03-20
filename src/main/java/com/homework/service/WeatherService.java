package com.homework.service;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import javax.enterprise.context.ApplicationScoped;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@ApplicationScoped
public class WeatherService implements IWeatherService {
    public String getCityWeather(String city){
        String url = "http://wthrcdn.etouch.cn/weather_mini?city=" + city;
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .build();
        final Call call = okHttpClient.newCall(request);
        Response response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        String ret = null;
        try {
            ret = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("查询天气数据：" + ret);
        return ret;
    }
}
