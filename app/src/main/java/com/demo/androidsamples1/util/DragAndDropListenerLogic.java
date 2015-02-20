package com.demo.androidsamples1.util;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

// import com.contactcircles.bean.ContactBean;

public class DragAndDropListenerLogic
{
	public View selected_item = null;
	public int offset_x = 0;
	public int offset_y = 0;

	public Activity activity;
	
	
	public DragAndDropListenerLogic(Activity activity)
	{
		super();
		this.activity = activity;
	}

	public void setDragDrop(int viewGroup, int elementToTrack)
	{
		setDragDropViewGroup(viewGroup);

		setDragDropElement(elementToTrack);
	}

	private void setDragDropViewGroup (int viewGroup)
	{
		ViewGroup vg = (ViewGroup) activity.findViewById(viewGroup);
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

						int w = activity.getWindowManager().getDefaultDisplay().getWidth() - 100;
						int h = activity.getWindowManager().getDefaultDisplay().getHeight() - 100;
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
		ImageView img = (ImageView) activity.findViewById(elementToTrack);
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
