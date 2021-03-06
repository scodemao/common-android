package com.ymr.mvp.view.viewimp;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.ymr.common.ui.BaseUI;
import com.ymr.mvp.view.IView;

/**
 * Created by ymr on 15/9/16.
 */
abstract class ActivityViewDelegate<T extends Activity & BaseUI & IView> implements IView {

    private final T mView;

    public ActivityViewDelegate(T iView) {
        mView = iView;
    }

    @Override
    public boolean isCurrView() {
        return mView.isResume();
    }

    @Override
    public boolean exist() {
        return !mView.isFinishing();
    }

    @Override
    public Activity getActivity() {
        return mView;
    }

    @Override
    public void gotoActivity(Intent intent) {
        mView.startActivity(intent);
    }

    @Override
    public View getRootView() {
        return mView.getRootView();
    }
}
