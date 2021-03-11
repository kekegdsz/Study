package com.kekegdsz.bluecollar.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.kekegdsz.bluecollar.R;
import com.kekegdsz.bluecollar.adapter.BasePagerAdapter;
import com.kekegdsz.bluecollar.base.BaseFragment;
import com.kekegdsz.bluecollar.base.HomeFragment;
import com.kekegdsz.bluecollar.base.MeFragment;
import com.kekegdsz.bluecollar.base.MoneyFragment;
import com.kekegdsz.bluecollar.widget.tablayout.TabItem;
import com.kekegdsz.bluecollar.widget.tablayout.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * @author keke
 * 主界面显示
 * 1、介绍工作
 * 2、如何省钱
 * 3、个人中心
 */
public class MainActivity extends AppCompatActivity implements TabLayout.OnTabClickListener {

    private int[] mTitleTexts = new int[]{R.string.tab_home_page, R.string.tab_money_page, R.string.tab_me_page};
    private List<BaseFragment> mFragmentList = new ArrayList<>();
    private BasePagerAdapter mMainPagerAdapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        initFragment();
    }

    private void findViews() {
        tabLayout = findViewById(R.id.mTabLayout);
        viewPager = findViewById(R.id.viewpager);
    }

    private void initFragment() {
        List<TabItem> items = new ArrayList<>();
        items.add(new TabItem(0, 0, mTitleTexts[0]));
        items.add(new TabItem(0, 0, mTitleTexts[1]));
        items.add(new TabItem(0, 0, mTitleTexts[2]));
        mFragmentList.add(new HomeFragment());
        mFragmentList.add(new MoneyFragment());
        mFragmentList.add(new MeFragment());
        tabLayout.initData(items, this);
        mMainPagerAdapter = new BasePagerAdapter(getSupportFragmentManager(), mFragmentList);
        viewPager.setAdapter(mMainPagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tabLayout.setCurrentTabView(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onTabClick(TabItem clickedItem) {
        int clickedTabIndex = clickedItem.index;
        viewPager.setCurrentItem(clickedTabIndex, false);
    }
}
