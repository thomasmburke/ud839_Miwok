package com.example.android.miwok;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class NumbersOnClickListener extends AppCompatActivity implements View.OnClickListener {
    @Override
    public void onClick(View view){
        Toast.makeText(view.getContext(), "About to open the list of numbers", Toast.LENGTH_SHORT).show();
        //Intent numbersIntent = new Intent(MainActivity.class, NumbersActivity.class);
        //startActivity(numbersIntent);
    }

}
