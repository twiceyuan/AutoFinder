package com.twiceyuan.autofinder;

import android.content.Context;

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
}
