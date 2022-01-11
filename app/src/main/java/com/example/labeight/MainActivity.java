package com.example.labeight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
public static final String SHARED_NAME= ".shared";
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username =(EditText) findViewById(R.id.editTextTextPersonName);
        password=(EditText) findViewById(R.id.editTextTextPersonName2);
        load();



    }

    public void login (View v) {

        String user = username.getText().toString();
        String pass = password.getText().toString();

        if(user.equals("mustafa") && pass.equals("12345678")){
            save(user,pass);

        Intent intent = new Intent(this,Welcome.class);

        startActivity(intent);
        }
        else if (!user.equals("mustafa")){
            Toast.makeText(this, "user not found", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Error password is wrong", Toast.LENGTH_SHORT).show();
        }

    }

    public void register (View v){
        Intent intent = new Intent(this,Register.class);

        startActivity(intent);
    }

    public void save(String user, String pass){
        SharedPreferences shared = getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = shared.edit();
        edit.putString("username",user);
        edit.putString("password",pass);
        edit.commit();
    }

    public void load(){
        SharedPreferences shared = getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE);
        String user = shared.getString("username","");
        String pass = shared.getString("password","");
        username.setText(user);
        password.setText(pass);

    }
}