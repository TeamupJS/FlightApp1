package com.example.flightapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {

    String from,to,fldate,flno,un,cl,for1,for2,tor1,tor2,fare1,nop2;
    float fare;
    Button b1;
    int nop;

    TextView fr1,fr2,to1,to2,tf,flidate,flino,classs,nop1,name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"#dccfb1\">" + getString(R.string.app_name) + "</font>"));
        name=findViewById(R.id.name);
        fr1=findViewById(R.id.fr1);
        fr2=findViewById(R.id.fr2);
        to1=findViewById(R.id.to1);
        to2=findViewById(R.id.to2);
        tf=findViewById(R.id.tf);
        flidate=findViewById(R.id.flidate);
        flino=findViewById(R.id.flino);
        classs=findViewById(R.id.classs);
        nop1=findViewById(R.id.nop);
        b1=findViewById(R.id.logout);

        Bundle b=getIntent().getExtras();
        if(b!=null)
        {
            un=b.getString("un");
            from=b.getString("from");
            to=b.getString("to");
            fldate=b.getString("fldate");
            flno=b.getString("flno");
            cl=b.getString("cl");
            fare=b.getFloat("fare");
            nop=b.getInt("nop");
        }

        fare1=Float.toString(fare);
        nop2=Integer.toString(nop);

        if(from.equals("Bengaluru (BLR)"))
        {
            for1="BLR";
            for2="Bengaluru";

        }
        else if(from.equals("Trivandrum (TRV)"))
        {
            for1="TRV";
            for2="Trivandrum";

        }
        else if(from.equals("Atlanta (ATL)"))
        {
            for1="ATL";
            for2="Atlanta";

        }
        else if(from.equals("Dubai (DXB)"))
        {
            for1="DXB";
            for2="Dubai";

        }
        else if(from.equals("London (LHR)"))
        {
            for1="LHR";
            for2="London";

        }

        if(to.equals("Bengaluru (BLR)"))
        {
            tor1="BLR";
            tor2="Bengaluru";

        }
        else if(to.equals("Trivandrum (TRV)"))
        {
            tor1="TRV";
            tor2="Trivandrum";

        }
        else if(to.equals("Atlanta (ATL)"))
        {
            tor1="ATL";
            tor2="Atlanta";

        }
        else if(to.equals("Dubai (DXB)"))
        {
            tor1="DXB";
            tor2="Dubai";

        }
        else if(to.equals("London (LHR)"))
        {
            tor1="LHR";
            tor2="London";

        }


        name.setText(un);
        fr1.setText(for1);
        fr2.setText(for2);
        to1.setText(tor1);
        to2.setText(tor2);
        tf.setText(fare1);
        nop1.setText(nop2);
        flidate.setText(fldate);
        flino.setText(flno);
        classs.setText(cl);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast=Toast.makeText(getApplicationContext(),"Logout Successful!",Toast.LENGTH_SHORT);
                toast.show();
                startActivity(new Intent(Main4Activity.this,MainActivity.class));
                finish();
            }
        });




    }
}
