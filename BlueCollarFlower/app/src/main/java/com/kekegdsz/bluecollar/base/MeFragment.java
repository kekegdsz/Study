package com.kekegdsz.bluecollar.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.kekegdsz.bluecollar.R;
import com.kekegdsz.bluecollar.databinding.FragmentMeBinding;
import com.kekegdsz.bluecollar.widget.CommonListItemView;

public class MeFragment extends BaseFragment<FragmentMeBinding> {

    @Override
    protected void initialize() {
        initViews();
    }

    @Override
    protected int setView() {
        return R.layout.fragment_me;
    }


    private void initViews() {
        CommonListItemView itemPrivacy = mView.findViewById(R.id.item_key_privacy);
        CommonListItemView itemQuestion = mView.findViewById(R.id.item_key_question);
        itemPrivacy.setKeyValue("隐私协议", null, true, false);
        itemQuestion.setKeyValue("常见问题", null, true, false);
    }
}