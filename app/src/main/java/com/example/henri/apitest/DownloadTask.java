package com.example.henri.apitest;

/**
 * Created by henri on 3/20/18.
 * // Henrique Magalhaes Pirani 14759
 */

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import javax.net.ssl.HttpsURLConnection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

// Class to get the API informations
public class DownloadTask extends AsyncTask<String, Void, String> {
    Double lat;
    Double lng;
    public static ArrayList<String> mydata = new ArrayList<String>();
    public static ArrayList<String> myAddres = new ArrayList<String>();
    public static ArrayList<Double> mylat = new ArrayList<Double>();
    public static ArrayList<Double> mylng = new ArrayList<Double>();


    @Override
    protected String doInBackground(String... urls) {

        String results = "";
        URL url;
        HttpsURLConnection urlConnection = null;

        try {
            url = new URL(urls[0]);

            urlConnection = (HttpsURLConnection) url.openConnection();

            InputStream in = urlConnection.getInputStream();

            InputStreamReader reader = new InputStreamReader(in);

            int data = reader.read();

            while (data != -1) {

                char current = (char) data;

                results += current;

                data = reader.read();
            }

            return results;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {
            // Get's all information on a JSONArray
            JSONArray JA = new JSONArray(s);
            for (int i=0; i<JA.length();i++){
                JSONObject JO = (JSONObject)JA.getJSONObject(i);
                // Get the relevant information and store in a string
                String dataInfo = "Name: " + JO.getString("name")+ "\n"+
                                  "Address: " + JO.getString("address")+ "\n"+
                                  "Status: " + JO.getString("status")+ "\n"+
                                  "Bike Stands: " + JO.getString("bike_stands")+ "\n"+
                                  "Available Bikes: " + JO.getString("available_bikes")+ "\n";
                mydata.add(dataInfo); // Add the information to a list
            }

// For to get the lat and lng from the API
            for (int i=0; i<JA.length();i++){
                JSONObject JO = (JSONObject)JA.getJSONObject(i);
                String dataInfo = JO.getString("position");
                String dataAddress = JO.getString("address");
                myAddres.add(dataAddress);
                JSONObject json = new JSONObject(dataInfo.toString());
                lat = json.getDouble("lat");
                lng = json.getDouble("lng");
                mylat.add(lat);
                mylng.add(lng);
               }
          //  Log.i("AAAAAAA", String.valueOf(lat));
           // Log.i("AAAAAAA", String.valueOf(lng));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}




