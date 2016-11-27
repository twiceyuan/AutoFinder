package com.twiceyuan.autofinder.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.twiceyuan.autofinder.AutoFinder;
import com.twiceyuan.autofinder.IgnoreFind;

public class MainActivity extends AppCompatActivity {

    TextView hello_finder;

    LinearLayout container;

    String helloText = "Hello, Finder";
    String anotherText = "I'm another text view.";

    @IgnoreFind
    TextView anotherTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_layout);

        AutoFinder.find(this);

        hello_finder.setText(helloText);

        anotherTextView = new TextView(this);
        anotherTextView.setText(anotherText);

        container.addView(anotherTextView);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new SampleFragment())
                .commit();
    }
}
