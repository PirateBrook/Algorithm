package com.piratebrook.algorithm;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * @Author Pirate Brook
 * @Data 2018/6/28
 */
public class ClipViewAdapter extends PagerAdapter {

    /**
     * startUpdate()  Viewpager显示的页面数据有所改变的回调
     * finishUpdate() 页面数据改变的处理结束后的回调方法
     * instantiateItem() 初始化一个item数据的时候的回调
     * destroyItem() 销毁一个item数据的时候会回调
     * setPrimaryItem()设置好当前显示item后的回调
     * isViewFromObject()  View 是否和 Object有关联关系
     * getItemPosition() 获取当前数据对应的位置
     * getPageTitle() 获取当前页面对应的标题
     * getCount() 获取总的item数量
     * getPageWidth() 获取item页面相对于ViewPager宽度
     */

    private final List<Integer> mResId;

    @LayoutRes
    private final Integer mDefaultView;

    public ClipViewAdapter(List<Integer> resIds, @LayoutRes Integer defaultView) {
        mResId = resIds;
        mDefaultView = defaultView;
    }

    @Override
    public int getCount() {
        return mResId.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        if (inflater != null) {
            view = inflater.inflate(mResId.get(position), null);
        } else {
            view = inflater.inflate(mDefaultView, null);
        }
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return super.getItemPosition(object);
    }
}
