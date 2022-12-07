package com.example.ProjectMobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ProjectMobile.Model.Data;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ViewAllInterships extends AppCompatActivity {

    private Toolbar toolbar;

    //Recycler
    private RecyclerView recyclerView;

    //Firebase
    private FirebaseAuth mAuth;
    private DatabaseReference mAllJobPost;









    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_interships);

        toolbar = findViewById(R.id.all_job_post);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("All Interships Post");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Database

        mAllJobPost = FirebaseDatabase.getInstance().getReference().child("Public database");
        mAllJobPost.keepSynced(true);

        recyclerView = findViewById(R.id.recycler_all_job);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        mAuth = FirebaseAuth.getInstance();


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.mainmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.logout:
                mAuth.signOut();
                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                break;


        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    protected void onStart(){
        super.onStart();

        FirebaseRecyclerOptions<Data> firebaseRecyclerOptions =
                new FirebaseRecyclerOptions.Builder<Data>()
                        .setQuery(mAllJobPost, Data.class)
                        .build();

        FirebaseRecyclerAdapter<Data, AllJobPostViewHolder> adapter = new FirebaseRecyclerAdapter<Data, AllJobPostViewHolder>(firebaseRecyclerOptions) {

            @NonNull
            @Override
            public AllJobPostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.intershippost,parent,false);
                return new AllJobPostViewHolder(view);
            }


            @Override
            protected void onBindViewHolder(@NonNull AllJobPostViewHolder viewHolder, int i, @NonNull final Data model) {

                viewHolder.setDomain(model.getDomain());
                viewHolder.setJobDate(model.getDate());
                viewHolder.setLevel(model.getLevel());
                viewHolder.setlocation(model.getLocation());
                viewHolder.setDuration(model.getDuration());
                viewHolder.setContact(model.getContact());

                viewHolder.myview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(getApplicationContext(), IntershipDetails.class);

                        intent.putExtra("Domain",model.getDomain());
                        intent.putExtra("date", model.getDate());
                        intent.putExtra("level",model.getLevel());
                        intent.putExtra("location",model.getLocation());
                        intent.putExtra("Duration",model.getDuration());
                        intent.putExtra("Contact",model.getContact());

                        startActivity(intent);


                    }
                });

            }


        };


        adapter.startListening();
        recyclerView.setAdapter(adapter);

    }

    public static class AllJobPostViewHolder extends RecyclerView.ViewHolder{

        View myview;

        public AllJobPostViewHolder(@NonNull View itemView) {
            super(itemView);
            myview=itemView;
        }

        public void setDomain(String Domain){

            TextView mDomain = myview.findViewById(R.id.all_Domain);
            mDomain.setText("   "+Domain);

        }

        public void setJobDate(String date){
            TextView mDate = myview.findViewById(R.id.all_Date);
            mDate.setText("   "+date);
        }

        public void setLevel(String Level){
            TextView mLevel = myview.findViewById(R.id.all_levelneeded);
            mLevel.setText("   "+Level);
        }

        public void setlocation(String Location){
            TextView mLocation = myview.findViewById(R.id.all_location);
            mLocation.setText("   "+Location);
        }

        public void setDuration(String Duration){
            TextView mDuration = myview.findViewById(R.id.all_Duration);
            mDuration.setText("   "+Duration);
        }
        public void setContact(String Contact){
            TextView mContact = myview.findViewById(R.id.all_Contact);
            mContact.setText("   "+Contact);
        }


    }




}