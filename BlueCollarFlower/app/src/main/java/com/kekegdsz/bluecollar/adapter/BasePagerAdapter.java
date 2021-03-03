package com.kekegdsz.bluecollar.adapter;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


import com.kekegdsz.bluecollar.base.BaseFragment;

import java.util.List;

/**
 * author：keke
 * createTime：2019/4/22 0022 17:59
 * desc： 跨声MainPagerAdapter
 */
public class BasePagerAdapter extends FragmentPagerAdapter {
    private List<BaseFragment> fragmentList;
    private List<String> titles;

    public BasePagerAdapter(FragmentManager fm, List<BaseFragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    public BasePagerAdapter(FragmentManager fm, List<BaseFragment> fragmentList, List<String> title) {
        super(fm);
        this.fragmentList = fragmentList;
        this.titles = title;
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles == null ? "" : titles.get(position);
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }
}
