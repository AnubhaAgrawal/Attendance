package com.example.zainab.attendence;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddStudent extends Activity {
    public static int s=0;
    // private ArrayList<String> listViewValues = new ArrayList<>();
    EditText textmsg;
    static final int READ_BLOCK_SIZE = 100;
    public Button button1;
    int i1=0;

    //final String[] array1 = new String[10];
    private ArrayList<String> array1 = new ArrayList<>();
    // private ArrayList<String> listViewValues = new ArrayList<>();
    String dd= "mytextfile.txt";
    String dd1= "mytextfile1.txt";
    String dd2= "total1.txt";
    int a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        button1 = (Button)findViewById(R.id.next);
        textmsg=(EditText)findViewById(R.id.editText1);

        a = getIntent().getIntExtra("key",0);
        Log.e("kkkkkkkk",String.valueOf(a));
        if(a==1){
            dd = "mytextfile.txt";
            dd1= "mytextfile1.txt";
            dd2= "total1.txt";
        }
        if(a==2){
            dd = "mytextfile2.txt";
            dd1= "mytextfile3.txt";
            dd2= "total2.txt";
        }


    }
    final public ArrayList <String> getListViewValues(){
        return array1;
    }

    public void init(View view)
    {


        Log.e("hhha", array1.toString());

        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("key",a);
        ///// intent.putExtra("array_list", array1.toString());
        startActivity(intent);


    }
    // write text to file
    public void WriteBtn(View v) {
        // add-write text into file

        try {

            FileOutputStream fileout=openFileOutput(dd, MODE_APPEND);
            OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
            outputWriter.write(textmsg.getText().toString());
            outputWriter.close();

            FileOutputStream fileout1=openFileOutput(dd1, MODE_APPEND);
            OutputStreamWriter outputWriter1=new OutputStreamWriter(fileout1);
            outputWriter.write("0");
            outputWriter.close();
            //display file saved message
            Toast.makeText(getBaseContext(), "File saved successfully!",
                    Toast.LENGTH_SHORT).show();
            FileInputStream fileIn=openFileInput("total.txt");
            InputStreamReader isr = new InputStreamReader(fileIn);
            BufferedReader bufferedReader = new BufferedReader(isr);

            String line;
            if((line = bufferedReader.readLine()) == null)
            {
                FileOutputStream total=openFileOutput("total.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriter2=new OutputStreamWriter(total);
                outputWriter.write("0");
                outputWriter.close();


            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }





    // Read text from file
    public void ReadBtn(View v) {
        //reading text from file

        try {
            FileInputStream fileIn=openFileInput(dd);
            InputStreamReader isr = new InputStreamReader(fileIn);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // sb.append(line);
                //Toast.makeText(getBaseContext(), line,Toast.LENGTH_SHORT).show();
                array1.add(line);
                s++;

                //i1++;
                //String path;
                //path= Environment.getExternalStorageDirectory().getAbsolutePath()+"/";
                //Log.e("pathhhhhhhhh",path);

            }

            if(s==0) {
                FileOutputStream fileout1 = openFileOutput(dd2, MODE_PRIVATE);
                OutputStreamWriter outputWriter1 = new OutputStreamWriter(fileout1);
                outputWriter1.write("0");
                outputWriter1.close();
            }
            Log.e("shoolaaaaalll", String.valueOf(s));
            Toast.makeText(getBaseContext(), "COUNTED SUCCESSFULLY!",
                    Toast.LENGTH_SHORT).show();
            // InputRead.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
