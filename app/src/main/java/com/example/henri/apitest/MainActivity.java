package com.example.henri.apitest;
// Henrique Magalhaes Pirani 14759


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {

    Button click; // Variable type button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        click = (Button) findViewById(R.id.btn); // get's the button on scrre by its ID

        // method to get the API from Download Class
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DownloadTask task = new DownloadTask();

                task.execute("https://api.jcdecaux.com/vls/v1/stations?contract=Dublin&apiKey=66e19f413830dc04fe9cf2008a86fbe433ba4227");
            }
        });
}

// Change to List screem
public  void ToList(View view){
    Intent intent = new Intent(getApplicationContext(), List.class);

    startActivity(intent);
}
    // Change to Map screem
    public  void ToMap(View view){
        Intent intent = new Intent(getApplicationContext(), MapsActivity.class);

        startActivity(intent);
    }
    // Change to About screem
    public  void ToAbout(View view){
        Intent intent = new Intent(getApplicationContext(), About.class);

        startActivity(intent);
    }

}
