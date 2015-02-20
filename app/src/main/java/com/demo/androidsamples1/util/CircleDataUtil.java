package com.demo.androidsamples1.util;

import com.demo.androidsamples1.bean.CircleDataBean;

public class CircleDataUtil
{
	static public int idCounter = CircleDataBean.START_ID;
	static public int xPosCounter = CircleDataBean.START_X_POS;
	static public int yPosCounter = CircleDataBean.START_Y_POS;

	public static int getNextId()
	{
		return idCounter++;
	}

	public static int getNextXPosition()
	{
		xPosCounter += 150;
		return xPosCounter;
	}

	public static int getNextYPosition()
	{
		yPosCounter += 150;
		return yPosCounter;
	}


}
