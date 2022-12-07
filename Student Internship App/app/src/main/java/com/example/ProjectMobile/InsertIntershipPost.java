package com.example.ProjectMobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.example.ProjectMobile.Model.Data;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Date;

public class InsertIntershipPost extends AppCompatActivity {

    private Toolbar toolbar;

    private EditText intershipDomain;
    private EditText  intershipLevel;
    private EditText intershipLocation;
    private EditText intershipDuration;
    private EditText intershipContact ;
    private Button btn_post_int;

    //Firebase Auth

    private FirebaseAuth mAuth;
    private DatabaseReference mJobPost;

    private DatabaseReference mPublicDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_intership_post);


        toolbar = findViewById(R.id.insert_job_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Create InterShip Post");

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mAuth = FirebaseAuth.getInstance();

        FirebaseUser mUser = mAuth.getCurrentUser();
        String uId = mUser.getUid();

        mJobPost = FirebaseDatabase.getInstance().getReference().child("InterShop Post").child(uId);
        mPublicDatabase = FirebaseDatabase.getInstance().getReference().child("Public database");


        InsertJob();
    }

    private void InsertJob() {

        intershipDomain = findViewById(R.id.Domain);
        intershipLevel = findViewById(R.id.exprience);
        intershipLocation = findViewById(R.id.location);
        intershipDuration = findViewById(R.id.Duration);
        intershipContact = findViewById(R.id.Contact);


        btn_post_int = findViewById(R.id.btnPost);

        btn_post_int.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Domain =  intershipDomain.getText().toString().trim();
                String level =  intershipLevel.getText().toString().trim();
                String Location =  intershipLocation.getText().toString().trim();
                String Duration = intershipDuration.getText().toString().trim();
                String Contact =   intershipContact.getText().toString().trim();

                if(TextUtils.isEmpty(Domain)){
                    intershipDomain.setError("Required Field..");
                    return;
                }

                if(TextUtils.isEmpty(level)){
                    intershipLevel.setError("Required Field..");
                    return;
                }

                if(TextUtils.isEmpty(Location)){
                    intershipLocation.setError("Required Field..");
                    return;
                }

                if(TextUtils.isEmpty(Duration)){
                    intershipDuration.setError("Required Field..");
                    return;
                }
                if(TextUtils.isEmpty(Contact)){
                    intershipContact.setError("Required Field..");
                    return;
                }

                String id = mJobPost.push().getKey();

                String date = DateFormat.getDateInstance().format(new Date());

                Data data = new Data(Domain, level, Location, Duration,Contact, id,date);

                mJobPost.child(id).setValue(data);

                mPublicDatabase.child(id).setValue(data);

                Toast.makeText(getApplicationContext(),"Successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), IntershipPosted.class));




            }
        });
    }





}