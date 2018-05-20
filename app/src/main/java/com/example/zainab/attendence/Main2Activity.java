package com.example.zainab.attendence;

import android.app.Activity;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.zainab.attendence.Main3Activity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import static com.example.zainab.attendence.AddStudent.s;

public class Main2Activity extends Activity {
    public static float total;
    int[] textmsg= new int[s];
    String dd= "mytextfile.txt";
    String dd1= "mytextfile1.txt";
    String dd2= "total1.txt";
    public static float total1;
    int a;
   ListView listView;
   int len;
    String[] array = new String[s];
int i1 =0,i3=0;




        public void init1(View view)
        {
            Intent intent = new Intent(this, Main3Activity.class);
            intent.putExtra("key",a);
            startActivity(intent);


        }
        // write text to file
        /*public void WriteBtn1(View v) {
            // add-write text into file
            for (int i = 0; i < s; i++) {
                Log.e("cccccc", String.valueOf(textmsg[i]));
            }
            try {
                FileOutputStream fileout=openFileOutput(dd1,MODE_PRIVATE);

                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fileout));

                for (int i = 0; i < s; i++) {
                    bw.write(String.valueOf(textmsg[i]));
                    bw.newLine();
                }

                bw.close();


                Toast.makeText(getBaseContext(), "File saved successfully!",
                        Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/




   /* public void LoadBtn(View v) {
            //reading text from file

            try {
                FileInputStream fileIn=openFileInput(dd);
                InputStreamReader isr = new InputStreamReader(fileIn);
                BufferedReader bufferedReader = new BufferedReader(isr);
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {

                    Toast.makeText(getBaseContext(), line,Toast.LENGTH_SHORT).show();
                    array[i1++]=line;
                    //i1++;

                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, array);

                // Getting the reference to the listview object of the layout
                ListView listView = (ListView) findViewById(R.id.listview);

                // Setting adapter to the listview
                listView.setAdapter(adapter);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/
    public void CheckBtn(View v) {
        //reading text from file

        try {

             listView = (ListView) findViewById(R.id.listview);
            len = listView.getCount();
            Log.e("ooooo",String.valueOf(len));
            SparseBooleanArray checked = listView.getCheckedItemPositions();
            for (int i = 0; i < len; i++)
                if (checked.get(i)) {
                    String item = array[i];
  /* do whatever you want with the checked item */
                    //Toast.makeText(getBaseContext(),item,Toast.LENGTH_SHORT).show();
                        textmsg[i]++;

                }

              total1++;
            FileOutputStream fileout1=openFileOutput(dd2,MODE_PRIVATE);
            OutputStreamWriter outputWriter1=new OutputStreamWriter(fileout1);
            outputWriter1.write(String.valueOf(total1));
            outputWriter1.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        Toast.makeText(getBaseContext(), "ATTENDENCE OF PRESENT STUDENT MARKED!",
                Toast.LENGTH_SHORT).show();
//write to file
        try {
            FileOutputStream fileout=openFileOutput(dd1,MODE_PRIVATE);

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fileout));

            for (int i = 0; i < s; i++) {
                bw.write(String.valueOf(textmsg[i]));
                bw.newLine();
            }

            bw.close();


            Toast.makeText(getBaseContext(), "File saved successfully!",
                    Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            FileOutputStream fileout=openFileOutput("total.txt",MODE_PRIVATE);

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fileout));

            for (int i = 0; i < 1; i++) {
                bw.write(String.valueOf(total));
                bw.newLine();
            }

            bw.close();


            Toast.makeText(getBaseContext(), "File saved successfully!",
                    Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*public void ReadBtn1(View v) {
        //reading text from file

        try {
            FileInputStream fileIn=openFileInput(dd1);
            InputStreamReader isr = new InputStreamReader(fileIn);
            BufferedReader bufferedReader = new BufferedReader(isr);

            String line;
            while ((line = bufferedReader.readLine()) != null) {

                Toast.makeText(getBaseContext(), line,Toast.LENGTH_SHORT).show();

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    public Button button1;
    @Override
        public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        a = getIntent().getIntExtra("key",0);
        Log.e("kkkkkkkk",String.valueOf(a));
        if(a==1){
            dd = "mytextfile.txt";
            dd1= "mytextfile1.txt";
            dd2 = "total1.txt";
        }
        if(a==2){
            dd = "mytextfile2.txt";
            dd1= "mytextfile3.txt";
            dd2 = "total2.txt";
        }

        button1 = (Button)findViewById(R.id.next);
        // Read text from file

        try {
            FileInputStream fileIn1=openFileInput(dd1);
            InputStreamReader isr1 = new InputStreamReader(fileIn1);
            BufferedReader bufferedReader = new BufferedReader(isr1);
            String line1;
            while ((line1 = bufferedReader.readLine()) != null) {

                //Toast.makeText(getBaseContext(), line1,Toast.LENGTH_SHORT).show();
                textmsg[i3++]=Integer.valueOf(line1);


            }


            FileInputStream fileIn2=openFileInput(dd2);
            InputStreamReader isr2 = new InputStreamReader(fileIn2);
            BufferedReader bufferedReader2 = new BufferedReader(isr2);
            StringBuilder sb1 = new StringBuilder();
            String line2;
            while ((line2 = bufferedReader2.readLine()) != null) {

                //Toast.makeText(getBaseContext(), line,Toast.LENGTH_SHORT).show();
                total1 = Float.valueOf(line2);
                //i1++;
                Log.e("fghjgg",line2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        //load information
        try {
            FileInputStream fileIn=openFileInput(dd);
            InputStreamReader isr = new InputStreamReader(fileIn);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                //Toast.makeText(getBaseContext(), line,Toast.LENGTH_SHORT).show();
                array[i1++]=line;
                //i1++;

            }



            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, array);

            // Getting the reference to the listview object of the layout
            ListView listView = (ListView) findViewById(R.id.listview);

            // Setting adapter to the listview
            listView.setAdapter(adapter);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    }

