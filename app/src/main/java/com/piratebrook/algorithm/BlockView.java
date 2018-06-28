package com.piratebrook.algorithm;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @Author Pirate Brook
 * @Data 2018/6/28
 */
public class BlockView extends View implements IBlockView {


    public BlockView(Context context) {
        super(context);
    }

    public BlockView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BlockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        
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
