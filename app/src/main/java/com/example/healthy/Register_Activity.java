package com.example.healthy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Register_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button submit = findViewById(R.id.btn_submit);
        submit.setOnClickListener(view -> {
            checkInfo();
        });
    }

    private void checkInfo() {
        EditText Name = findViewById(R.id.edt_txt_name);
        String name = Name.getText().toString().trim();
        if (name.isEmpty()) {
            Name.setError("Name can not be empty!");
            return;
        }
        EditText Email = findViewById(R.id.edt_txt_email);
        String email = Email.getText().toString().trim();
        if (email.isEmpty()) {
            Email.setError("Email can not be empty!");
            return;
        } else if (!email.contains("@")) {
            Email.setError("Invalid Email!");
            return;
        }
        EditText Age = findViewById(R.id.edt_txt_age);
        String age = Age.getText().toString().trim();
        if (age.isEmpty()) {
            Age.setError("Phone Number can not be empty!");
            return;
        }

        EditText Height = findViewById(R.id.height);
        String height = Height.getText().toString().trim();
        if (height.isEmpty()) {
            Height.setError("Username can not be empty!");
            return;
        }
        EditText PassWord = findViewById(R.id.edt_txt_pass);
        String password = PassWord.getText().toString().trim();
        if (password.isEmpty()) {
            PassWord.setError("Password can not be empty!");
            return;
        } else if (password.length() < 6) {
            PassWord.setError("Password length is less than 6!");
            return;
        }

        EditText ConfirmPassWord = findViewById(R.id.edt_txt_con_pass);
        String confirmPassword = ConfirmPassWord.getText().toString().trim();
        if (confirmPassword.isEmpty()) {
            ConfirmPassWord.setError("Re-Enter the password again!");
            return;
        }
        if (!password.equals(confirmPassword)) {
            ConfirmPassWord.setError("Password does not match");
            return;
        }


        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String prof = spinner.getSelectedItem().toString();

        //  Register(email, password);
        HashMap<String, Object> Data = new HashMap<>();
        Data.put("Name", name);
        Data.put("Email", email);
        Data.put("age", age);
        Data.put("Password", password);
        Data.put("Height", height);
        Data.put("Profession", prof);
        Log.i("DataGet", String.valueOf(Data));


        //  setDataToDatabase(Data);


    }

    private void Register(String email, String password) {

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener((Task<AuthResult> task) -> {
                    if (!task.isSuccessful()) {
                        Log.i("Registraion Failed", "Failed");
                    } else {
//                        Log.i("Registered", "Sucessfull");
//                        Intent intent = new Intent(this, LoginActivity.class);
//                        startActivity(intent);
                    }
                });

    }

}