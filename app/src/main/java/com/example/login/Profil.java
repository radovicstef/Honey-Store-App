package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Profil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        setProfileData();
        setTitle("Profil");
    }

    public void setProfileData(){
        EditText imeIzmena = (EditText)findViewById(R.id.imeIzmena);
        imeIzmena.setText(MainActivity.loginUser.name, TextView.BufferType.EDITABLE);

        EditText prezimeIzmena = (EditText)findViewById(R.id.prezimeIzmena);
        prezimeIzmena.setText(MainActivity.loginUser.surname, TextView.BufferType.EDITABLE);

        EditText passwordIzmena = (EditText)findViewById(R.id.passwordIzmena);
        passwordIzmena.setText(MainActivity.loginUser.password, TextView.BufferType.EDITABLE);

        EditText adresaIzmena = (EditText)findViewById(R.id.adresaIzmena);
        adresaIzmena.setText(MainActivity.loginUser.address, TextView.BufferType.EDITABLE);

        EditText telefonIzmena = (EditText)findViewById(R.id.telefonIzmena);
        telefonIzmena.setText(MainActivity.loginUser.phone, TextView.BufferType.EDITABLE);
    }

    public void changeProfile(View view){
        EditText imeIzmena = (EditText)findViewById(R.id.imeIzmena);
        EditText prezimeIzmena = (EditText)findViewById(R.id.prezimeIzmena);
        EditText passwordIzmena = (EditText)findViewById(R.id.passwordIzmena);
        EditText adresaIzmena = (EditText)findViewById(R.id.adresaIzmena);
        EditText telefonIzmena = (EditText)findViewById(R.id.telefonIzmena);

        MainActivity.loginUser.name = imeIzmena.getText().toString();
        MainActivity.loginUser.surname = prezimeIzmena.getText().toString();
        MainActivity.loginUser.password = passwordIzmena.getText().toString();
        MainActivity.loginUser.address = adresaIzmena.getText().toString();
        MainActivity.loginUser.phone = telefonIzmena.getText().toString();

        for(int i=0; i<MainActivity.users.size(); i++){
            if(MainActivity.users.get(i).username.equals(MainActivity.loginUser.username)){
                MainActivity.users.get(i).setName(MainActivity.loginUser.getName());
                MainActivity.users.get(i).setSurname(MainActivity.loginUser.getSurname());
                MainActivity.users.get(i).setPassword(MainActivity.loginUser.getPassword());
                MainActivity.users.get(i).setAddress(MainActivity.loginUser.getAddress());
                MainActivity.users.get(i).setPhone(MainActivity.loginUser.getPhone());
                MainActivity.users.get(i).setNarudzbine(MainActivity.loginUser.narudzbine);
                break;
            }
        }

        Toast.makeText(this, "Uspešno izmenjeni podaci!", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, Store.class);
        startActivity(intent);
    }

    public void logout(View view){
        Toast.makeText(this, "Doviđenja!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
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