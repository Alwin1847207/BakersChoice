package com.example.bakerschoice;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginActivity extends AppCompatActivity {
    Button register, login;
    EditText et1, et2;

    FirebaseAuth FBA;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FirebaseApp.initializeApp(this);

        et1 = (EditText) findViewById(R.id.EditText1);
        et2 = (EditText) findViewById(R.id.EditText2);
        register = (Button) findViewById(R.id.register);
        login = (Button) findViewById(R.id.login);
        FBA = FirebaseAuth.getInstance();

        String uname, pass;
        uname = et1.getText().toString();
        pass = et2.getText().toString();

//        register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(getApplicationContext(), registerActivity.class);
//                startActivity(i);
//            }
//        });
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(getApplicationContext(), MainActivity.class);
//                startActivity(i);
//            }
//        });

        FBA.signInWithEmailAndPassword(uname, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Intent i = new Intent(getApplicationContext(), registerActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        });
    }
}
