package com.example.bakerschoice.ui;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.bakerschoice.R;

@RequiresApi(api = Build.VERSION_CODES.N)
public class my_breads extends Fragment {
    private View v1;

    private static int hrs = android.icu.util.Calendar.HOUR_OF_DAY, mins = android.icu.util.Calendar.HOUR_OF_DAY;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v1 = inflater.inflate(R.layout.my_breads, container, false);


        return v1;
    }
}
