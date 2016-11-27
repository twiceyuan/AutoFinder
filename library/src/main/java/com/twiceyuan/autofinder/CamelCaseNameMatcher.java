package com.twiceyuan.autofinder;

/**
 * Created by twiceYuan on 27/11/2016.
 * Email: i@twiceyuan.com
 * Site: http://twiceyuan.com
 *
 * mIAmTheAndroidDeveloper -> i_am_android_developer
 */
public class CamelCaseNameMatcher implements ViewNameMatcher {

    private String mPrefix;

    public CamelCaseNameMatcher(String prefix) {
        mPrefix = prefix;
    }

    public CamelCaseNameMatcher() {
    }

    @Override
    public String convertFiledName(String field) {
        if (mPrefix != null && field.startsWith(mPrefix)) {
            field = field.replaceFirst(mPrefix, "");
        }
        StringBuilder builder = new StringBuilder();
        boolean isFirstUppercase = true;
        for (char c : field.toCharArray()) {
            if (Character.isUpperCase(c)) {
                builder.append(isFirstUppercase ? "" : "_");
                builder.append(Character.toLowerCase(c));
                isFirstUppercase = false;
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
