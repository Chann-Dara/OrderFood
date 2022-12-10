package com.abc.appdatmonan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class FoodList extends AppCompatActivity {

    ListView listView;
    String[] titleFood= {"Beef Sadad","Chicken Fried","Khmer Fish Souce",
            "Shrimp Fried With Peper","Fish Souce","Khmer Noddle"};
    String[] price = {"$3.50","$3.50","$3.50","$3.50","$3.50","$3.50"};
    String[] code = {"B0012","B0013","B0014","B0015","B0016","B0017"};
    int[] image = {R.drawable.food01,R.drawable.food02,R.drawable.food03,
            R.drawable.food04,R.drawable.food05,R.drawable.food06};
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);
        listView = findViewById(R.id.listFood);
        MyAdapter adapter = new MyAdapter(FoodList.this, titleFood, price, code, image);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView < ? > adapterView, View view, int position, long l) {
                if (position==0){
                    Toast.makeText(FoodList.this,"Beef Salad",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), FoodDetails.class);
//                    Bundle bundle = new Bundle();
//                    bundle.putInt("image", image[0]);
//                    intent.putExtra(bundle);

                    intent.putExtra("image", image[0]);

                    intent.putExtra("title", titleFood[0]);
                    intent.putExtra("price", price[0]);
                    intent.putExtra("code", code[0]);

                    intent.putExtra("position","" + 0);
                    startActivity(intent);
                }
                if (position==1){
                    Toast.makeText(FoodList.this,"Chicken Fried:",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(FoodList.this, FoodDetails.class);
                    intent.putExtra("image", image[1]);

                    intent.putExtra("title", titleFood[1]);
                    intent.putExtra("price", price[1]);
                    intent.putExtra("code", code[1]);

                    intent.putExtra("position","" + 1);
                    startActivity(intent);
                }
                if (position==2){
                    Toast.makeText(FoodList.this,"Khmer Fish Souce:",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(FoodList.this, FoodDetails.class);
                    intent.putExtra("image", image[2]);

                    intent.putExtra("title", titleFood[2]);
                    intent.putExtra("price", price[2]);
                    intent.putExtra("code", code[2]);

                    intent.putExtra("position","" + 2);
                    startActivity(intent);
                }
                if (position==3){
                    Toast.makeText(FoodList.this,"Shrimp Fried With Peper",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(FoodList.this, FoodDetails.class);
                    intent.putExtra("image", image[3]);

                    intent.putExtra("title", titleFood[3]);
                    intent.putExtra("price", price[3]);
                    intent.putExtra("code", code[3]);

                    intent.putExtra("position","" + 3);
                    startActivity(intent);
                }
                if (position==4){
                    Toast.makeText(FoodList.this,"Fish Souce",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(FoodList.this, FoodDetails.class);
                    intent.putExtra("image", image[4]);

                    intent.putExtra("title", titleFood[4]);
                    intent.putExtra("price", price[4]);
                    intent.putExtra("code", code[4]);

                    intent.putExtra("position","" + 4);
                    startActivity(intent);
                }
                if (position==5){
                    Toast.makeText(FoodList.this,"Khmer Noddle",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(FoodList.this, FoodDetails.class);
                    intent.putExtra("image", image[5]);

                    intent.putExtra("title", titleFood[0]);
                    intent.putExtra("price", price[5]);
                    intent.putExtra("code", code[5]);

                    intent.putExtra("position","" + 5);
                    startActivity(intent);
                }
            }
        });
//        Button btnSignout = findViewById(R.id.buttonSignout);
//        btnSignout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(),Login.class);
//                startActivity(intent);
//                finish();
//            }
//        });
        Button btnBack = findViewById(R.id.buttonBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    class MyAdapter extends ArrayAdapter <String> {
        Context context;
        String[] foodTitle;
        String[] foodPrice;
        String[] foodCode;
        int[] foodImg;

        MyAdapter(Context context, String[] foodTitle, String[] foodPrice, String[] foodCode,int[] foodImg) {
            super(context,R.layout.rows,R.id.listFood, foodTitle);
            this.context = context;
            this.foodTitle = foodTitle;
            this.foodPrice = foodPrice;
            this.foodCode = foodCode;
            this.foodImg = foodImg;
        }



        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.rows, parent,false);
            ImageView imgs = row.findViewById(R.id.imageFood);
            TextView txtTitle = row.findViewById(R.id.textName);
            TextView txtPrice = row.findViewById(R.id.textPrice);
            TextView txtCode = row.findViewById(R.id.textCode);

            imgs.setImageResource(foodImg[position]);
            txtTitle.setText(foodTitle[position]);
            txtPrice.setText(foodPrice[position]);
            txtCode.setText(foodCode[position]);


            return row;
        }
    }
}