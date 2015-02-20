package com.demo.androidsamples1.bean;


public class CircleDataBean 
{
	public final static int START_ID = 576;
	public final static int START_X_POS = 20;
	public static final int START_Y_POS = 50;
	
	private int id;
	private int xPos = 20;
	private int yPos = 50;
	
	
	public int getXPos()
	{
		
		return xPos;
		
	}

	public int getYPos() {
		return yPos;
	}


	public int getId()
	{
		return id;
	}

	public void setId(int curId)
	{
		this.id = curId;
	}

	public int getxPos()
	{
		return xPos;
	}

	public void setXPos(int xPos)
	{
		this.xPos = xPos;
	}
	
	public void setYPos(int yPos){
		this.yPos = yPos;
	}
	
	
	
}
