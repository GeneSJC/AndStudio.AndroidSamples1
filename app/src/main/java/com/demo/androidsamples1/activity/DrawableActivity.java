package com.demo.androidsamples1.activity;

import android.app.Activity;
import android.os.Bundle;

import com.demo.androidsamples1.util.DragAndDropListenerLogic;

/**
 * REFACTOR:
 * So that drag n drop is external to this class
 * 
 * Then can make DnD2 which extends this and then associates the DnD logic
 * 
 */
public class DrawableActivity extends Activity
{
	DragAndDropListenerLogic dragAndDropListener;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_demo_background);

		dragAndDropListener = new DragAndDropListenerLogic(this);
		
		dragAndDropListener.setDragDrop(R.id.my_sky_layout, R.id.sun );
	}


}
