package com.example.zainab.attendence;

        //import static com.example.anubha.teach.Constants.FIRST_COLUMN;
       // import static com.example.anubha.teach.Constants.FOURTH_COLUMN;
        //import static com.example.anubha.teach.Constants.SECOND_COLUMN;
        import static com.example.zainab.attendence.AddStudent.s;
        import static com.example.zainab.attendence.Constants.FIRST_COLUMN;
        import static com.example.zainab.attendence.Constants.FOURTH_COLUMN;
        import static com.example.zainab.attendence.Constants.SECOND_COLUMN;
        import static com.example.zainab.attendence.Constants.THIRD_COLUMN;
        import static com.example.zainab.attendence.Main2Activity.total;
        import static com.example.zainab.attendence.Main2Activity.total1;
        import static com.example.zainab.attendence.Main4Activity.sname;
        //import static com.example.anubha.teach.Constants.THIRD_COLUMN;

        import java.io.BufferedReader;
        import java.io.FileInputStream;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.HashMap;

        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ListView;
        import android.widget.TextView;
        import android.widget.Toast;

public class Main3Activity extends Activity {
    String[] array = new String[s];
    int i1 =0;
    String dd= "mytextfile.txt";
    String dd1= "mytextfile1.txt";
    int a;
    private ArrayList<HashMap<String, String>> list;
    TextView textView;
    public void init(View view)
    {
        Intent intent = new Intent(Main3Activity.this, MainActivity.class);
        intent.putExtra("key",a);
        startActivity(intent);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        textView=(TextView)findViewById(R.id.textView);
        textView.setText(sname);
        ListView listView=(ListView)findViewById(R.id.listView1);

        list=new ArrayList<HashMap<String,String>>();

        a = getIntent().getIntExtra("key",0);
        Log.e("kkkkkkkk",String.valueOf(a));
        if(a==1){
            dd = "mytextfile.txt";
            dd1= "mytextfile1.txt";
        }
        if(a==2){
            dd = "mytextfile2.txt";
            dd1= "mytextfile3.txt";
        }
        try {
            FileInputStream fileIn = openFileInput(dd);
            InputStreamReader isr = new InputStreamReader(fileIn);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            FileInputStream fileIn1 = openFileInput(dd1);
            InputStreamReader isr1 = new InputStreamReader(fileIn1);
            BufferedReader bufferedReader1 = new BufferedReader(isr1);
            StringBuilder sb1 = new StringBuilder();
            String line1;
            while ((line = bufferedReader.readLine()) != null &&(line1 = bufferedReader1.readLine()) != null) {

                array[i1++] = line;
                HashMap<String, String> temp = new HashMap<String, String>();
                temp.put(FIRST_COLUMN, line);
                temp.put(SECOND_COLUMN, line1);
                temp.put(THIRD_COLUMN, String.valueOf(total1));
                float per;
                per=(Integer.parseInt(line1)/total1)*100;
                temp.put(FOURTH_COLUMN, String.valueOf(per)+"%");
                list.add(temp);


            }
            ListViewAdapter adapter = new ListViewAdapter(this, list);
            listView.setAdapter(adapter);


        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}