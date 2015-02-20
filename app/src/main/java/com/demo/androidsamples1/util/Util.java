package com.demo.androidsamples1.util;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Util
{
	public final static String DRAGDROP_BOOLEAN_KEY = "dragDrop_boolean";

	public static void myToast(View v, String msg)
	{
		Toast.makeText(v.getContext(), msg, Toast.LENGTH_LONG).show();
	}

	public static void debug1 ( String msg)
	{
		Log.d("DEBUG1", msg);
	}

	public static void goToActivity(View v, Class activityClass)
	{
		goToActivity(v, activityClass, null);
	}

	public static void goToActivity(View v, Class activityClass, Bundle bundle)
	{
		myToast(v, "Now will go to Activity: " + activityClass.getSimpleName());

		Intent intent = new Intent(v.getContext(), activityClass);

		if ( bundle != null)
		{
			intent.putExtras(bundle);
		}

		v.getContext().startActivity(intent);
	}

	public static String testReadTextFile(InputStream inputStream)
	{
		StringBuffer sb = new StringBuffer();

		BufferedReader in = null;
		try
		{
			in = new BufferedReader(new InputStreamReader(inputStream));
			String line;
			while ((line = in.readLine()) != null)
			{
				sb.append(line);
			}

		} catch (final IOException e)
		{
		} finally
		{
			try
			{
				in.close();
			} catch (IOException e)
			{
				// ignore //
			}
		}

		return sb.toString();

	}
}

/*
 * (non-Javadoc)
 *
 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
 *
 * @Override public boolean onCreateOptionsMenu(Menu menu) { // Inflate the
 * menu; this adds items to the action bar if it is present.
 * getMenuInflater().inflate(R.menu.demo_buttons, menu); return true; }
 */
