package com.demo.androidsamples1.activity;

import android.app.Activity;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.demo.androidsamples1.util.Util;

import java.io.IOException;
import java.io.InputStream;

public class DemoButtonsActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_demo_buttons);

		uiDemoButtons();
		backendDemoButtons();
	}

	// =======================================
	// BUTTON LOAD LOGIC

	private void uiDemoButtons()
	{
		final Button toast1Button = (Button) findViewById(R.id.toast1_button);
		toast1Button.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v)
			{
				Util.myToast(v, "Simple toast");

				LinearLayout layout = (LinearLayout) findViewById(R.id.layout_top);
				layout.setBackgroundResource(R.drawable.translate);
				TransitionDrawable transition = (TransitionDrawable) layout.getBackground();
				transition.startTransition(5000);
			}
		});

		connectButtonToActivity (R.id.list_button, DemoListActivity.class );
		connectButtonToActivity (R.id.tabs_button, DemoTabsActivity.class);
		connectButtonToActivity (R.id.drawables_gradient_button, DrawableDragDropActivity.class);

		Bundle paramsBundle = new Bundle();
		paramsBundle.putBoolean(Util.DRAGDROP_BOOLEAN_KEY, true);
		connectButtonToActivity (R.id.drawables_dragdrop_button, DrawableDragDropActivity.class, paramsBundle);
		
		connectButtonToActivity(R.id.circle_drawing_activity_button, CircleDrawingActivity.class);
		connectButtonToActivity(R.id.dnd_with_util_btn, DrawableActivity.class);
	}

	private void connectButtonToActivity(int androidResourceId, final Class activityClass)
	{
		connectButtonToActivity(androidResourceId, activityClass, null);
	}

	private void connectButtonToActivity(int androidResourceId, final Class activityClass, final Bundle bundle)
	{
		final Button button = (Button) findViewById(androidResourceId);
		button.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v) {

				Util.goToActivity(v, activityClass, bundle);
			}
		});

	}

	private void backendDemoButtons()
	{

		final Button readFileButton = (Button) findViewById(R.id.readfile_button);
		readFileButton.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v)
			{
			    try
			    {
			    		InputStream inputStream = getAssets().open("input1.txt");
			    		String fileContents = Util.testReadTextFile(inputStream);
			    		String msg = "read file contents = " + fileContents;
			    		Log.d("OK", msg);
			    		Util.myToast(v, msg);
			    }
			    catch (final IOException e)
			    {
			    		e.printStackTrace();
			    		Log.d("ex", e.toString());
			    }
			}
		});
	}
}


