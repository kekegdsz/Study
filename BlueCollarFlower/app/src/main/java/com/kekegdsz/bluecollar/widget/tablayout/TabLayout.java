package com.kekegdsz.bluecollar.widget.tablayout;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


import com.kekegdsz.bluecollar.R;

import java.util.ArrayList;
import java.util.List;


/**
 * author：keke
 * createTime：2019/4/22 0022 18:24
 * desc： tabyout
 */
public class TabLayout extends LinearLayout implements View.OnClickListener, View.OnDragListener {

    private List<TabItem> tabs;
    private List<View> tabViews = new ArrayList<>();
    private OnTabClickListener listener;
    private TabView mCurrentTabView;
    private int DEFAULT_INDEX = 0;
    private int mCurrentIndex = 0;

    public TabLayout(Context context) {
        super(context);
        initView();
    }

    public TabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public TabLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
    }

    private void initView() {
        setOrientation(HORIZONTAL);
        setBackgroundColor(getResources().getColor(R.color.tab_view_bg_color));
    }

    public void initData(List<TabItem> tabs, OnTabClickListener listener) {
        this.tabs = tabs;
        this.listener = listener;
        LayoutParams params = new LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
        params.weight = 1;
        if (tabs != null && tabs.size() > 0) {
            TabView mTabView = null;
            for (int i = 0; i < tabs.size(); i++) {
                TabItem tabItem = tabs.get(i);
                tabItem.setIndex(i);
                mTabView = new TabView(getContext());
                mTabView.setTag(tabItem);
                mTabView.initData(tabItem);
                mTabView.setOnClickListener(this);
                addView(mTabView, params);
                tabViews.add(mTabView);
            }
            //获取第一个item
            mCurrentTabView = (TabView) getChildAt(DEFAULT_INDEX);
            mCurrentTabView.setSelectedTabView(true);
        } else {
            throw new IllegalArgumentException("tabs can not be empty");
        }
    }

    public int getDefaultIndex() {
        return DEFAULT_INDEX;
    }

    public void setDefaultIndex(int defaultIndex) {
        this.DEFAULT_INDEX = defaultIndex;
    }

    @Override
    public void onClick(View v) {
        TabItem tabItem = (TabItem) v.getTag();
        listener.onTabClick(tabItem);
        mCurrentIndex = tabItem.getIndex();
        setCurrentTabView(mCurrentIndex);
    }

    public void setCurrentTabView(int index) {
        mCurrentIndex = index;
        this.mCurrentTabView.setSelectedTabView(false);
        this.mCurrentTabView = (TabView) getChildAt(index);
        this.mCurrentTabView.setSelectedTabView(true);
    }


    @Override
    public boolean onDrag(View v, DragEvent event) {
        Log.i("GOOD_DA", "-------onDrag-------->");
        return false;
    }

    public int getCurrentItem() {
        return mCurrentIndex;
    }

    public interface OnTabClickListener {
        void onTabClick(TabItem tabItem);
    }

}