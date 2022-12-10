package com.abc.appdatmonan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private TextView textViewFullName, textViewEmail;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Home");
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (mAuth.getCurrentUser()==null){
            startActivity(new Intent(this,Login.class));
            finish();
            return;
        }
        textViewFullName =findViewById(R.id.welcome_fullname);
        textViewEmail = findViewById(R.id.welcome_email);
        Button buttonLoguot = findViewById(R.id.btn_logout);
        buttonLoguot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logoutUser();
            }
        });

        Button buttonGoToMenu = findViewById(R.id.welcome_menu);
        buttonGoToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(MainActivity.this,"Go to menu page successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, FoodList.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();//Close user activity
            }
        });
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("users").child(currentUser.getUid());
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User user = snapshot.getValue(User.class);
                if (user != null) {
                    textViewFullName.setText("Full Name: " + user.fullName);
                    textViewEmail.setText("Email: " + user.email);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void logoutUser() {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(MainActivity.this, Login.class));
        finish();
    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        //inflate menu item
//        getMenuInflater().inflate(R.menu.common_menu, menu);
//        return super.onCreateOptionsMenu(menu);
//
//    }
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        int id = item.getItemId();
//        if (id == R.id.menu_refresh){
//            //Refresh action
//            startActivity(getIntent());
//            finish();
//            overridePendingTransition(0,0);
////        }else if (id == R.id.menu_updateProfile){
////            Intent intent = new Intent(UserProfile.this, UpdateProfile.class);
////            startActivity(intent);
////        }else if (id == R.id.menu_updateEmail){
////            Intent intent = new Intent(UserProfile.this, UpdateEmail.class);
////            startActivity(intent);
////        }else if (id == R.id.menu_setting){
////            Toast.makeText(UserProfile.this, "Setting",Toast.LENGTH_SHORT).show();
//////            Intent intent = new Intent(UserProfile.this, Setting.class);
//////            startActivity(intent);
////        }else if (id == R.id.menu_changePass){
////            Intent intent = new Intent(UserProfile.this, ChagnePassword.class);
////            startActivity(intent);
////        }else if (id == R.id.menu_deleteProfile){
////            Intent intent = new Intent(UserProfile.this, DeleteProfile.class);
////            startActivity(intent);
//        }else if (id == R.id.menu_signout){
//            mAuth.signOut();
//            Toast.makeText(MainActivity.this, "Logged Out", Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(MainActivity.this, Login.class);
//
//            //Clear stack
//            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
//            startActivity(intent);
//            finish();//Close user activity
//        }else {
//            Toast.makeText(MainActivity.this, "Somethings went wrong!", Toast.LENGTH_SHORT).show();
//        }
//        return super.onOptionsItemSelected(item);
//    }
}