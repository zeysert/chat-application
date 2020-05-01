package com.example.ftapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin,btnRegister;


    public void init()
    {
        btnLogin=(Button)findViewById(R.id.btnLogin)
        btnRegister=(Button)findViewById(R.id.btnRegister)
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentlogin=new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intentlogin);


            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentregister=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intentregister);
            }
        });

    }
}
