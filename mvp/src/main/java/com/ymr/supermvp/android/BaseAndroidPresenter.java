package com.ymr.supermvp.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ymr.supermvp.common.BasePresenter;

/**
 * Created by ymr on 16/3/26.
 */
public abstract class BaseAndroidPresenter<V extends IAndroidView> extends BasePresenter<V> implements IAndroidPresenter<V> {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {
        detachView(true);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    protected void onAttachView() {

    }

    @Override
    protected void onDetachView() {

    }
}
