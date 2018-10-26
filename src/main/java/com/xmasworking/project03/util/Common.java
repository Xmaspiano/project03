package com.xmasworking.project03.util;

import java.util.Calendar;

/**
 * Created by IntelliJ IDEA.
 *
 * @author XmasPiano
 * @date 2018/10/25 - 下午2:57
 * Created by IntelliJ IDEA.
 */
public class Common {

    public static String getDateYM() {
        Calendar cale = Calendar.getInstance();
        int year = cale.get(Calendar.YEAR);
        int month = cale.get(Calendar.MONTH) + 1;

        String ym = year + (month < 10 ? "0" + month : month + "");
        return ym;
    }
}
