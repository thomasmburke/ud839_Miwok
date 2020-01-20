/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumbersActivity extends AppCompatActivity {
    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        // Create array of numbers
        //String [] numbersArr = new String[10];
        ArrayList<Word> wordsArrList = new ArrayList<Word>();
        wordsArrList.add(new Word("one","lutti"));
        wordsArrList.add(new Word("two","otiiko"));
        wordsArrList.add(new Word("three","tolookosu"));
        wordsArrList.add(new Word("four","oyyisa"));
        wordsArrList.add(new Word("five","massokka"));
        wordsArrList.add(new Word("six","temmokka"));
        wordsArrList.add(new Word("seven","kenekaku"));
        wordsArrList.add(new Word("eight","kawinta"));
        wordsArrList.add(new Word("nine","wo'e"));
        wordsArrList.add(new Word("ten","na'aacha"));
        //Log.i(TAG, "size of ArrayList: "+ numbersArrList.size());
        //numbersArrList.addAll(Arrays.asList("one","two", "three", "four", "five","six", "seven", "eight", "nine", "ten"));
        //Log.i(TAG, "4th number is"+ numbersArrList.get(3));

        //ArrayAdapter<Word> itemsAdapter =
                //new ArrayAdapter<Word>(this, R.layout.list, R.id.textItem, numbersArrList);
        WordAdapter wordsAdapter =
                new WordAdapter(this, wordsArrList);
        ListView listView = (ListView) findViewById(R.id.listview_words);
        listView.setAdapter(wordsAdapter);
        /*
        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);
        for (int i=0; i<numbersArrList.size(); i++){
            TextView wordView = new TextView(this);
            wordView.setText(numbersArrList.get(i));
            rootView.addView(wordView);
        }*/
    }
}
