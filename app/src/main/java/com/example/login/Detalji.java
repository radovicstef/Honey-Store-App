package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Detalji extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalji);
        Bundle b = getIntent().getExtras();
        int index = -1; // or other values
        if(b != null)
            index = b.getInt("key");
        setTitle(Store.products.get(index).productName);
    }
}