package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
        products.add(new Product("Šumski med", "1000", "Novkovic", "pic3"));
        products.add(new Product("Suncokret med", "1000", "Novkovic", "pic4"));
        products.add(new Product("Coko med", "1200", "Mijailovic", "pic9"));
        setTitle("Prodavnica");

        ProductsAdapter adapter = new ProductsAdapter(this, products);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.prodavnica:
                intent = new Intent(this, Store.class);
                startActivity(intent);
                return true;
            case R.id.korpa:
                intent = new Intent(this, Korpa.class);
                startActivity(intent);
                return true;
            case R.id.profil:
                intent = new Intent(this, Profil.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}