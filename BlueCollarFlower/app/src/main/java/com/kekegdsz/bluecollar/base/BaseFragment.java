package com.kekegdsz.bluecollar.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

/**
 * @author keke
 * 所有fragment的子类，用于
 */
public abstract class BaseFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(setView(), container, false);
    }

    /**
     * 用于子类继承使用，必须实现使用
     * @return 布局资源返回
     */
    protected abstract int setView();
}