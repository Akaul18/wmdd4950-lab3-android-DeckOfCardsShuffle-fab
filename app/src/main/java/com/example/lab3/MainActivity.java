package com.example.lab3;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int count = 51;
    private int imgIdFromDrawable;
    private String imgName;
    private List<String> finalList = new ArrayList<>();

    String[] ranks = {
            "ace","two","three","four","five", "six","seven", "eight", "nine", "ten", "jack",
            "queen","king"
    };

    String[] suits = {

            "spades", "clubs", "diamonds", "hearts"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);

        for(int i=0;i<suits.length;i++) {
            for (int j = 0; j < ranks.length; j++) {
                finalList.add(String.valueOf(new Cards(ranks[j], suits[i])));
            }
        }

        Collections.shuffle(finalList);

        fab.setOnClickListener(new View.OnClickListener() {
            TextView remaining = findViewById(R.id.textView3);
            ImageView img = (ImageView) findViewById(R.id.displayImage);

            @Override
            public void onClick(View view) {
//                Log.d(finalList.get(count), "error");
                imgName = finalList.get(count);

                imgIdFromDrawable = getResources().getIdentifier(imgName, "drawable",getPackageName());
                img.setImageResource(imgIdFromDrawable);

                remaining.setText(String.valueOf(count));

                count--;
                if(count == -1) count = 51;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.shuffle) {
            count = 51;
            TextView t = findViewById(R.id.textView3);
            t.setText("52");
            ImageView image = (ImageView) findViewById(R.id.displayImage);
            image.setImageResource(R.drawable.black_joker);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
