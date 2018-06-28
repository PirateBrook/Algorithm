package com.piratebrook.algorithm;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;

import com.nightonke.wowoviewpager.WoWoViewPager;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private ClipViewPager mViewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mViewpager = findViewById(R.id.viewpager);
        setUpViewPager(mViewpager);
    }

    private void setUpViewPager(ClipViewPager viewpager) {
        final List<Integer> resIds = Arrays.asList(R.layout.handpick_item,
                R.layout.handpick_item, R.layout.handpick_item);
        ClipViewAdapter clipViewAdapter = new ClipViewAdapter(resIds, R.layout.handpick_item);
        viewpager.setAdapter(clipViewAdapter);
        ViewGroup parent = (ViewGroup) viewpager.getParent();
        if (parent != null) {
            parent.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    return mViewpager.dispatchTouchEvent(event);
                }
            });
        }
        mViewpager.setCurrentItem(1);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search_view, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchAll = (SearchView) MenuItemCompat.getActionView(searchItem);
        initSearchView(searchAll);
        return super.onCreateOptionsMenu(menu);
    }

    private void initSearchView(final SearchView searchView) {
        searchView.onActionViewExpanded();
        searchView.setIconified(true);

        searchView.setIconifiedByDefault(true);

        searchView.setSubmitButtonEnabled(true);
        searchView.setQueryHint("输入算法名查找");
        final SearchView.SearchAutoComplete searchAutoComplete
                = searchView.findViewById(R.id.search_src_text);
        searchAutoComplete.setHintTextColor(getResources().getColor(android.R.color.white));
        searchAutoComplete.setTextColor(getResources().getColor(android.R.color.white));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (searchAutoComplete.isShown()) {
                    searchAutoComplete.setText("");
                    try {
                        Method method = searchView.getClass().getDeclaredMethod("onCloseClicked");
                        method.setAccessible(true);
                        method.invoke(searchView);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    finish();
                }
            }
        });
    }


}
