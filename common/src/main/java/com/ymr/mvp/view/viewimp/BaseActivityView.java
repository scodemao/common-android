package com.ymr.mvp.view.viewimp;

import android.app.Activity;
import android.content.Intent;

import com.ymr.common.BaseApplication;
import com.ymr.common.ui.activity.BaseActivity;
import com.ymr.mvp.view.IView;

/**
 * Created by ymr on 15/9/16.
 */
public abstract class BaseActivityView extends BaseActivity implements IView {

    private BaseView mView;

    @Override
    public void onFinishCreateView() {
        mView = new BaseView(this) {
            @Override
            public void onError(String msg) {
                BaseActivityView.this.onError(msg);
            }

            @Override
            public void onMessage(String msg) {
                BaseActivityView.this.onMessage(msg);
            }
        };
    }

    @Override
    public boolean isCurrView() {
        return mView.isCurrView();
    }

    @Override
    public boolean exist() {
        return mView.exist();
    }

    @Override
    public Activity getActivity() {
        return mView.getActivity();
    }

    @Override
    public void gotoActivity(Intent intent) {
        mView.gotoActivity(intent);
    }
}
