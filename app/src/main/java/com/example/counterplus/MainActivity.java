package com.example.counterplus;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageButton imageButton;
    TextView textView;
    Button resetButton;
    int savedCount;
    SharedPreferences sharedPreferences;

    public void plusOne(View view) {
        textView.setText(String.valueOf(savedCount+=1));
        sharedPreferences.edit().putInt("mycount",savedCount).apply();


    }

    public void reset(View view) {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Are you sure want to reset ?")
                .setMessage("This will clear the current count and start over again from 'zero'.")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        textView.setText(String.valueOf(savedCount = 0));
                        sharedPreferences.edit().putInt("mycount",savedCount).apply();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageButton = (ImageButton) findViewById(R.id.imageButton);
        resetButton = (Button) findViewById(R.id.resetButton);
        textView = (TextView) findViewById(R.id.textView);


        sharedPreferences = this.getSharedPreferences("com.example.counterplus", Context.MODE_PRIVATE);

        savedCount = sharedPreferences.getInt("mycount",0);


        textView.setText(String.valueOf(savedCount));



    }
}



