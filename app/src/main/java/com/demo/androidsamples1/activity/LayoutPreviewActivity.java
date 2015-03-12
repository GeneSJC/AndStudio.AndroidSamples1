package com.demo.androidsamples1.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * REFACTOR:
 * So that drag n drop is external to this class
 * 
 * Then can make DnD2 which extends this and then associates the DnD logic
 * 
 */
public class LayoutPreviewActivity extends Activity
{

    List<Integer> layoutIds = new ArrayList<Integer>();
    Map<Integer, String> layoutNameMap = new HashMap<Integer, String>();

    int curIdx = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        loadLayoutIds();

        showNext();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        if (event.getAction() == MotionEvent.ACTION_DOWN)
            showNext();

        return true;
    }

    private void showNext()
    {
        if (curIdx >= layoutIds.size())
            curIdx = 0;

        int layoutId = (int) layoutIds.get(curIdx);

        setContentView(layoutId);

        String msg = layoutNameMap.get(layoutId);

        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();

        curIdx++;
    }

    private void loadLayoutIds()
    {
        try
        {
            Class<?> c = R.layout.class;
            Field[] fields = c.getDeclaredFields();

            for (Field field : fields)
            {
                Class<?> t = field.getType();
                if(t == int.class)
                {
                    int layoutId = field.getInt(null);
                    String name = field.getName();

                    if ( ! name.startsWith("activity_"))
                        continue;

                    Log.d("tag", "cur field = " + name + ", cur layoutId = " + layoutId);
                    layoutIds.add(layoutId);
                    layoutNameMap.put(layoutId, name);
                }
            }
        }
        catch (Exception e)
        {}
    }



}
