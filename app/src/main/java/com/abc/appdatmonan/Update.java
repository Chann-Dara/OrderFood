package com.abc.appdatmonan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Update extends AppCompatActivity {
    //private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
//        final EditText editTextName= findViewById(R.id.updateTitle);
//        final EditText editTextPrice=findViewById(R.id.updatePrice);
//        final EditText editTextCode=findViewById(R.id.updateCode);
//        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
//        databaseReference = firebaseDatabase.getReference(Food.class.getSimpleName());
//        HashMap < String, Object > hashMap = new HashMap <>();
//            hashMap.put("title", editTextName.getText().toString());
//            hashMap.put("price", editTextPrice.getText().toString());
//            hashMap.put("code", editTextCode.getText().toString());

//            dbFood.update("-NI1WfhwYW3Uw-NjGdVS", hashMap).addOnSuccessListener(suc->{
//                Toast.makeText(Update.this,"Update Successfully",Toast.LENGTH_SHORT).show();
//            }).addOnFailureListener(er->{
//                Toast.makeText(this,""+er.getMessage(),Toast.LENGTH_SHORT).show();
//            });
//    }
//    static class dbFood extends AppCompatActivity{
//        private DatabaseReference databaseReference;
//
//        public Void Task<Void> dbFood(String key, HashMap < String, Object > hashMap){
//
//            return databaseReference.child(key).updateChildren(hashMap);
//        }
//        public Task<Void> remove(String key){
//
//            return databaseReference.child(key).removeValue();
//        }
   }

}