# AndroidUtility

Utility API for personal projects.


1. TaskUtility
/**
* Note that if you use this method, you shouldn't check in your Activity's onPause().
* This is wrong place for checking Application is in the background.
* You should check in your Activity's onStop method, after you call super.onStop().
* @return true if application is running in foreground, false otherwise
*/
public boolean isApplicationInForegound();
