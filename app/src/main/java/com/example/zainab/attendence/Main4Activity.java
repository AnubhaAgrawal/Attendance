
package com.example.zainab.attendence;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class Main4Activity extends AppCompatActivity {
   Spinner spinner;
   public static String sname;
   TextView time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        spinner=(Spinner)findViewById(R.id.spinner);
        time=(TextView)findViewById(R.id.textView8);
        long date1 = System.currentTimeMillis();

        SimpleDateFormat df = new SimpleDateFormat("MMM dd MM, yyyy h:mm a");
        String dateString = df.format(date1);
        time.setText(dateString);
    }

    public void init(View view)
    {

        sname=spinner.getSelectedItem().toString();
        if(sname.equals("Software Lab"))
        {
            Intent intent = new Intent(this, AddStudent.class);
            intent.putExtra("key",1);
            startActivity(intent);

        }
        if(sname.equals("Automata"))
        {
            Intent intent = new Intent(this, AddStudent.class);
            intent.putExtra("key",2);
            startActivity(intent);

        }

    }

    public void init1(View view)
    {

        Intent intent = new Intent(this, AddStudent.class);
        intent.putExtra("key",2);
        startActivity(intent);

    }

}

