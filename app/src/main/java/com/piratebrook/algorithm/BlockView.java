package com.piratebrook.algorithm;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 * @Author Pirate Brook
 * @Data 2018/6/28
 */
public class BlockView extends View implements IBlockView {

    private Paint mTextPaint;
    private Paint mPolygonPaint;

    private int mTextColor;
    private int textSize = 14;
    private int mPolygonColor;
    private final Paint.FontMetricsInt mTextFontMetricsInt;
    private String mMessage;

    private RectF rectangle;
    public BlockView(Context context) {
        this(context, null);
    }

    public BlockView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BlockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray array =
                context.obtainStyledAttributes(attrs, R.styleable.BlockView, defStyleAttr, 0);
        mMessage = "";
        mMessage = array.getString(R.styleable.BlockView_view_text);

        array.recycle();

        mTextColor = Color.BLACK;
        mPolygonColor = Color.GREEN;

        mTextPaint = new TextPaint();
        mTextPaint.setColor(mTextColor);
        mTextPaint.setAntiAlias(true);
        mTextPaint.setStrokeWidth(12);
        mTextPaint.setStyle(Paint.Style.FILL);
        textSize = context.getResources().getDimensionPixelSize(R.dimen.default_text_size);
        mTextPaint.setTextSize(textSize);
        mTextFontMetricsInt = mTextPaint.getFontMetricsInt();

        mPolygonPaint = new Paint();
        mPolygonPaint.setAntiAlias(true);
        mPolygonPaint.setColor(mPolygonColor);
        mPolygonPaint.setStrokeWidth(2);
        mPolygonPaint.setStyle(Paint.Style.FILL);

        rectangle = new RectF();
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

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float textX = getTextStartX(mMessage);
        float textY = getTextStartY();

        canvas.drawText(mMessage, textX, textY, mTextPaint);

    }

    private float getTextStartX(String text) {
        float textWidth = mTextPaint.measureText(text);
        return getLeft() + (getRight() - getLeft()) / 2 - textWidth / 2;
    }

    private float getTextStartY() {
        float height = getBottom() - getTop();
        return height / 2 - mTextFontMetricsInt.descent + (mTextFontMetricsInt.bottom - mTextFontMetricsInt.top) / 2;
    }
}
