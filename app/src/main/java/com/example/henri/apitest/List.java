package com.example.henri.apitest;
// Henrique Magalhaes Pirani 14759
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class List extends AppCompatActivity {
    public ListView mylist;
    public ArrayAdapter<String> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        mylist = (ListView) findViewById(R.id.mylist); // Find the list on the screen by getting it's API

        DownloadTask task = new DownloadTask();

        // Get's the list from Download and set the type of list
        arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, task.mydata);

        mylist.setAdapter(arrayAdapter); // show's the list on the screem

    }
}
