package com.codepath.debuggingchallenges.activities;

import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.codepath.debuggingchallenges.R;

public class ChangeBackgroundActivity extends AppCompatActivity {

    private int oldColor = Color.BLUE;
    Button btnGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_background);

        //The button wasn't being referenced nor did it have an onClickListener
        //Moreover in the .xml file there was a View interfering with the Button and the
        //Button has a pre-existent onClick listener that had no path
        btnGo = findViewById(R.id.btnGo);

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onGoClick(view);
            }
        });
    }

    public void onGoClick(View view) {
        View mainView = findViewById(android.R.id.content);
        mainView.setBackgroundColor(getNextColor());
    }

    private int getNextColor() {
        int newColor = (oldColor == Color.BLUE) ? Color.RED : Color.BLUE;
        oldColor = newColor;
        return newColor;
    }
}
