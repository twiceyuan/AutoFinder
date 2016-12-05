package com.twiceyuan.autofinder;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import java.lang.annotation.Annotation;

/**
 * Created by twiceYuan on 29/11/2016.
 * Email: i@twiceyuan.com
 * Site: http://twiceyuan.com
 *
 * 额外实践方式补充
 *
 * 在 Base 中 find，只有在该 Activity/Fragment/Holder 被注解 AutoFind 时进行自定绑定
 */
public class AutoFinderHelper {

    public static void find(final Activity activity) {
        find(activity, new ViewFinder() {
            @Override
            public View findViewById(int id) {
                return activity.findViewById(id);
            }

            @Override
            public Context getContext() {
                return activity;
            }
        });
    }

    public static void find(Object container, final View view) {
        find(container, new ViewFinder() {
            @Override
            public View findViewById(int id) {
                return view.findViewById(id);
            }

            @Override
            public Context getContext() {
                return view.getContext();
            }
        });
    }

    private static void find(Object container, ViewFinder viewFinder) {
        Annotation[] annotations = container.getClass().getAnnotations();
        if (annotations != null) {
            for (Annotation annotation : annotations) {
                if (annotation instanceof AutoFind) {
                    AutoFinder.injectViews(container, viewFinder);
                    return;
                }
            }
        }
    }
}
