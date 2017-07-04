package org.mightyfrog.dbflowtest;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * @author Shigehiro Soejima
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        FlowManager.init(this);
        FlowManager.getDatabase(AppDatabase.class).reset(this);
    }
}
