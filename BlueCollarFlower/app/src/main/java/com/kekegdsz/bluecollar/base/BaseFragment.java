package com.kekegdsz.bluecollar.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

/**
 * @author keke
 * 所有fragment的子类，用于
 */
public abstract class BaseFragment<V extends ViewDataBinding> extends Fragment {
    public V mBinding;
    public View mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mView == null) {
            mBinding = DataBindingUtil.inflate(inflater, setView(), container, false);
            mView = mBinding.getRoot();
            initialize();
        } else {
            ViewGroup parent = (ViewGroup) mView.getParent();
            if (parent != null) {
                parent.removeView(mView);
            }
        }
        initialize();
        return mView;
    }

    protected abstract void initialize();

    /**
     * 用于子类继承使用，必须实现使用
     *
     * @return 布局资源返回
     */
    protected abstract int setView();

}