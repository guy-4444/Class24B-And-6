package com.guy.class24b_and_6;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textview.MaterialTextView;

public class Fragment_Map extends Fragment {

    private MaterialTextView map_LBL_location;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);

        map_LBL_location = view.findViewById(R.id.map_LBL_location);

        return view;
    }

    public void setLocation(double lat, double lon) {
        map_LBL_location.setText(lat + ", " + lon);
    }

}
