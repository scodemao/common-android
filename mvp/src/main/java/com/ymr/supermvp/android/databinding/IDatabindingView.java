package com.ymr.supermvp.android.databinding;

import android.databinding.ViewDataBinding;

import com.ymr.supermvp.android.IAndroidView;

/**
 * Created by ymr on 16/3/26.
 */
public interface IDatabindingView<P extends DatabindingPresenter> extends IAndroidView<P> {

    void finishCreateDataBinding(ViewDataBinding viewDataBinding, P presenter);

    int getContentLayout();
}
