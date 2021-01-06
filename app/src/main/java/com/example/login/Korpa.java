package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Korpa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_korpa);
        setTitle("Korpa");

        NarudzbineAdapter adapter = new NarudzbineAdapter(this, Store.narudzbine);
        ListView listView = (ListView) findViewById(R.id.listKorpa);
        listView.setAdapter(adapter);

        int overallPrice = 0;

        for(int i=0; i<Store.narudzbine.size(); i++){
            overallPrice += Store.narudzbine.get(i).overallPrice;
        }

        TextView overallPriceView = (TextView) findViewById(R.id.overallPrice);
        overallPriceView.setText(String.valueOf(overallPrice));
    }

    public void poruci(View view){
        Store.narudzbine = new ArrayList<>();
        Toast.makeText(this, "Uspešno ste poručili proizvode!", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, Store.class);
        this.startActivity(intent);
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