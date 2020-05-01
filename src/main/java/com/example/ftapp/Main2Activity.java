package com.example.ftapp;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TableLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Main2Activity extends AppCompatActivity {

    private FirebaseUser currentuser;

    private Toolbar actionBar;
    private ViewPager vpMain;
    private TabLayout tabsMain;
    private TabsAdapter tabsAdapter;

    private FirebaseAuth auth;
    private FirebaseUser currentUser;

    public void init()
    {
         actionBar=(Toolbar)findViewById(R.id.actionbar);
         setSupportActionBar(actionBar);
         getSupportActionBar().setTitle(R.string.app_name);

         auth=FirebaseAuth.getInstance();
         currentUser=auth.getCurrentUser();

         vpMain=(ViewPager)findViewById(R.id.vpmain);
         tabsAdapter=new TabsAdapter(getSupportFragmentManager());
         vpMain.setAdapter(tabsAdapter);

         tabsMain= (TabLayout) findViewById(R.id.tabsmain);
         tabsMain.setupWithViewPager(vpMain);


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
    }

    @Override
    protected void onStart() {

        if(currentuser==null)
        {
            Intent welcomeintent=new Intent(Main2Activity.this,MainActivity.class);
            startActivities(welcomeintent);
            finish();;
        }
        super.onStart();
    }

}
