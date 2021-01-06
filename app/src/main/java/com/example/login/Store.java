package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Store extends AppCompatActivity {

    public static ArrayList<Product> products;

    public static String[] names = {"hello", "hello", "hello"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        products = new ArrayList<>();
        products.add(new Product("Livadski med", "800", "Novkovic", "pic1"));
        products.add(new Product("Bagremov med", "1000", "Novkovic", "pic2"));
        setTitle("Prodavnica");

        ProductsAdapter adapter = new ProductsAdapter(this, products);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }
}