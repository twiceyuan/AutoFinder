package com.twiceyuan.autofinder;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Created by twiceYuan on 27/11/2016.
 * Email: i@twiceyuan.com
 * Site: http://twiceyuan.com
 */

public class AutoFinder {

    private static ViewNameMatcher mViewNameMatcher = new DefaultNameMatcher();

    public void setViewNameMatcher(ViewNameMatcher viewNameMatcher) {
        mViewNameMatcher = viewNameMatcher;
    }

    public static void find(final Activity activity) {
        injectViews(activity, new ViewFinder() {
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

    public static void find(Object holder, final View parentView) {
        injectViews(holder, new ViewFinder() {
            @Override
            public View findViewById(int id) {
                return parentView.findViewById(id);
            }

            @Override
            public Context getContext() {
                return parentView.getContext();
            }
        });
    }

    static void injectViews(Object holder, ViewFinder viewFinder) {
        Field[] declaredFields = holder.getClass().getDeclaredFields();

        for (Field declaredField : declaredFields) {
            if (isAutoFinderView(declaredField)) {
                declaredField.setAccessible(true);

                Class<?> finalClass = declaredField.getType();

                int viewId = Utils.getResourceId(
                        viewFinder.getContext(),
                        mViewNameMatcher.convertFiledName(declaredField.getName()),
                        "id");

                Object view = finalClass.cast(viewFinder.findViewById(viewId));
                try {
                    declaredField.set(holder, view);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

                declaredField.setAccessible(false);
            }
        }
    }

    private static boolean isAutoFinderView(Field field) {
        Class<?> type = field.getType();
        boolean isView = false;
        Class<?> superclass = type.getSuperclass();

        while (superclass != null && !isView) {
            isView = superclass.getName().equals("android.view.View");
            superclass = superclass.getSuperclass();
        }

        if (!isView) {
            return false;
        }

        Annotation[] annotations = field.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof IgnoreFind) {
                return false;
            }
        }
        return true;
    }
}
