package com.piratebrook.algorithm;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.nightonke.wowoviewpager.WoWoViewPager;

/**
 * @Author Pirate Brook
 * @Data 2018/6/28
 */
public class ClipViewPager extends WoWoViewPager {


    public ClipViewPager(Context context) {
        super(context);
    }

    public ClipViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        setPageMargin(8);
        setOffscreenPageLimit(6);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
//        if (ev.getAction() == MotionEvent.ACTION_UP) {
//            View view = viewOfClickOnScreen(ev);
//            if (view != null) {
//                final int position = indexOfChild(view);
//                final int currentItem = getCurrentItem();
//                if (currentItem != position) {
//                    setCurrentItem(indexOfChild(view), true);
//                }
//            }
//        }
        return super.dispatchTouchEvent(ev);
    }

    private View viewOfClickOnScreen(MotionEvent ev) {
        int childCount = getChildCount();
        int[] location = new int[2];

        for (int i = 0; i < childCount; i++) {
            View v = getChildAt(i);
            v.getLocationOnScreen(location);
            // View最左侧坐标
            int minX = location[0];
            int minY = getTop();
            int maxX = location[0] + v.getWidth();
            int maxY = getBottom();

            float x = ev.getX();
            float y = ev.getY();
            if ((x > minX && x < maxX) && (y > minY && y < maxY)) {
                return v;
            }
        }
        return null;
    }

}
