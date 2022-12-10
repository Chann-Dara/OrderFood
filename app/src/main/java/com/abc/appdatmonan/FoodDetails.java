package com.abc.appdatmonan;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FoodDetails extends AppCompatActivity {
    ArrayList < FoodList.MyAdapter> arrayList;
    ImageView imageViewFood;
    TextView textViewTitle, textViewPrice,textViewCode;
    Button buttonAddFood, buttonUpdateFood, buttonDelete;
    int position=0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);
        //getSupportActionBar().setTitle("Details");
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);

        }
//        imageViewBack = findViewById(R.id.backImg);
//        imageViewBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getApplicationContext(), MainActivity.class));
//                finish();
//            }
//        });
//        imageViewUserProfile = findViewById(R.id.profileImg);
//        imageViewUserProfile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getApplicationContext(), MainActivity.class);
//                finish();
//            }
//        });
        buttonAddFood = findViewById(R.id.btnAdd_detail);
        buttonAddFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AddFood.class);
                startActivity(intent);
                finish();
            }
        });
        buttonUpdateFood = findViewById(R.id.btnEdit_detail);
        buttonUpdateFood.setOnClickListener(v->{
            Intent intent = new Intent(getApplicationContext(),Update.class);
            startActivity(intent);
            finish();
        });



        imageViewFood = findViewById(R.id.imageFood_detail);
        textViewTitle = findViewById(R.id.textTitle_detail);
        textViewPrice = findViewById(R.id.textPrice_detail);
        textViewCode = findViewById(R.id.textCode_detail);

        if (position == 0) {
            Intent intent = new Intent();
            Bundle bundle = this.getIntent().getExtras();
            int pic = bundle.getInt("image");
            String stTitle = bundle.getString("title");
            String stPrice = bundle.getString("price");
            String stCode = bundle.getString("code");

            imageViewFood.setImageResource(pic);
            textViewTitle.setText(stTitle);
            textViewPrice.setText(stPrice);
            textViewCode.setText(stCode);

            actionBar.setTitle(stTitle);

        }
        if (position == 1) {
            Intent intent = new Intent();
            Bundle bundle = this.getIntent().getExtras();
            int pic = bundle.getInt("image");
            String stTitle = bundle.getString("title");
            String stPrice = bundle.getString("price");
            String stCode = bundle.getString("code");

            imageViewFood.setImageResource(pic);
            textViewTitle.setText(stTitle);
            textViewPrice.setText(stPrice);
            textViewCode.setText(stCode);

            actionBar.setTitle(stTitle);

        }
        if (position == 2) {
            Intent intent = new Intent();
            Bundle bundle = this.getIntent().getExtras();
            int pic = bundle.getInt("image");
            String stTitle = bundle.getString("title");
            String stPrice = bundle.getString("price");
            String stCode = bundle.getString("code");

            imageViewFood.setImageResource(pic);
            textViewTitle.setText(stTitle);
            textViewPrice.setText(stPrice);
            textViewCode.setText(stCode);

            actionBar.setTitle(stTitle);

        }
        if (position == 3) {
            Intent intent = new Intent();
            Bundle bundle = this.getIntent().getExtras();
            int pic = bundle.getInt("image");
            String stTitle = bundle.getString("title");
            String stPrice = bundle.getString("price");
            String stCode = bundle.getString("code");

            imageViewFood.setImageResource(pic);
            textViewTitle.setText(stTitle);
            textViewPrice.setText(stPrice);
            textViewCode.setText(stCode);

            actionBar.setTitle(stTitle);

        }
        if (position == 4) {
            Intent intent = new Intent();
            Bundle bundle = this.getIntent().getExtras();
            int pic = bundle.getInt("image");
            String stTitle = bundle.getString("title");
            String stPrice = bundle.getString("price");
            String stCode = bundle.getString("code");

            imageViewFood.setImageResource(pic);
            textViewTitle.setText(stTitle);
            textViewPrice.setText(stPrice);
            textViewCode.setText(stCode);

            actionBar.setTitle(stTitle);

        }
        if (position == 5) {
            Intent intent = new Intent();
            Bundle bundle = this.getIntent().getExtras();
            int pic = bundle.getInt("image");
            String stTitle = bundle.getString("title");
            String stPrice = bundle.getString("price");
            String stCode = bundle.getString("code");

            imageViewFood.setImageResource(pic);
            textViewTitle.setText(stTitle);
            textViewPrice.setText(stPrice);
            textViewCode.setText(stCode);

            actionBar.setTitle(stTitle);

        }

    }
}