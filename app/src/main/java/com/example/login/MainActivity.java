package com.example.login;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<User> users = new ArrayList<>();
    public static User loginUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        users.add(new User("Stefan", "Radovic", "stefan", "Rudo 3", "123456", "123"));
        setTitle("Medenjaci");
    }

    public void login(View view) {
        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);

        String usernameString = username.getText().toString();
        String passwordString = password.getText().toString();

        boolean successfulLogin = false;

        for(int i=0; i<users.size(); i++){
            if((users.get(i).username.equals(usernameString)) && (users.get(i).password.equals(passwordString))){
                loginUser = users.get(i);
                successfulLogin = true;
                break;
            }
        }

        if(successfulLogin){
            Intent intent = new Intent(MainActivity.this, Store.class);
            MainActivity.this.startActivity(intent);
        }
        else{
            Toast.makeText(this, "Neuspesna prijava!", Toast.LENGTH_SHORT).show();
        }
    }

    public void register(View view){
        Intent intent = new Intent(MainActivity.this, Register.class);
        MainActivity.this.startActivity(intent);
    }
}