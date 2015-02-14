# AndroidUtility

Utility API for personal projects.


### Util
    public static int dp2px(float dp);
    public static float px2dp(int px);

### TaskUtil

    Note that if you use this method, you shouldn't check in your Activity's onPause().
    This is wrong place for checking Application is in the background.
    You should check in your Activity's onStop method, after you call super.onStop().
    @return true if application is running in foreground, false otherwise
    
    public boolean isApplicationInForegound();
