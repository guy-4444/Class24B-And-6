package com.guy.class24b_and_6;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textview.MaterialTextView;

public class Activity_Main extends AppCompatActivity {

    private MaterialTextView main_LBL_info;

    private Fragment_List fragmentList;
    private Fragment_Map fragmentMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_LBL_info = findViewById(R.id.main_LBL_info);


        fragmentList = new Fragment_List();
        fragmentMap = new Fragment_Map();

        fragmentList.setCallBackList(meshulash);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_LAY_top, fragmentList)
                .add(R.id.main_LAY_bottom, fragmentMap)
                .commit();

    }

    @Override
    protected void onStart() {
        super.onStart();
        fragmentList.setUserName("Guy\nAvi\nMaayan\nShir");
    }

    private CallBack_List meshulash = new CallBack_List() {
        @Override
        public void showLocationInMap(String user) {
            fragmentMap.setLocation(32.4, 34.5);
        }
    };
}