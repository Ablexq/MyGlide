package com.xq.httpurlconnection;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;


public class HttpUrlConnectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_httpurlconnection);

        ImageView imageView = (ImageView) this.findViewById(R.id.iv);

        String url = "https://static.daicaihang.com/m1/images/start_pic.jpg";

        Glide.with(this)
                .load(url)
                .crossFade(3000)
                .thumbnail(0.1f)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);

    }
}
