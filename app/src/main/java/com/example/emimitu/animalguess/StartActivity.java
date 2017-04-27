package com.example.emimitu.animalguess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.suitebuilder.TestMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StartActivity extends AppCompatActivity {

    public void startGame(View view){

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        TextView welcomeTextView = (TextView)findViewById(R.id.welcomeTextView);
        welcomeTextView.bringToFront();
        Button startGameButton = (Button)findViewById(R.id.startGameButton);
        startGameButton.bringToFront();
    }
}
