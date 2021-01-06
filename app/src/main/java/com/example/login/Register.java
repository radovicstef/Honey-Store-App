package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setTitle("Registracija");
    }

    public void submitRegister(View view){
        EditText name = findViewById(R.id.nameRegister);
        EditText surname = findViewById(R.id.surnameRegister);
        EditText address = findViewById(R.id.addressRegister);
        EditText phone = findViewById(R.id.phoneRegister);
        EditText username = findViewById(R.id.usernameRegister);
        EditText password = findViewById(R.id.passwordRegister);

        String nameString = name.getText().toString();
        String surnameString = surname.getText().toString();
        String addressString = address.getText().toString();
        String phoneString = phone.getText().toString();
        String usernameString = username.getText().toString();
        String passwordString = password.getText().toString();

        for(int i=0; i<MainActivity.users.size(); i++){
            if(MainActivity.users.get(i).username.equals(usernameString)){
                Toast.makeText(this, "Username je već zauzet!", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        MainActivity.users.add(new User(nameString, surnameString, usernameString, addressString, phoneString, passwordString));

        Intent intent = new Intent(Register.this, MainActivity.class);
        Register.this.startActivity(intent);
    }
}