package com.example.aspark;

import android.app.Application;
import android.content.Context;

public class SparkApplication extends Application {
	private static Context mContext;

	@Override
	public void onCreate() {
		super.onCreate();
		mContext = this;
	}

	public static final Context getContext() {
		return mContext;
	}
}
