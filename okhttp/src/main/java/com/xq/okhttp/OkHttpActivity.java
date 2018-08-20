package com.xq.okhttp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xq.okhttp.utils.GlideCacheUtil;
import com.xq.okhttp.utils.HTTPSUtils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_okhttp);

        ImageView imageView = (ImageView) this.findViewById(R.id.iv);

        //自签名https图片链接 （如果链接失效，自行到12306网站找图片）
//        String url = "https://travel.12306.cn/imgs/resources/uploadfiles/images/a9b9c76d-36ba-4e4a-8e02-9e6a1a991da0_news_W540_H300.jpg";
        String url = "https://static.daicaihang.com/m1/images/start_pic.jpg?v=0820";
//        String url = "https://static.daicaihang.com/m1/images/start_pic.jpg";
//        String url = "http://static.daicash.net/m1/images/start_pic.jpg";

        GlideCacheUtil.getInstance().clearImageAllCache(this);

        Glide.with(this)
                .load(url)
                .thumbnail(0.1f)
                .crossFade(3000)
                .placeholder(R.mipmap.ic_launcher)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(imageView);

        Request request = new Request.Builder()
//                .url("https://kyfw.12306.cn/otn/login/init")
                .url("https://www.baidu.com/")
                .build();
        HTTPSUtils httpsUtils = new HTTPSUtils(this);
        httpsUtils.getInstance().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("==============onFailure--------------" + e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println("==============onResponse--------------" + response.body().string());
            }
        });

    }

}
