package com.xq.myglide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.xq.httpurlconnection.HttpUrlConnectionActivity;
import com.xq.okhttp.OkHttpActivity;
import com.xq.volley.VolleyActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.findViewById(R.id.tv1).setOnClickListener(this);
        this.findViewById(R.id.tv2).setOnClickListener(this);
        this.findViewById(R.id.tv3).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv1:
                startActivity(new Intent(MainActivity.this, HttpUrlConnectionActivity.class));
                break;
            case R.id.tv2:
                startActivity(new Intent(MainActivity.this, OkHttpActivity.class));
                break;
            case R.id.tv3:
                startActivity(new Intent(MainActivity.this, VolleyActivity.class));
                break;
        }
    }
}
