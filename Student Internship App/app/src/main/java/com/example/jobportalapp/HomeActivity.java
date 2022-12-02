package com.example.jobportalapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    private Button btnAllJob;
    private Button btnPostJob;

    //Toolbar


     private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);




        mAuth = FirebaseAuth.getInstance();


        btnAllJob = findViewById(R.id.btnseeker);
        btnPostJob = findViewById(R.id.btnecruiter);


        btnAllJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(), MainActivity.class));

            }
        });

        btnPostJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(), MainActivityAdmin.class));

            }
        });

    }


 }