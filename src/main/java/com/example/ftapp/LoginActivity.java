package com.example.ftapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private Toolbar actionbarLogin;
    private EditText txtemail,txtpassword;
    private Button btnlgn;


    private FirebaseAuth auth;
    private FirebaseUser currentuser;

    public void init()
    {
        actionbarLogin=(Toolbar)findViewById(R.id.actionbarlogin);
        setSupportActionBar(actionbarLogin);
        getSupportActionBar().setTitle("LOGİN");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        auth=FirebaseAuth.getInstance();

        currentuser=auth.getCurrentUser();

        txtemail=(EditText)findViewById(R.id.username);
        txtpassword=(EditText)findViewById(R.id.password);
        btnlgn=(Button)findViewById(R.id.ok)

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

        btnlgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loginuser();
            }
        });
    }

    private void loginuser() {

        String email=txtemail.getText().toString();
        String password=txtpassword.getText().toString();

        if(TextUtils.isEmpty(email))
        {
            Toast.makeText(LoginActivity.this,"email space can't be null",Toast.LENGTH_LONG).show();


        }else if(TextUtils.isEmpty(password))
        {
            Toast.makeText(LoginActivity.this,"password space can't be null",Toast.LENGTH_LONG).show();

        }
        else
        {
            auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        Toast.makeText(LoginActivity.this,"Login is succesfully",Toast.LENGTH_LONG).show();

                        Intent mainintent=new Intent(LoginActivity.this,Main2Activity.class);
                        startActivity(mainintent);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(LoginActivity.this,"Login is not succesfully",Toast.LENGTH_LONG).show();

                    }
                }
            })
        }
    }
}
