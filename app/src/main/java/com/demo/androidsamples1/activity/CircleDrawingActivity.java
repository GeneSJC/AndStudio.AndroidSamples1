package com.demo.androidsamples1.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.demo.androidsamples1.bean.CircleDataBean;
import com.demo.androidsamples1.util.CircleDataUtil;
import com.demo.androidsamples1.util.DragAndDropListenerLogic;


public class CircleDrawingActivity extends Activity
{
	DragAndDropListenerLogic dragAndDropListener;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.circle_drawing);

		setAddButtonLogic();
		
		dragAndDropListener = new DragAndDropListenerLogic(this);
	}

	public void setAddButtonLogic()
	{
		Button circleAdd = (Button) findViewById(R.id.add_circle_button);
		circleAdd.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				addCircle();
			}
		});		
	}

	public void addCircle()
	{
		CircleDataBean circleData = new CircleDataBean();

		int freshCircleId = CircleDataUtil.getNextId();
		int curXPos = CircleDataUtil.getNextXPosition();
		int curYPos = CircleDataUtil.getNextYPosition();
		
		circleData.setId(freshCircleId);
		circleData.setXPos(curXPos);
		circleData.setYPos(curYPos);

		createCircle(circleData);

		Log.d("MSG1", "Added Circle with ID: " + circleData.getId());

		// Currently, this method call crashes the app
		// dragAndDropListener.setDragDrop(R.id.circle_layout, freshCircleId,
		// this);
	}

	private void createCircle(CircleDataBean circleData)
	{
		RelativeLayout circleLayout = (RelativeLayout) findViewById(R.id.circle_layout);

		TextView addedCircleView = new TextView(getApplicationContext());
		addedCircleView.setBackgroundResource(R.drawable.circle1);

		addedCircleView.setX(circleData.getXPos());
		addedCircleView.setY(circleData.getYPos());

		addedCircleView.setText("" + CircleDataUtil.idCounter);
		addedCircleView.setGravity(Gravity.CENTER);
		addedCircleView.setTextSize(20);
		circleLayout.addView(addedCircleView);

		Log.d("MSG1", "Created Circle with ID: " + circleData.getId());

	}


}	

