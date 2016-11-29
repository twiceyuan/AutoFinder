package com.twiceyuan.autofinder.sample;

import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

import com.twiceyuan.autofinder.AutoFinderHelper;

/**
 * Created by twiceYuan on 29/11/2016.
 * Email: i@twiceyuan.com
 * Site: http://twiceyuan.com
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        AutoFinderHelper.find(this);
    }
}
