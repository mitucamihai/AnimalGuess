package com.example.emimitu.animalguess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Integer> animalsPicsArray;
    ArrayList<Integer> animalsAudioArray;
    ArrayList<String> animalsNamesArray;

    public void updateScreen(){

        InputStream is = getResources().openRawResource(R.raw.animals);
        InputStreamReader reader = new InputStreamReader(is);

        String fileOutput = "";
        try {
            int current = reader.read();
            while (current != -1 ){
                fileOutput += (char)current;
                current = reader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.i("JSON output", fileOutput);

        try {
            JSONArray jsonArray = new JSONArray(fileOutput);
            for (int i = 0; i < jsonArray.length(); i++ ){
                JSONObject jsonCurrent = jsonArray.getJSONObject(i);
                animalsNamesArray.add(i,jsonCurrent.getString("title"));
                animalsPicsArray.add(i, this.getResources().getIdentifier(jsonCurrent.getString("picture"),"drawable","com.example.emimitu.animalgues"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.i("log PIcs", "" + animalsPicsArray.get(0));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animalsAudioArray = new ArrayList<>();
        animalsNamesArray = new ArrayList<>();
        animalsPicsArray = new ArrayList<>();

        updateScreen();


    }
}
