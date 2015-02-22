package com.peacemiki.android.util;

import android.util.Log;

import com.peacemiki.android.core.Global;

public class Trace {
	private final static String TAG = Global.instance.getApplicationName();

    private static enum Level {
        ERROR(0),
        WARNING(1),
        INFORMATION(2),
        DEBUG(3),
        VERBOSE(4),
        DEVELOPMENT(5);

        private int identity;

        Level(int identity) {
            this.identity = identity;
        }

        public boolean isAllow(Level filterLevel) {
            if(filterLevel.identity <= this.identity)
                return true;

            return false;
        }
    }
	
	private static Level mFilterLevel = Level.DEVELOPMENT;

    public static void setFilterLevel(Level level) {
        mFilterLevel = level;
    }

    public static Level getFilterLevel() {
        return mFilterLevel;
    }

	public static void e( String str )
	{
		if(Level.ERROR.isAllow(mFilterLevel)) {
			Exception e = new Exception();
			StackTraceElement element = e.getStackTrace()[1];
			Log.e( TAG, String.format("[%s %s] %s", element.getFileName(), element.getLineNumber(), str));
		}
	}

	public static void w( String str )
	{
		if(Level.ERROR.isAllow(mFilterLevel)) {
			Exception e = new Exception();
			StackTraceElement element = e.getStackTrace()[1];
			Log.w( TAG, String.format("[%s %s] %s", element.getFileName(), element.getLineNumber(), str));
		}
	}
	
	public static void w( Exception e )
	{
        if(Level.WARNING.isAllow(mFilterLevel)) {
			StackTraceElement element = e.getStackTrace()[1];
			Log.w( TAG, String.format("[%s %s %s]", element.getFileName(), element.getMethodName(), element.getLineNumber()));
		}
	}
	
	public static void i( String str )
	{
        if(Level.INFORMATION.isAllow(mFilterLevel)) {
			Exception e = new Exception();
			StackTraceElement element = e.getStackTrace()[1];
			Log.i( TAG, String.format("[%s %s] %s", element.getFileName(), element.getLineNumber(), str));
		}
	}

	public static void d( String str )
	{

        if(Level.DEBUG.isAllow(mFilterLevel)) {
			Exception e = new Exception();
			StackTraceElement element = e.getStackTrace()[1];
			Log.d( TAG, String.format("[%s %s] %s", element.getFileName(), element.getLineNumber(), str));
		}
	}

	public static void v( String str )
	{
        if(Level.VERBOSE.isAllow(mFilterLevel)) {
			Exception e = new Exception();
			StackTraceElement element = e.getStackTrace()[1];
			Log.v( TAG, String.format("[%s %s] %s", element.getFileName(), element.getLineNumber(), str));
		}
	}
	
	public static void dev( String str )
	{
        if(Level.DEVELOPMENT.isAllow(mFilterLevel)) {
			Exception e = new Exception();
			StackTraceElement element = e.getStackTrace()[1];
			Log.e( TAG, String.format("[%s %s] %s", element.getFileName(), element.getLineNumber(), str));
		}
	}
}
