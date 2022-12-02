package com.example.ProjectMobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {

    private EditText emailReg;
    private EditText passReg;
    private EditText domainReg;

    private Button btnReg;
    private Button btnLogin;


    //Firebase Auth

    private FirebaseAuth mAuth;

    //progress dialog

    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mAuth=FirebaseAuth.getInstance();

        mDialog = new ProgressDialog(this);

        Registration();
    }

    private void Registration(){

        emailReg=findViewById(R.id.emaillogin);
        passReg=findViewById(R.id.passwordlogin);
        domainReg =findViewById(R.id.Domain);

        btnReg = findViewById(R.id.btnregister);
        btnLogin = findViewById(R.id.btnlogin);


        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String domain = domainReg.getText().toString().trim();

                String email = emailReg.getText().toString().trim();
                String pass = passReg.getText().toString().trim();

                if(TextUtils.isEmpty(email)) {
                    emailReg.setError("Required Field..");
                    return;
                }
                if(TextUtils.isEmpty(email)) {
                    domainReg .setError("Required Field..");
                    return;
                }

                if(TextUtils.isEmpty(pass))
                {
                    passReg.setError("Required Field..");
                    return;
                }

                mDialog.setMessage("Processing..");
                mDialog.show();

                mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT).show();

                            startActivity(new Intent(getApplicationContext(), AllJobActivity.class));

                            mDialog.dismiss();
                        } else{
                            Toast.makeText(getApplicationContext(), "Registration Failed..", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(), MainActivity.class));

            }
        });

    }
}