package com.demo.androidsamples1.activity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class DemoListActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		// because we extend ListActivity, we can comment out setContentView, it
		// is not needed here and will cause your app to crash!
		// setContentView(R.layout.activity_c);

		String[] testValues = new String[] { "Android", "iPhone",
				"WindowsMobile", "Blackberry", "WebOS", "Ubuntu", "Windows 7",
				"Max OS X", "Linux", "OS/2" };

		ListAdapter adapter = createAdapter(testValues);
		setListAdapter(adapter);

        ListView listView = getListView();
        listView.setTextFilterEnabled(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
                Toast.makeText(getApplicationContext(),
                        ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

	// creates and returns a ListAdapter with String[] values
	protected ListAdapter createAdapter(String[] values)
	{
		ListAdapter adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, values);
		return adapter;
	}


}
