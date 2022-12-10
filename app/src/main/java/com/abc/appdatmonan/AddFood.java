package com.abc.appdatmonan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddFood extends AppCompatActivity {

    EditText addTitle, addPrice, addCode, addPUrl;
    Button buttonSave, buttonCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);
        addTitle = findViewById(R.id.addTitle);
        addPrice = findViewById(R.id.addPrice);
        addCode = findViewById(R.id.addCode);
        addPUrl = findViewById(R.id.addImage);

        buttonCancel = findViewById(R.id.btnCancel);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FoodDetails.class);
                startActivity(intent);
                finish();
            }
        });
        buttonSave = findViewById(R.id.btnSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processInsert();

            }
        });
    }

    private void processInsert() {
        Map <String,Object> map = new HashMap <>();
        map.put("Title",addTitle.getText().toString());
        map.put("Price",addPrice.getText().toString());
        map.put("Code",addCode.getText().toString());
        map.put("Url",addPUrl.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("Name").push().setValue(map)
                .addOnSuccessListener(new OnSuccessListener < Void >() {
                    @Override
                    public void onSuccess(Void unused) {
                        addTitle.setText("");
                        addPrice.setText("");
                        addCode.setText("");
                        addPUrl.setText("");
                        Toast.makeText(AddFood.this,"Insert Successfully",Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        addTitle.setText("");
                        addPrice.setText("");
                        addCode.setText("");
                        addPUrl.setText("");
                        Toast.makeText(AddFood.this,"Could not insert",Toast.LENGTH_SHORT).show();
                    }
                });

    }
}