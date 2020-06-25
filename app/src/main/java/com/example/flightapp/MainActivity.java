package com.example.flightapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText un,pa;
    Button lo;
    TextView n;
    String u1,p1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"#dccfb1\">" + getString(R.string.app_name) + "</font>"));


        un=findViewById(R.id.user);
        pa=findViewById(R.id.pass);
        lo=findViewById(R.id.login);
        n=findViewById(R.id.newuser);
        un.requestFocus();

        lo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle b=getIntent().getExtras();
                if(b!=null)
                {
                    u1=b.getString("user");
                    p1=b.getString("pass");
                }

                if(pa.getText().toString().equals(p1))
                {
                    if(un.getText().toString().equals(u1))
                    {
                        Toast toast=Toast.makeText(getApplicationContext(),"Login Successful!",Toast.LENGTH_SHORT);
                        toast.show();
                        Intent i=new Intent(MainActivity.this,Main3Activity.class);
                        i.putExtra("un",u1);
                        startActivity(i);

                    }

                    else
                    {
                        Toast toast=Toast.makeText(getApplicationContext(),"Invalid Username",Toast.LENGTH_SHORT);
                        toast.show();
                    }


                }

                else
                {
                    Toast toast=Toast.makeText(getApplicationContext(),"Account not found!",Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });

        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
            }
        });


    }
}
