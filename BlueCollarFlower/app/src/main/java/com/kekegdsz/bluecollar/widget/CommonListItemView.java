package com.kekegdsz.bluecollar.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.kekegdsz.bluecollar.R;
import com.kekegdsz.bluecollar.utils.DensityUtil;

public class CommonListItemView extends FrameLayout {

    private TextView mTvKey;
    private TextView mTvValue;
    private ImageView mIvNext;
    private View mFullLine;
    private View mMarginLine;
    private ImageView mIvHead;
    private ImageView mIvLeft;

    public CommonListItemView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public CommonListItemView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CommonListItemView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_key_value_edit, this);
        mTvKey = view.findViewById(R.id.item_title);
        mTvValue = view.findViewById(R.id.item_desc);
        mIvNext = view.findViewById(R.id.iv_edit);
        mMarginLine = view.findViewById(R.id.margin_line);
        mFullLine = view.findViewById(R.id.full_line);
        mIvHead = view.findViewById(R.id.iv_head);
        mIvLeft = view.findViewById(R.id.iv_left);
    }

    public ImageView setKeyValueForImageView(String key) {
        mTvKey.setText(key);
        mTvValue.setVisibility(GONE);
        mIvHead.setVisibility(VISIBLE);
        return mIvHead;
    }

    public void setKeyValue(String key, String value) {
        mTvKey.setText(key == null ? "" : key);
        mTvValue.setText(value == null ? "" : value);
    }

    public void setKeyValueAndLeftImage(int res, String key, String value) {
        mIvLeft.setVisibility(VISIBLE);
        mIvLeft.setImageResource(res);
        setKeyValue(key, value);
    }

    public void setKeyValueAndLeftImage(int res, String key, String value, int size) {
        mIvLeft.setVisibility(VISIBLE);
        mIvLeft.setImageResource(res);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mIvLeft.getLayoutParams();
        layoutParams.width = DensityUtil.dp2px(size);
        layoutParams.height = DensityUtil.dp2px(size);
        mIvLeft.setLayoutParams(layoutParams);
        setKeyValue(key, value);
    }

    public void setKeyValue(String key, String value, boolean showNext) {
        setKeyValue(key, value);
        mIvNext.setVisibility(showNext ? VISIBLE : GONE);
        if (!showNext) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mTvValue.getLayoutParams();
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            layoutParams.rightMargin = DensityUtil.dp2px(16);
            mTvValue.setLayoutParams(layoutParams);
        }
    }

    public void setKeyValue(String key, String value, boolean showNext, boolean showFull) {
        setKeyValue(key, value, showNext);
        mFullLine.setVisibility(showFull ? VISIBLE : GONE);
        mMarginLine.setVisibility(!showFull ? VISIBLE : GONE);
    }

}
