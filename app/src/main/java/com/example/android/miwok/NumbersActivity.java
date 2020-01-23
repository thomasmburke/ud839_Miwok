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

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumbersActivity extends AppCompatActivity {
    private static final String TAG = "MyActivity";
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        // Create array of numbers
        //String [] numbersArr = new String[10];
        final ArrayList<Word> wordsArrList = new ArrayList<Word>();
        wordsArrList.add(new Word("one","lutti", R.drawable.number_one, R.raw.number_one));
        wordsArrList.add(new Word("two","otiiko", R.drawable.number_two, R.raw.number_two));
        wordsArrList.add(new Word("three","tolookosu", R.drawable.number_three, R.raw.number_three));
        wordsArrList.add(new Word("four","oyyisa",R.drawable.number_four, R.raw.number_four ));
        wordsArrList.add(new Word("five","massokka", R.drawable.number_five, R.raw.number_five));
        wordsArrList.add(new Word("six","temmokka", R.drawable.number_six, R.raw.number_six));
        wordsArrList.add(new Word("seven","kenekaku", R.drawable.number_seven, R.raw.number_seven));
        wordsArrList.add(new Word("eight","kawinta", R.drawable.number_eight, R.raw.number_eight));
        wordsArrList.add(new Word("nine","wo'e", R.drawable.number_nine, R.raw.number_nine));
        wordsArrList.add(new Word("ten","na'aacha",R.drawable.number_ten, R.raw.number_ten));
        //Log.i(TAG, "size of ArrayList: "+ numbersArrList.size());
        //numbersArrList.addAll(Arrays.asList("one","two", "three", "four", "five","six", "seven", "eight", "nine", "ten"));
        //Log.i(TAG, "4th number is"+ numbersArrList.get(3));

        //ArrayAdapter<Word> itemsAdapter =
                //new ArrayAdapter<Word>(this, R.layout.list, R.id.textItem, numbersArrList);
        WordAdapter wordsAdapter =
                new WordAdapter(this, wordsArrList, R.color.category_numbers);
        ListView listView = (ListView) findViewById(R.id.listview_words);
        listView.setAdapter(wordsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                //Toast.makeText(NumbersActivity.this, "List item clicked", Toast.LENGTH_SHORT).show();
                mp = MediaPlayer.create(NumbersActivity.this, wordsArrList.get(position).getAudioResourceId());
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        Toast.makeText(NumbersActivity.this, "I'm finito", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        /*
        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);
        for (int i=0; i<numbersArrList.size(); i++){
            TextView wordView = new TextView(this);
            wordView.setText(numbersArrList.get(i));
            rootView.addView(wordView);
        }*/
    }
}
