package com.twiceyuan.autofinder;

import android.content.Context;
import android.view.View;

/**
 * Created by twiceYuan on 27/11/2016.
 * Email: i@twiceyuan.com
 * Site: http://twiceyuan.com
 */
interface ViewFinder {

    View findViewById(int id);

    Context getContext();
}
