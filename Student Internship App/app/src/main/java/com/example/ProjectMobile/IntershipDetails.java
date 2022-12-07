package com.example.ProjectMobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

public class IntershipDetails extends AppCompatActivity {

    private Toolbar toolbar;


    private TextView mDomain;
    private TextView mDate;
    private TextView mLevel;
    private TextView mLocation;
    private TextView mDuration;
    private TextView mContact;

    private Button btnApply;

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intership_details);

        toolbar = findViewById(R.id.toolbar_job_details);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("InterShip Details");

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mDomain = findViewById(R.id.domain_detail);
        mDate = findViewById(R.id.date_detail);
        mLevel = findViewById(R.id.levelneeded_detail);
        mLocation = findViewById(R.id.location_detail);
        mDuration = findViewById(R.id.duration_detail);
        mContact = findViewById(R.id.contact_detail);
        btnApply = findViewById(R.id.btnApply);



        //Receieve Data from all job activity using intent..

        Intent intent = getIntent();

        String domain = intent.getStringExtra("Domain");
        String date = intent.getStringExtra("date");
        String Level = intent.getStringExtra("level");
        String Location = intent.getStringExtra("location");
        String Duration = intent.getStringExtra("Duration");
        String Contact = intent.getStringExtra("Contact");

        mDomain.setText(domain);
        mDate.setText(date);
        mLevel.setText(Level);

        mLocation.setText(Location);
        mDuration.setText(Duration);
        mContact.setText(Contact);

        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(), UploadActivity.class));

            }
        });



    }


}