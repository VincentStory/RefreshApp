package com.vincent.refreshapp;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.scwang.smart.refresh.layout.api.RefreshHeader;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import com.scwang.smart.refresh.layout.simple.SimpleComponent;
import com.scwang.smart.refresh.layout.util.SmartUtil;

/**
 * @author : wangwenbo
 * @date : 2022/9/21
 * Desc :
 */
public class CustomHeader extends SimpleComponent implements RefreshHeader {


    private AnimationDrawable animationDrawable;
    private ImageView mProgressView;//刷新动画视图

    public CustomHeader(@NonNull Context wrapped) {
        this(wrapped, null);
    }

    public CustomHeader(@NonNull Context context, AttributeSet attrs) {
        super(context, attrs, 0);
        setGravity(Gravity.CENTER);
        mProgressView = new ImageView(context);
        mProgressView.setImageResource(R.drawable.fly_drw);
        animationDrawable = (AnimationDrawable) mProgressView.getDrawable();

        addView(mProgressView, SmartUtil.dp2px(50), SmartUtil.dp2px(50));
        setMinimumHeight(SmartUtil.dp2px(80));
    }

    @NonNull
    @Override
    public View getView() {
        return this;
    }

    @Override
    public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState oldState, @NonNull RefreshState newState) {
        super.onStateChanged(refreshLayout, oldState, newState);

    }


    @Override
    public void onStartAnimator(@NonNull RefreshLayout refreshLayout, int height, int maxDragHeight) {
        super.onStartAnimator(refreshLayout, height, maxDragHeight);
        if (animationDrawable != null)
            animationDrawable.start();
    }

    @Override
    public int onFinish(@NonNull RefreshLayout refreshLayout, boolean success) {
        if (animationDrawable != null)
            animationDrawable.stop();

        return 0;
    }
}
