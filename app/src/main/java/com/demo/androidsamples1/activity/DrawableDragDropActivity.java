package com.demo.androidsamples1.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.demo.androidsamples1.util.Util;

public class DrawableDragDropActivity extends Activity
{
	private View selected_item = null;
	private int offset_x = 0;
	private int offset_y = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_demo_background);

		boolean enableDragDrop = isDragDropEnabled();
		if (!enableDragDrop)
		{
			Util.debug1("enableDragDrop is false, so returning from activity ");
			return;
		}

		Util.debug1("enableDragDrop is TRUE, so adding DnD support in activity ");

		setDragDrop(R.id.my_sky_layout, R.id.sun );  // background layout and element id to drag
	}

	private boolean isDragDropEnabled()
	{
		Bundle b = getIntent().getExtras();
		boolean enableDragDrop = false;

		Util.debug1("b = " + b);

		if (b != null && b.containsKey(Util.DRAGDROP_BOOLEAN_KEY))
		{
			enableDragDrop = b.getBoolean(Util.DRAGDROP_BOOLEAN_KEY);
		}

		Util.debug1("enableDragDrop = " + enableDragDrop);

		return enableDragDrop;
	}

	private void setDragDrop(int viewGroup, int elementToTrack)
	{
		setDragDropViewGroup(viewGroup);

		setDragDropElement(elementToTrack);
	}

	private void setDragDropViewGroup (int viewGroup)
	{
		ViewGroup vg = (ViewGroup) findViewById(viewGroup);
		vg.setOnTouchListener(new View.OnTouchListener()
		{
			@Override
			public boolean onTouch(View v, MotionEvent event)
			{
				switch (event.getActionMasked())
				{
					case MotionEvent.ACTION_MOVE:
						int x = (int) event.getX() - offset_x;
						int y = (int) event.getY() - offset_y;

						int w = getWindowManager().getDefaultDisplay().getWidth() - 100;
						int h = getWindowManager().getDefaultDisplay().getHeight() - 100;
						if (x > w)
							x = w;
						if (y > h)
							y = h;

						RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
								new ViewGroup.MarginLayoutParams(
										RelativeLayout.LayoutParams.WRAP_CONTENT,
										RelativeLayout.LayoutParams.WRAP_CONTENT));
						lp.setMargins(x, y, 0, 0);

						selected_item.setLayoutParams(lp);
						break;
					default:
						break;
				}
				return true;
			}
		});
	}

	private void setDragDropElement(int elementToTrack)
	{
		ImageView img = (ImageView) findViewById(elementToTrack);
		img.setOnTouchListener(new View.OnTouchListener()
		{
			@Override
			public boolean onTouch(View v, MotionEvent event)
			{
				switch (event.getActionMasked())
				{
				case MotionEvent.ACTION_DOWN:
					offset_x = (int) event.getX();
					offset_y = (int) event.getY();
					selected_item = v;
					break;
				default:
					break;
				}

				return false;
			}
		});
	}
}
