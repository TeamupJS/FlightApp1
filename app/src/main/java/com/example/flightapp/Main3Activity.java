package com.example.flightapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Main3Activity extends AppCompatActivity {
    Spinner froms,tos,cl;
    TextView date1,date2;
    RadioButton rb1,rb2;
    EditText peo;
    String f,t;
    float clamt,diamt;
    int nop1=0;
    Button book;
    DatePickerDialog.OnDateSetListener dates1,dates2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        froms=findViewById(R.id.froms);
        tos=findViewById(R.id.tos);
        date1=findViewById(R.id.date1);
        date2=findViewById(R.id.date2);
        rb1=findViewById(R.id.radioButton);
        rb2=findViewById(R.id.radioButton2);
        rb1.setChecked(true);
        cl=findViewById(R.id.cl);
        peo=findViewById(R.id.peo);
        book=findViewById(R.id.book);
        date2.setEnabled(false);


        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                date2.setEnabled(true);
            }
        });

        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date2.setEnabled(false);
                date2.setText("");
            }
        });





        ArrayAdapter adapter=ArrayAdapter.createFromResource(this,R.array.countries,R.layout.spinner_item);
        froms.setAdapter(adapter);
        tos.setAdapter(adapter);

        ArrayAdapter adapter1=ArrayAdapter.createFromResource(this,R.array.classes,R.layout.spinner_item);
        cl.setAdapter(adapter1);


        date1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal=Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                int month=cal.get(Calendar.MONTH);
                int day=cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog=new DatePickerDialog(
                        Main3Activity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        dates1,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });

        dates1=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month=month+1;
                String date=dayOfMonth+"/"+month+"/"+year;
                date1.setText(date);

            }
        };


        date2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal=Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                int month=cal.get(Calendar.MONTH);
                int day=cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog=new DatePickerDialog(
                        Main3Activity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        dates2,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });

        dates2=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month=month+1;
                String date=dayOfMonth+"/"+month+"/"+year;
                date2.setText(date);

            }
        };

        /*

        peo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int p=Integer.parseInt(peo.getText().toString());
                if(p<1)
                {
                    Toast toast=Toast.makeText(getApplicationContext(),"Invalid number",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if(p>5)
                {
                    Toast toast=Toast.makeText(getApplicationContext(),"Maximum people per booking is 5",Toast.LENGTH_SHORT);
                    toast.show();


                }
                else
                {
                    nop1+=Integer.parseInt(peo.getText().toString());
                    Toast toast=Toast.makeText(getApplicationContext(),nop1,Toast.LENGTH_SHORT);
                    toast.show();

                }

            }
        });

        */

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int p=Integer.parseInt(peo.getText().toString());
                if(p<1)
                {
                    Toast toast=Toast.makeText(getApplicationContext(),"Invalid number",Toast.LENGTH_SHORT);
                    toast.show();
                    peo.requestFocus();
                }
                else if(p>5)
                {
                    Toast toast=Toast.makeText(getApplicationContext(),"Maximum people per booking is 5",Toast.LENGTH_SHORT);
                    toast.show();
                    peo.requestFocus();


                }
                else
                {
                    nop1+=Integer.parseInt(peo.getText().toString());
                    Toast toast=Toast.makeText(getApplicationContext(),nop1,Toast.LENGTH_SHORT);
                    toast.show();

                }






            }
        });

    }
}
