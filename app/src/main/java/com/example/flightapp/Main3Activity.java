package com.example.flightapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Random;

public class Main3Activity extends AppCompatActivity  {
    Spinner froms,tos,cl;
    TextView date1,date2;
    RadioButton rb1,rb2;
    EditText peo;
    String f,t,cla,dot,dor,ty,fno,u1;
    float t_fare;
    int nop1,da,da1,mo,mo1,ye,ye1;
    Button book;
    DatePickerDialog.OnDateSetListener dates1,dates2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"#dccfb1\">" + getString(R.string.app_name) + "</font>"));

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
        date1.setText("1/7/2020");

        Bundle b=getIntent().getExtras();
        if(b!=null)
        {
            u1=b.getString("un");
        }


        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date2.setText("8/7/2020");
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
                if(year<2020)
                {
                    Toast toast=Toast.makeText(getApplicationContext(),"Invalid year!",Toast.LENGTH_SHORT);
                    toast.show();
                    date1.setText("1/7/2020");
                }
                else if(year>2022)
                {
                    Toast toast=Toast.makeText(getApplicationContext(),"Cannot book tickets to such future years!",Toast.LENGTH_SHORT);
                    toast.show();
                    date1.setText("1/7/2020");
                }
                else if(year==2020 && month<7)
                {
                    Toast toast=Toast.makeText(getApplicationContext(),"Booking starts from next month! Please choose date after next month",Toast.LENGTH_SHORT);
                    toast.show();
                    date1.setText("1/7/2020");
                }

                else {
                    da=dayOfMonth;
                    ye=year;
                    mo=month;
                    date1.setText(date);

                }

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
                da1=dayOfMonth;
                mo1=month;
                ye1=year;
                if(year<2020)
                {
                    Toast toast=Toast.makeText(getApplicationContext(),"Invalid year!",Toast.LENGTH_SHORT);
                    toast.show();
                    date2.setText("8/7/2020");
                }
                else if(year>2021)
                {
                    Toast toast=Toast.makeText(getApplicationContext(),"Cannot book tickets to such future years!",Toast.LENGTH_SHORT);
                    toast.show();
                    date2.setText("8/7/2020");
                }
                else if(year==2020 && month<7)
                {
                    Toast toast=Toast.makeText(getApplicationContext(),"Booking starts from next month! Please choose date after next month",Toast.LENGTH_SHORT);
                    toast.show();
                    date2.setText("8/7/2020");
                }
                else if(ye1>=ye ) {
                    if(ye1==ye)
                    {
                        if(mo1==mo)
                        {
                            if(da1>=da+7)
                            {
                                date2.setText(date);

                            }

                            else
                            {
                                Toast toast=Toast.makeText(getApplicationContext(),"Book return ticket with minimum duration!",Toast.LENGTH_SHORT);
                                toast.show();
                                date2.setText("8/7/2020");
                            }


                        }
                        else if(mo1>mo)
                            date2.setText(date);
                        else
                        {
                            Toast toast=Toast.makeText(getApplicationContext(),"Return date less than Travel date!",Toast.LENGTH_SHORT);
                            toast.show();
                            date2.setText("8/7/2020");
                        }
                    }
                    else {

                        date2.setText(date);
                    }
                }
                else
                {
                    Toast toast=Toast.makeText(getApplicationContext(),"Book return ticket with minimum duration!",Toast.LENGTH_SHORT);
                    toast.show();
                    date2.setText("8/7/2020");
                }

            }
        };







        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(rb1.isChecked())
                    ty=rb1.getText().toString();
                else
                    ty=rb2.getText().toString();
                nop1=Integer.parseInt(peo.getText().toString());
                cla=cl.getSelectedItem().toString();
                f=froms.getSelectedItem().toString();
                t=tos.getSelectedItem().toString();
                String[] fl= getApplicationContext().getResources().getStringArray(R.array.flightno);
                int r=new Random().nextInt(fl.length);
                fno=fl[r];
                dot=date1.getText().toString();
                dor=date2.getText().toString();

                if(cla.equals("Economy"))
                {
                    if((f.equals("Bengaluru (BLR)") && t.equals("Trivandrum (TRV)"))|| ((t.equals("Bengaluru (BLR)") && f.equals("Trivandrum (TRV)"))))
                    {
                        t_fare=nop1*(2000);
                    }

                    else if((f.equals("Bengaluru (BLR)") && t.equals("Atlanta (ATL)"))|| ((t.equals("Bengaluru (BLR)") && f.equals("Atlanta (ATL)"))))
                    {
                        t_fare=nop1*(100000);
                    }
                    else if((f.equals("Bengaluru (BLR)") && t.equals("Dubai (DXB)"))|| ((t.equals("Bengaluru (BLR)") && f.equals("Dubai (DXB)"))))
                    {
                        t_fare=nop1*(20000);
                    }
                    else if((f.equals("Bengaluru (BLR)") && t.equals("London (LHR)"))|| ((t.equals("Bengaluru (BLR)") && f.equals("London (LHR)"))))
                    {
                        t_fare=nop1*(80000);
                    }
                    else if((f.equals("Trivandrum (TRV)") && t.equals("Atlanta (ATL)"))|| ((t.equals("Trivandrum (TRV)") && f.equals("Atlanta (ATL)"))))
                    {
                        t_fare=nop1*(120000);
                    }
                    else if((f.equals("Trivandrum (TRV)") && t.equals("Dubai (DXB)"))|| ((t.equals("Trivandrum (TRV)") && f.equals("Dubai (DXB)"))))
                    {
                        t_fare=nop1*(25000);
                    }
                    else if((f.equals("Trivandrum (TRV)") && t.equals("London (LHR)"))|| ((t.equals("Trivandrum (TRV)") && f.equals("London (LHR)"))))
                    {
                        t_fare=nop1*(90000);
                    }
                    else if((f.equals("Atlanta (ATL)") && t.equals("Dubai (DXB)"))|| ((t.equals("Atlanta (ATL)") && f.equals("Dubai (DXB)"))))
                    {
                        t_fare=nop1*(85000);
                    }
                    else if((f.equals("Atlanta (ATL)") && t.equals("London (LHR)"))|| ((t.equals("Atlanta (ATL)") && f.equals("London (LHR)"))))
                    {
                        t_fare=nop1*(75000);
                    }
                    else if((f.equals("Dubai (DXB)") && t.equals("London (LHR)"))|| ((t.equals("Dubai (DXB)") && f.equals("London (LHR)"))))
                    {
                        t_fare=nop1*(50000);
                    }


                }
                else if(cla.equals("Business"))
                {
                    if((f.equals("Bengaluru (BLR)") && t.equals("Trivandrum (TRV)"))|| ((t.equals("Bengaluru (BLR)") && f.equals("Trivandrum (TRV)"))))
                    {
                        t_fare=nop1*(2000+5000);
                    }

                    else if((f.equals("Bengaluru (BLR)") && t.equals("Atlanta (ATL)"))|| ((t.equals("Bengaluru (BLR)") && f.equals("Atlanta (ATL)"))))
                    {
                        t_fare=nop1*(100000+5000);
                    }
                    else if((f.equals("Bengaluru (BLR)") && t.equals("Dubai (DXB)"))|| ((t.equals("Bengaluru (BLR)") && f.equals("Dubai (DXB)"))))
                    {
                        t_fare=nop1*(20000+5000);
                    }
                    else if((f.equals("Bengaluru (BLR)") && t.equals("London (LHR)"))|| ((t.equals("Bengaluru (BLR)") && f.equals("London (LHR)"))))
                    {
                        t_fare=nop1*(80000+5000);
                    }
                    else if((f.equals("Trivandrum (TRV)") && t.equals("Atlanta (ATL)"))|| ((t.equals("Trivandrum (TRV)") && f.equals("Atlanta (ATL)"))))
                    {
                        t_fare=nop1*(120000+5000);
                    }
                    else if((f.equals("Trivandrum (TRV)") && t.equals("Dubai (DXB)"))|| ((t.equals("Trivandrum (TRV)") && f.equals("Dubai (DXB)"))))
                    {
                        t_fare=nop1*(25000+5000);
                    }
                    else if((f.equals("Trivandrum (TRV)") && t.equals("London (LHR)"))|| ((t.equals("Trivandrum (TRV)") && f.equals("London (LHR)"))))
                    {
                        t_fare=nop1*(90000+5000);
                    }
                    else if((f.equals("Atlanta (ATL)") && t.equals("Dubai (DXB)"))|| ((t.equals("Atlanta (ATL)") && f.equals("Dubai (DXB)"))))
                    {
                        t_fare=nop1*(85000+5000);
                    }
                    else if((f.equals("Atlanta (ATL)") && t.equals("London (LHR)"))|| ((t.equals("Atlanta (ATL)") && f.equals("London (LHR)"))))
                    {
                        t_fare=nop1*(75000+5000);
                    }
                    else if((f.equals("Dubai (DXB)") && t.equals("London (LHR)"))|| ((t.equals("Dubai (DXB)") && f.equals("London (LHR)"))))
                    {
                        t_fare=nop1*(50000+5000);
                    }

                }
                else
                {
                    if((f.equals("Bengaluru (BLR)") && t.equals("Trivandrum (TRV)"))|| ((t.equals("Bengaluru (BLR)") && f.equals("Trivandrum (TRV)"))))
                    {
                        t_fare=nop1*(2000+20000);
                    }

                    else if((f.equals("Bengaluru (BLR)") && t.equals("Atlanta (ATL)"))|| ((t.equals("Bengaluru (BLR)") && f.equals("Atlanta (ATL)"))))
                    {
                        t_fare=nop1*(100000+20000);
                    }
                    else if((f.equals("Bengaluru (BLR)") && t.equals("Dubai (DXB)"))|| ((t.equals("Bengaluru (BLR)") && f.equals("Dubai (DXB)"))))
                    {
                        t_fare=nop1*(20000+20000);
                    }
                    else if((f.equals("Bengaluru (BLR)") && t.equals("London (LHR)"))|| ((t.equals("Bengaluru (BLR)") && f.equals("London (LHR)"))))
                    {
                        t_fare=nop1*(80000+20000);
                    }
                    else if((f.equals("Trivandrum (TRV)") && t.equals("Atlanta (ATL)"))|| ((t.equals("Trivandrum (TRV)") && f.equals("Atlanta (ATL)"))))
                    {
                        t_fare=nop1*(120000+20000);
                    }
                    else if((f.equals("Trivandrum (TRV)") && t.equals("Dubai (DXB)"))|| ((t.equals("Trivandrum (TRV)") && f.equals("Dubai (DXB)"))))
                    {
                        t_fare=nop1*(25000+20000);
                    }
                    else if((f.equals("Trivandrum (TRV)") && t.equals("London (LHR)"))|| ((t.equals("Trivandrum (TRV)") && f.equals("London (LHR)"))))
                    {
                        t_fare=nop1*(90000+20000);
                    }
                    else if((f.equals("Atlanta (ATL)") && t.equals("Dubai (DXB)"))|| ((t.equals("Atlanta (ATL)") && f.equals("Dubai (DXB)"))))
                    {
                        t_fare=nop1*(85000+20000);
                    }
                    else if((f.equals("Atlanta (ATL)") && t.equals("London (LHR)"))|| ((t.equals("Atlanta (ATL)") && f.equals("London (LHR)"))))
                    {
                        t_fare=nop1*(75000+20000);
                    }
                    else if((f.equals("Dubai (DXB)") && t.equals("London (LHR)"))|| ((t.equals("Dubai (DXB)") && f.equals("London (LHR)"))))
                    {
                        t_fare=nop1*(50000+20000);
                    }


                }

                Toast toast=Toast.makeText(getApplicationContext(),"Flight Booked!",Toast.LENGTH_SHORT);
                toast.show();
                Intent i=new Intent(Main3Activity.this,Main4Activity.class);
                i.putExtra("un",u1);
                i.putExtra("from",f);
                i.putExtra("to",t);
                i.putExtra("fare",t_fare);
                i.putExtra("fldate",dot);
                i.putExtra("flno",fno);
                i.putExtra("cl",cla);
                i.putExtra("nop",nop1);
                startActivity(i);
                finish();



            }
        });

        froms.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(froms.getSelectedItem().equals("Bengaluru (BLR)"))
                {
                    ArrayAdapter adapter1=ArrayAdapter.createFromResource(getApplicationContext(),R.array.c_blr,R.layout.spinner_item1);
                    tos.setAdapter(adapter1);

                }
                else if(froms.getSelectedItem().equals("Atlanta (ATL)"))
                {
                    ArrayAdapter adapter=ArrayAdapter.createFromResource(getApplicationContext(),R.array.c_atl,R.layout.spinner_item1);
                    tos.setAdapter(adapter);

                }
                else if(froms.getSelectedItem().equals("Trivandrum (TRV)"))
                {
                    ArrayAdapter adapter=ArrayAdapter.createFromResource(getApplicationContext(),R.array.c_trv,R.layout.spinner_item1);
                    tos.setAdapter(adapter);

                }
                else if(froms.getSelectedItem().equals("Dubai (DXB)"))
                {
                    ArrayAdapter adapter=ArrayAdapter.createFromResource(getApplicationContext(),R.array.c_dxb,R.layout.spinner_item1);
                    tos.setAdapter(adapter);

                }
                else
                {
                    ArrayAdapter adapter=ArrayAdapter.createFromResource(getApplicationContext(),R.array.c_lhr,R.layout.spinner_item1);
                    tos.setAdapter(adapter);

                }




            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


}
