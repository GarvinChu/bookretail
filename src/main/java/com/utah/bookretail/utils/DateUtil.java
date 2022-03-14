package com.utah.bookretail.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private DateUtil() {
    }

    /**
     * 获取系统当前时间（24小时制）
     * 区别：12小时制使用小写的hh，24小时制使用大写的HH
     *
     * @return 系统当前时间(年月日 时分秒)
     */
    public static String now() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = simpleDateFormat.format(new Date());
        return date;
    }

}
