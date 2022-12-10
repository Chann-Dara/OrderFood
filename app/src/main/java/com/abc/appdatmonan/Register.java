package com.abc.appdatmonan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setTitle("Register");
        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser()!=null){
            finish();
            return;
        }
        Button buttonRegister = findViewById(R.id.btnRegister);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                regiserUser();
            }
        });
        Button buttonLogin = findViewById(R.id.btnLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToLogin();
            }
        });
    }

    private void regiserUser() {
        EditText editTextFullName = findViewById(R.id.editView_fullName);
        EditText editTextEmail = findViewById(R.id.editView_email);
        EditText editTextPass = findViewById(R.id.editView_password);

        String fullName = editTextFullName.getText().toString();
        String email = editTextEmail.getText().toString();
        String password = editTextPass.getText().toString();

        if (fullName.isEmpty()||email.isEmpty()||password.isEmpty()){
            Toast.makeText(Register.this,"Please fill the blank fields.",Toast.LENGTH_SHORT).show();
            return;
        }
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            User user = new User(fullName,email);
                            FirebaseDatabase.getInstance().getReference("users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            showLogin();
                                        }
                                    });
                        }else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(Register.this,"Authentication Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void showLogin() {
        Toast.makeText(Register.this,"Register Successfully!",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Register.this, Login.class);
        startActivity(intent);
        finish();
    }
    private void switchToLogin() {
        Intent intent = new Intent(Register.this, Login.class);
        startActivity(intent);
        finish();
    }
}