package com.twiceyuan.autofinder;

import android.app.Activity;
import android.content.Context;
import android.view.View;

/**
 * Created by twiceYuan on 27/11/2016.
 * Email: i@twiceyuan.com
 * Site: http://twiceyuan.com
 */

class Utils {

    /**
     * 根据 resource 的 name （字符串）获得该资源的 ID
     */
    static int getResourceId(Context context, String variableName, String resourceType) {
        try {
            return context.getResources().getIdentifier(variableName, resourceType, context.getPackageName());
        } catch (Exception e) {
            return -1;
        }
    }

    static Context getContext(Object object) {
        if (object instanceof Activity) {
            return (Context) object;
        }

        if (object instanceof android.app.Fragment) {
            return ((android.app.Fragment) object).getActivity();
        }

        if (object instanceof android.support.v4.app.Fragment) {
            return ((android.support.v4.app.Fragment) object).getActivity();
        }

        if (object instanceof View) {
            return ((View) object).getContext();
        }

        return null;
    }
}
