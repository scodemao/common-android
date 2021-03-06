package com.ymr.common.net;

import android.content.Context;

import com.tencent.bugly.crashreport.CrashReport;
import com.ymr.common.Env;
import com.ymr.common.SimpleModel;
import com.ymr.common.net.params.NetRequestParams;
import com.ymr.common.util.DeviceInfoUtils;

/**
 * Created by ymr on 15/6/12.
 */
public class SimpleNetWorkModel<T> extends SimpleModel implements NetWorkModel<T> {

    private final Context mContext;
    private final Class<T> mTClass;
    private NetRequestParams mParams;
    private UpdateListener<T> mListener;

    public SimpleNetWorkModel(Context context, Class<T> tClass) {
        mContext = context;
        mTClass = tClass;
    }

    @Override
    public void updateDatas(NetRequestParams params, final UpdateListener<T> listener) {
        updateDatas(params, listener,false);
    }

    @Override
    public void updateDatas(NetRequestParams params, final UpdateListener<T> listener, boolean forceFromServer) {
        mParams = params;
        mListener = listener;
        if (DeviceInfoUtils.hasInternet(mContext)) {
            if (listener == null) {
                throw new RuntimeException("回调不可为空");
            }
            NetResultDisposer.dispose(mContext, params, new UpdateListener<T>() {
                @Override
                public void finishUpdate(T result) {
                    listener.finishUpdate(result);
                }

                @Override
                public void onError(Error error) {
                    Env.sFloorErrorDisposer.onError(error);
                    listener.onError(error);
                    CrashReport.postCatchedException(new Throwable("服务器错误：" + error));
                }
            }, mTClass, params.getHeaders(), params.getCookies(),forceFromServer);
        } else {
            Error error = new Error();
            error.setErrorCode(10000);
            error.setMsg("无网络");
            error.setNetRequestParams(params);
            listener.onError(error);
        }
    }

    @Override
    public void cancel() {
        NetResultDisposer.cancel(mParams,mListener);
    }

    public Context getContext() {
        return mContext;
    }
}