package com.piratebrook.algorithm;

import android.content.Context;
import android.graphics.Canvas;
import android.support.design.widget.CollapsingToolbarLayout;
import android.util.AttributeSet;

/**
 * @Author Pirate Brook
 * @Data 2018/6/29
 */
public class ArrayView extends CollapsingToolbarLayout implements IBlockView {

    public ArrayView(Context context) {
        super(context);
    }

    public ArrayView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ArrayView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }

    @Override
    public void startAnimation() {

    }

    @Override
    public void pauseAnimation() {

    }

    @Override
    public void resumeAnimation() {

    }

    @Override
    public void stopAnimation() {

    }

    @Override
    public void toProgress(float progress) {

    }
}
