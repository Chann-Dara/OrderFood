package com.abc.appdatmonan;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.storage.FirebaseStorage;

public class MenuList extends AppCompatActivity {
    private Button buttonSave;
    private ImageView imageViewSave;
    private int REQUEST_CODE_IMG = 1;
    FirebaseStorage storage = FirebaseStorage.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_list);
        getSupportActionBar().setTitle("Menu Food");
        Button buttonSave = findViewById(R.id.btn_save);

        saveFile();

        imageViewSave.setOnClickListener((View) -> {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            //noinspection deprecation
            startActivityForResult(intent, REQUEST_CODE_IMG);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode==REQUEST_CODE_IMG && resultCode == RESULT_OK && data !=null){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imageViewSave.setImageBitmap(bitmap);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void saveFile() {
        Button buttonSave = findViewById(R.id.btn_save);
        ImageView imageViewSave = findViewById(R.id.image_food_item);

    }
}