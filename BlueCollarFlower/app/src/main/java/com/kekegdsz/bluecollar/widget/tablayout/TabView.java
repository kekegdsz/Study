package com.kekegdsz.bluecollar.widget.tablayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.kekegdsz.bluecollar.R;


/**
 * author：keke
 * createTime：2019/4/22 0022 17:59
 * desc： 跨声tavView
 */
public class TabView extends LinearLayout {

    private ImageView mTabImage;
    private TextView mTabName;
    private TabItem mTabItem;


    public TabView(Context context) {
        this(context, null);
    }

    public TabView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TabView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }


    private void initView(Context context) {
        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER);
        View view = LayoutInflater.from(context).inflate(R.layout.tab_view, this, true);
        mTabImage = view.findViewById(R.id.tab_image);
        mTabName = view.findViewById(R.id.tab_name);

    }

    public void initData(TabItem tabItem) {
        this.mTabItem = tabItem;
        mTabImage.setImageResource(tabItem.imageResId);
        mTabName.setText(tabItem.nameResId);
    }


    public void setSelectedTabView(boolean b) {
        mTabImage.setImageResource(b ? mTabItem.selectImageResId : mTabItem.imageResId);
        mTabName.setTextColor(getContext().getResources().getColor(b ? R.color.tab_select : R.color.tab_normal));
    }
}
