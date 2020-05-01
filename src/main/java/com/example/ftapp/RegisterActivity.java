package com.example.ftapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class RegisterActivity extends AppCompatActivity {

    private  Toolbar actionbarregister;

    private FirebaseAuth auth;

    private EditText txtusername,txtemail,txtpassword;
    private Button txtok;

    public void init()
    {
        actionbarregister=(Toolbar)findViewById(R.id.actionbarregister);
        setSupportActionBar(actionbarregister);
        getSupportActionBar().setTitle("ÜYE OL");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        auth=FirebaseAuth.getInstance();
        txtusername=(EditText)findViewById(R.id.username);
        txtemail=(EditText)findViewById(R.id.email);
        txtpassword=(EditText)findViewById(R.id.password);
        txtok=(Button)findViewById(R.id.ok);


        });


    }
    private void createNewAccount()
    {
        String username=txtusername.getText().toString();
        String email=txtemail.getText().toString();
        String password=txtpassword.getText().toString();

        if(TextUtils.isEmpty(email))
        {
            Toast.makeText(RegisterActivity.this,"email space can't be null",Toast.LENGTH_LONG).show();


        }else if(TextUtils.isEmpty(password))
        {
            Toast.makeText(RegisterActivity.this,"password space can't be null",Toast.LENGTH_LONG).show();

        }else
            {
            auth.createUserWithEmailAndPassword(email,password).addOnCanceledListener(new OnCompleteListener<>() {
                @Override
                public void onComplete(@NonNull Task task) {
                    if(task.isSuccessful())
                    {
                        Toast.makeText(RegisterActivity.this,"your account has been created",Toast.LENGTH_LONG).show();

                        Intent loginintent=new Intent(RegisterActivity.this,LoginActivity.class);
                        startActivity(loginintent);
                        finish();

                    }
                    else
                    {
                        Toast.makeText(RegisterActivity.this,"your account hasn't been created",Toast.LENGTH_LONG).show();

                    }
                }
            })
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();

        txtok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewAccount();
            }

        }
}
