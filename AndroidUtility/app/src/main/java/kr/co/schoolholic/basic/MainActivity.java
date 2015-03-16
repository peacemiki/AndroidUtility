package kr.co.schoolholic.basic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;

import kr.co.schoolholic.util.TaskUtil;
import kr.co.schoolholic.util.ViewHolder;


public class MainActivity extends Activity {

    private final String TAG = MainActivity.class.getName();
    private String[] mData = new String[]{
            "Android", "Base", "Cupcake", "Donut", "Eclair", "Froyo", "Gingerbread", "Honeycomb", "Icecreamsandwich", "Jellybean", "Kitkat", "Lollipop"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomAdapter adapter = new CustomAdapter(this, R.layout.listview_item, mData);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();

        String foreground = TaskUtil.instance.isApplicationInForeground() ? "Yes" : "No";

        Log.i(TAG, "Is application is running in foreground? " + foreground);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private class CustomAdapter extends ArrayAdapter<String> {
        private String[] mData;
        private int mLayoutId;
        private LayoutInflater mInflater;

        public CustomAdapter(Context context, int resourceId, String[] data) {
            super(context, resourceId, Arrays.asList(data));

            mData = data;
            mLayoutId = resourceId;
            mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = mInflater.inflate(mLayoutId, parent, false);
            }

            TextView textView = ViewHolder.get(convertView, R.id.text);
            textView.setText(mData[position]);

            return convertView;
        }
    }
}
