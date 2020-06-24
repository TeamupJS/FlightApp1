package com.example.flightapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    EditText u,p,p1;
    Button reg;
    String us,pas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"#dccfb1\">" + getString(R.string.app_name) + "</font>"));
        u=findViewById(R.id.user1);
        p=findViewById(R.id.pass1);
        p1=findViewById(R.id.pass1c);
        reg=findViewById(R.id.register);
        u.requestFocus();

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(p.getText().toString().equals(p1.getText().toString()))
                {
                    Intent i=new Intent(Main2Activity.this,MainActivity.class);
                    us=u.getText().toString();
                    pas=p.getText().toString();
                    i.putExtra("user",us);
                    i.putExtra("pass",pas);
                    startActivity(i);
                    finish();

                }
                else
                {
                    Toast toast=Toast.makeText(getApplicationContext(),"Passwords dont match",Toast.LENGTH_SHORT);
                    toast.show();

                }
            }
        });
    }
}
