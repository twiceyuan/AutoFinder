package com.twiceyuan.autofinder;

/**
 * Created by twiceYuan on 27/11/2016.
 * Email: i@twiceyuan.com
 * Site: http://twiceyuan.com
 */

public class DefaultNameMatcher implements ViewNameMatcher {
    @Override
    public String convertFiledName(String field) {
        return field;
    }
}
