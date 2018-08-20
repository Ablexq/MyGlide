package com.xq.volley;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class VolleyActivity extends AppCompatActivity {

    private String url = "https://static.daicaihang.com/m1/images/start_pic.jpg?id=1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_volley);

        ImageView imageView = (ImageView) this.findViewById(R.id.iv);

        Glide.with(this)
                .load(url)
                .into(imageView);

    }
}
