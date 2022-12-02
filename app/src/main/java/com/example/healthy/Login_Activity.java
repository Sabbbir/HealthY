package com.example.healthy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button register = findViewById(R.id.sign_up);
        register.setOnClickListener((view) -> {
            startActivity(new Intent(this, Register_Activity.class));
        });


        Button login = findViewById(R.id.submit);
        login.setOnClickListener(view -> {

            EditText Email = findViewById(R.id.ET_username);
            EditText PassWord = findViewById(R.id.ET_password);
            String email = Email.getText().toString().trim();
            String password = PassWord.getText().toString().trim();
            Login(email, password);
            //startActivity(new Intent(this, MainActivity.class));
        });
    }

    private void Login(String email, String password) {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener((Task<AuthResult> task) -> {
                    if (!task.isSuccessful()) {
                        Log.i("Curr Logined", "Failed");

//                        Button login = findViewById(R.id.submit);
//
//                                login.setOnClickListener((view -> {
//                                    startActivity(new Intent(this, MenuPage.class));
//                                }));

                    } else {
                        Log.i("Curr Logined", "Successfully");

                        Intent i = new Intent(this, Register_Activity.class);
                        startActivity(i);

                    }
                });
    }
}