package com.abc.appdatmonan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("Login");
        //initialize firebase Auth
        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser()!=null){
            finish();
            return;
        }
        Button buttonLogin = findViewById(R.id.btnLogin1);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loginUser();
            }
        });


        Button buttonRegister = findViewById(R.id.btnRegister1);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switchToRegister();
            }
        });

    }

    private void loginUser() {
        EditText editTextEmail = findViewById(R.id.editView_email_login);
        EditText editTextPass = findViewById(R.id.editView_password_login);

        String email = editTextEmail.getText().toString();
        String pass = editTextPass.getText().toString();
        if (email.isEmpty()||pass.isEmpty()){
            Toast.makeText(Login.this,"Please fill the blank fields.",Toast.LENGTH_SHORT).show();
            return;
        }
        mAuth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            showMainActivity();
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(Login.this,"Login failed!",Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }
    private void showMainActivity() {
        Toast.makeText(Login.this,"Login Successfully",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Login.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void switchToRegister() {
        Intent intent = new Intent(Login.this, Register.class);
        startActivity(intent);
        finish();
    }
}