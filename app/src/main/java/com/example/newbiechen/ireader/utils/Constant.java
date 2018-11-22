package com.example.newbiechen.ireader.utils;

import android.support.annotation.StringDef;

import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by newbiechen on 17-4-16.
 */

public class Constant {

    /*URL_BASE*/
    public static final String API_BASE_URL = "http://api.zhuishushenqi.com";
    public static final String IMG_BASE_URL = "http://statics.zhuishushenqi.com";
    //Book Date Convert Format
    public static final String FORMAT_BOOK_DATE = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String FORMAT_TIME = "HH:mm";
    //RxBus
    //BookCachePath (因为getCachePath引用了Context，所以必须是静态变量，不能够是静态常量)
    public static String BOOK_CACHE_PATH = FileUtils.getCachePath() + File.separator
            + "book_cache" + File.separator;


}
