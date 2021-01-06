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
        products.add(new Product("Livadski med", "800", "Novkovic", "pic1", "Livadski med sadrži enzime, minerale i vitamine.\n" +
                "Ubrzava oporavak, osobama koje imaju nedostatak energije,\n" +
                "u slučaju pada imuniteta i prehlade.", "Normalne dnevne količine meda su:\n" +
                "- za odrasle: 60-100g, podeljeno u 3-4 dnevne doze\n" +
                "- za decu: 30-50g, podeljeno u 3-4 dnevne doze"));
        products.add(new Product("Bagremov med", "1000", "Novkovic", "pic2", "Bagremov med je odlično kardiotonično i neurotonično sredstvo. Ova vrsta meda preporučuje se kod stomačno-crevnih oboljenja, smetnji u varenju, oboljenja jetre i bubrega, a deluje i umirujuće na organizam.", "Normalne dnevne količine meda su:\n" +
                "za odrasle: 60-100g, podeljene u 3-4 doze u toku dana;\n" +
                "za decu: 30-50g, 3-4 puta u toku dana.\n"));
        products.add(new Product("Šumski med", "1000", "Novkovic", "pic3", "Šumski med se posebno preporučuje kao dodatak ishrani tokom lečenja od anemije. Ima antiseptičko, laksativno i umirujuće dejstvo. Zbog svog specifičnog sastava ovaj med efikasno poboljšava rad jetre i bubrega.", "U narodu je ova vrsta prirodnog meda poznata kao „muški med“ zbog jakog ukusa i arome. Bez obzira na to, mi ga preporučujemo svim osobama koje vole zdravu, aromatičnu hranu."));
        products.add(new Product("Suncokret med", "1000", "Novkovic", "pic4", "Suncokretov med je vrsta meda zlatnožute boje slabog mirisa, ali slatkog i oštrog ukusa. Odlikuje se voma brzom kristalizacijom. Konzumiranje kristalisanog meda je veoma korisno, jer se dugotrajnim otapanjem kristala meda preko podjezičnih žlezda sve korisne materije najkraćim putem unose u organizam.", "Suncokretov med može da se konzumira čist, 1-2 kafene kašičice dnevno. Med je najbolje uzimati ujutru na prazan stomak, polako otapati u ustima, a zatim progutati. Može da se upotrebljava i za zaslađivanje napitaka i poslastica."));
        products.add(new Product("Coko med", "1200", "Mijailovic", "pic9", "Ukusna i zdrava poslastica za sve uzraste.\n" +
                "Najfiniji spoj meda, kakaa, i lešnika, vrhunski je\n" +
                "užitak koji mami osmeh na lice.", "Upotrebljavati po volji. \n" +
                "Pre upotrebe potrebno je promešati.\n" +
                "\n"));
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