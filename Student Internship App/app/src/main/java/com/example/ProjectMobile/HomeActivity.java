package com.example.ProjectMobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    private Button btnseeker;
    private Button btnrecruiter;

    //Toolbar


     private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);




        mAuth = FirebaseAuth.getInstance();


        btnseeker = findViewById(R.id.btnseeker);
        btnrecruiter = findViewById(R.id.btnecruiter);


        btnseeker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(), MainActivity.class));

            }
        });

        btnrecruiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(), LoginIntershipRecruter.class));

            }
        });

    }


 }