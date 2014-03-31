package net.frakbot.glowpadbackport.util;

import android.os.Build;

/**
 * Class
 * <p/>
 * Author: Sebastiano Poggi
 * Created on: 1/28/13 Time: 3:57 PM
 * File version: 1.0
 * <p/>
 * Changelog:
 * Version 1.0
 * * Initial revision
 */
public class Const {
    public static final boolean IS_ECLAIR = Build.VERSION.SDK_INT >= Build.VERSION_CODES.ECLAIR;
    public static final boolean IS_FROYO = Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO;
    public static final boolean IS_ICS = Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH;
    public static final boolean IS_JB = Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN;
    public static final boolean IS_JB_MR1 = Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1;
}
