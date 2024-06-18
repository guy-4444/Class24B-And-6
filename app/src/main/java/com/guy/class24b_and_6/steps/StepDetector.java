package com.guy.class24b_and_6.steps;

import android.os.Handler;

import java.util.Random;

public class StepDetector {

    private final int DELAY = 1000;
    private Handler handler;
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            tick();
            handler.postDelayed(runnable, DELAY);
        }
    };

    private CallBack_Steps callBackSteps;

    public StepDetector(CallBack_Steps callBackSteps) {
        this.callBackSteps = callBackSteps;
    }

    public void start() {
        handler = new Handler();
        handler.postDelayed(runnable, DELAY);
    }

    public void stop() {
        handler.removeCallbacks(runnable);
    }

    private void tick() {
        double d = new Random().nextDouble();
        if (d > 0.9) {
            if (callBackSteps != null) {
                callBackSteps.jumpDetected(5);
            }
        } else if (d > 0.7) {
            if (callBackSteps != null) {
                callBackSteps.stepDetected();
            }
        }
    }
}
