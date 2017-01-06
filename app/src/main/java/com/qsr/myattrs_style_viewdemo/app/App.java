package com.qsr.myattrs_style_viewdemo.app;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

/**************************************
 * FileName : com.qsr.myattrs_style_viewdemo
 * Author : qsr
 * Time : 2017/1/6 11:39
 * Description : 全局文件
 **************************************/
public class App extends Application{
	public static Context mContext = null;
	public Handler handler = null;
	public static Thread mainThread = null;
	public static int mainThreadId = 0;//主线程id
	@Override
	public void onCreate() {
		super.onCreate();
		mContext = getApplicationContext();
		handler = new Handler();
		mainThread = Thread.currentThread();
		mainThreadId = android.os.Process.myPid();
	}
}
