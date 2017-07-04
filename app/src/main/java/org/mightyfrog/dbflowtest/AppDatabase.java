package org.mightyfrog.dbflowtest;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * @author Shigehiro Soejima
 */
@Database(name = AppDatabase.NAME, version = AppDatabase.VERSION)
public class AppDatabase {

    public static final String NAME = "AppDatabase";

    public static final int VERSION = 1;
}