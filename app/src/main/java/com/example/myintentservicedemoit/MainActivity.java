package com.example.myintentservicedemoit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
    }

    public void onButtonClicked(View view){
        Intent intent = new Intent(this,MyIntentService.class);
        Bundle b = new Bundle();
        b.putInt("sleepTime",2000);
        intent.putExtra("bundle",b);
//        intent.putExtra("sleepTime",2000);
        startService(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void showToast(Pojo pojo){
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
    }
}
