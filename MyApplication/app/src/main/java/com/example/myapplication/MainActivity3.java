package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    private TextView tvad,tvyas,tvdil,tvtel,tvposta,tvgecmis;
    private String tvad1,tvyas1,tvdil1,tvtel1,tvposta1,tvgecmis1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Bundle bundle = getIntent().getExtras();

        tanimla();
        tvad1 = bundle.getString("isim");
        tvyas1 = bundle.getString("yas");
        tvdil1 = bundle.getString("tel");
        tvtel1 = bundle.getString("diller");
        tvposta1 = bundle.getString("gecmis");
        tvgecmis1 = bundle.getString("posta");

        tvad.setText(tvad1);
        tvyas.setText(tvyas1);
        tvdil.setText(tvdil1);
        tvtel.setText(tvtel1);
        tvposta.setText(tvposta1);
        tvgecmis.setText(tvgecmis1);

    }
    private void tanimla(){
        tvad=findViewById(R.id.tvad);
        tvyas=findViewById(R.id.tvyas);
        tvdil=findViewById(R.id.tvdil);
        tvtel=findViewById(R.id.tvtel);
        tvposta=findViewById(R.id.tvposta);
        tvgecmis=findViewById(R.id.tvgecmis);
    }
}