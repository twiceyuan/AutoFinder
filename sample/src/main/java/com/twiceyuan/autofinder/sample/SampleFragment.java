package com.twiceyuan.autofinder.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.twiceyuan.autofinder.AutoFinder;

/**
 * Created by twiceYuan on 27/11/2016.
 * Email: i@twiceyuan.com
 * Site: http://twiceyuan.com
 */

public class SampleFragment extends Fragment {

    TextView hello_finder;

    String helloText = "Hello, Fragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sample_layout, container, false);
        AutoFinder.find(this, view);

        hello_finder.setText(helloText);

        return view;
    }
}
