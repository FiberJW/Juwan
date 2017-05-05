package io.github.datwheat.juwan;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;


public class JApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }
}
