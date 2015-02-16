package com.peacemiki.android.util;

import android.util.Log;

import com.peacemiki.android.core.Global;

public class Trace {
	private final static String TAG = Global.instance.getApplicationName();
	private final static int TRACE_LEVEL_ERROR = 0;
	private final static int TRACE_LEVEL_WARNING = 1;
	private final static int TRACE_LEVEL_INFORMATION = 2;
	private final static int TRACE_LEVEL_DEBUG = 3;
	private final static int TRACE_LEVEL_VERBOSE = 4;
	
	private final static int TRACE_LEVEL = TRACE_LEVEL_VERBOSE;

	public static void e( String str )
	{
		if(TRACE_LEVEL >= TRACE_LEVEL_ERROR) {
			Exception e = new Exception();
			StackTraceElement element = e.getStackTrace()[1];
			Log.e( TAG, String.format("[%s %s] %s", element.getFileName(), element.getLineNumber(), str));
		}
	}

	public static void w( String str )
	{
		if(TRACE_LEVEL >= TRACE_LEVEL_WARNING) {
			Exception e = new Exception();
			StackTraceElement element = e.getStackTrace()[1];
			Log.w( TAG, String.format("[%s %s] %s", element.getFileName(), element.getLineNumber(), str));
		}
	}
	
	public static void w( Exception e )
	{
		if(TRACE_LEVEL >= TRACE_LEVEL_WARNING) {
			StackTraceElement element = e.getStackTrace()[1];
			Log.w( TAG, String.format("[%s %s %s]", element.getFileName(), element.getMethodName(), element.getLineNumber()));
		}
	}
	
	public static void i( String str )
	{
		if(TRACE_LEVEL >= TRACE_LEVEL_INFORMATION) {
			Exception e = new Exception();
			StackTraceElement element = e.getStackTrace()[1];
			Log.i( TAG, String.format("[%s %s] %s", element.getFileName(), element.getLineNumber(), str));
		}
	}

	public static void d( String str )
	{
		
		if(TRACE_LEVEL >= TRACE_LEVEL_DEBUG) {
			Exception e = new Exception();
			StackTraceElement element = e.getStackTrace()[1];
			Log.d( TAG, String.format("[%s %s] %s", element.getFileName(), element.getLineNumber(), str));
		}
	}

	public static void v( String str )
	{
		if(TRACE_LEVEL >= TRACE_LEVEL_VERBOSE) {
			Exception e = new Exception();
			StackTraceElement element = e.getStackTrace()[1];
			Log.v( TAG, String.format("[%s %s] %s", element.getFileName(), element.getLineNumber(), str));
		}
	}
	
	public static void dev( String str )
	{
		if(TRACE_LEVEL >= TRACE_LEVEL_WARNING) {
			Exception e = new Exception();
			StackTraceElement element = e.getStackTrace()[1];
			Log.e( TAG, String.format("[%s %s] %s", element.getFileName(), element.getLineNumber(), str));
		}
	}
}
