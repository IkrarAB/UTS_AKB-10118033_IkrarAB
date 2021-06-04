/*
* Tanggal Pengerjaan : Selasa, 01 Juni 2021
* Nama               : Ikrar Anugrah Bastary
* NIM                : 10118033
* Kelas              : IF-1/S1/VI
*
*/

package com.ikrarab.myselfapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;

public class MainActivity extends AppCompatActivity {
    private static int splash_timeout = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent wtIntent = new Intent(MainActivity.this, Walkthrough.class);
                startActivity(wtIntent);
                finish();
            }
        }, splash_timeout);
    }
}