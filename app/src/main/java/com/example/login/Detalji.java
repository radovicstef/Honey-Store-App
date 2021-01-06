package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Detalji extends AppCompatActivity {

    public int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalji);
        Bundle b = getIntent().getExtras();
        index = -1; // or other values
        if(b != null)
            index = b.getInt("key");

        setData();

        setTitle(Store.products.get(index).productName);
    }

    public void setData(){
        if(index==-1){
            return;
        }
        else{
            TextView productNameDetalji = (TextView) findViewById(R.id.productNameDetalji);
            productNameDetalji.setText(Store.products.get(index).productName);

            ImageView imgDetalji = (ImageView) findViewById(R.id.picDetalji);
            String uri = "@drawable/" + Store.products.get(index).imagePath;  // where myresource (without the extension) is the file
            int imageResource = getResources().getIdentifier(uri, null, getPackageName());
            Drawable res = getResources().getDrawable(imageResource);
            imgDetalji.setImageDrawable(res);

            TextView opisDetalji = (TextView) findViewById(R.id.opisDetalji);
            opisDetalji.setText(Store.products.get(index).description);

            TextView upotrebaDetalji = (TextView) findViewById(R.id.upotrebaDetalji);
            upotrebaDetalji.setText(Store.products.get(index).usage);

            TextView cenaDetalji = (TextView) findViewById(R.id.cenaDetalji);
            cenaDetalji.setText(Store.products.get(index).price);
        }
    }

    public void addToChart(View view){
        EditText kolicina = (EditText) findViewById(R.id.kolicinaDetalji);
        if(!kolicina.getText().toString().matches("")){
            int kolicinaBroj = Integer.parseInt(kolicina.getText().toString());
            Toast.makeText(this, "+"+kolicinaBroj, Toast.LENGTH_SHORT).show();
            Store.narudzbine.add(new Narudzbina(Store.products.get(index), kolicinaBroj, Integer.parseInt(Store.products.get(index).price)*kolicinaBroj));
        }
        else{
            Toast.makeText(this, "Niste uneli željenu količinu!", Toast.LENGTH_SHORT).show();
        }

    }
}