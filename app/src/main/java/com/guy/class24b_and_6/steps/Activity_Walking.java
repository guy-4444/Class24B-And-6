package com.guy.class24b_and_6.steps;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import com.guy.class24b_and_6.R;

public class Activity_Walking extends AppCompatActivity {

    private MaterialTextView walking_LBL_info;
    private MaterialButton walking_BTN_action;

    private StepDetector stepDetector;

    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walking);

        walking_LBL_info = findViewById(R.id.walking_LBL_info);
        walking_BTN_action = findViewById(R.id.walking_BTN_action);
        walking_BTN_action.setOnClickListener(v -> start());

        stepDetector = new StepDetector(callBackSteps);
    }

    private CallBack_Steps callBackSteps = new CallBack_Steps() {
        @Override
        public void stepDetected() {
            counter++;
            walking_LBL_info.setText("" + counter);
        }

        @Override
        public void jumpDetected(int height) {
            counter += height;
            walking_LBL_info.setText("" + counter);
        }
    };

    private void start() {
        stepDetector.start();
    }
}