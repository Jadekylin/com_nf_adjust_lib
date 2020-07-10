package com.wogame.adjust;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustConfig;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AdjustService {
    public static AdjustService mInstance;
    private Activity mActivity;

    public static AdjustService getInstance() {
        if (mInstance == null) {
            mInstance = new AdjustService();
        }
        return mInstance;
    }


    public void initApplication (Application app, final String appToken) {
        String environment = AdjustConfig.ENVIRONMENT_SANDBOX;
        AdjustConfig config = new AdjustConfig(app, appToken, environment);
        Adjust.onCreate(config);

        app.registerActivityLifecycleCallbacks(new AdjustLifecycleCallbacks());
    }


    public void initActivity(Activity activity) {
        mActivity = activity;

    }

    private static final class AdjustLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        @Override
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {

        }

        @Override
        public void onActivityStarted(@NonNull Activity activity) {

        }

        @Override
        public void onActivityResumed(Activity activity) {
            Adjust.onResume();
        }

        @Override
        public void onActivityPaused(Activity activity) {
            Adjust.onPause();
        }

        @Override
        public void onActivityStopped(@NonNull Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {

        }

        @Override
        public void onActivityDestroyed(@NonNull Activity activity) {

        }
    }
}
