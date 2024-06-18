package com.guy.class24b_and_6;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.textview.MaterialTextView;

public class Fragment_List extends Fragment {

    private MaterialTextView list_LBL_user;

    private CallBack_List callBackList;
    private CallBack_Sing callBackSing;

    public void setCallBackList(CallBack_List callBackList) {
        this.callBackList = callBackList;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        list_LBL_user = view.findViewById(R.id.list_LBL_user);

        list_LBL_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callBackList != null) {
                    callBackList.showLocationInMap("Avi");
                }
            }
        });

        return view;
    }

    public void setUserName(String name) {
        list_LBL_user.setText(name);
    }

}
