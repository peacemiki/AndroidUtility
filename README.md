# AndroidUtility

Utility API for personal projects.


### Flexible ViewHolder
	
	If using this, don't need to create ViewHolder for every ListView.
		
	public static <T extends View> T get(View v, int id)
	Type Parameters:
		T - object extends View.
	Parameters:
		v - convertView
		id - id for find view.
	Returns:
		The view if found or null otherwise.

### TaskUtility

    Note that if you use this method, you shouldn't check in your Activity's onPause().
    This is wrong place for checking Application is in the background.
    You should check in your Activity's onStop method, after you call super.onStop().
    
    Returns:
		true if application is running in foreground, false otherwise
    public boolean isApplicationInForegound();
    
