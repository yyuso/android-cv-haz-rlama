package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
Button btnInsert ,btn2,btn3;
EditText et1,et2,et3,et4,et5,et6;
DatabaseReference databaseUsers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert= findViewById(R.id.button);
        btn2= findViewById(R.id.button2);
        btn3= findViewById(R.id.button5);
        et1= findViewById(R.id.editTextText);
        et2= findViewById(R.id.editTextText2);
        et3= findViewById(R.id.editTextText3);
        et4= findViewById(R.id.editTextTextEmailAddress);
        et5= findViewById(R.id.editTextText5);
        et6=findViewById(R.id.editTextPhone);

        databaseUsers = FirebaseDatabase.getInstance().getReference();

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsertData();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,UserList.class));
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(i);
            }
        });
    }

    private void InsertData() {

        String ad = et2.getText().toString();
        String yas = et3.getText().toString();
        String dil = et5.getText().toString();
        String tel = et6.getText().toString();
        String posta = et4.getText().toString();
        String gecmis = et1.getText().toString();
        String id = databaseUsers.push().getKey();

        if (!TextUtils.isEmpty(ad)&&!TextUtils.isEmpty(yas)&&!TextUtils.isEmpty(dil)&&!TextUtils.isEmpty(tel)&&!TextUtils.isEmpty(posta)&&!TextUtils.isEmpty(gecmis)){
            User user =  new User(ad,yas,dil,tel,posta,gecmis);
            databaseUsers.child("users").child(id).setValue(user)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(MainActivity.this, "Başarılı Bir Şekilde Cv'niz Oluşturuldu", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
        else {
            Toast.makeText(this, "Lütfen Boş Bırakmayınız", Toast.LENGTH_SHORT).show();
        }



    }
}