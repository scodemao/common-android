package com.ymr.common.net.volley;

import android.text.TextUtils;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.ymr.common.bean.ApiBase;
import com.ymr.common.Env;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ymr on 15/8/21.
 */
public class FileUploadRequest<T> extends MultiPartStringRequest {
    private static final String TAG = "FileUploadRequest";
    private Map<String, String> mHeader = new HashMap<String, String>();

    /**
     * Creates a new request with the given method.
     *
     * @param url           URL to fetch the string at
     * @param listener      Listener to receive the String response
     * @param errorListener Error listener, or null to ignore errors
     */
    public FileUploadRequest(final String url, final Response.Listener<ApiBase<T>> listener, Response.ErrorListener errorListener, final Class<T> tClass) {
        super(Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                ParseUtil.generateObject(response, url, tClass, listener);
            }
        }, errorListener);
    }


    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        if (Env.sHeaders != null && !Env.sHeaders.isEmpty()) {
            mHeader.putAll(Env.sHeaders);
        }
        return mHeader;
    }

    public void setCookies(String cookies) {
        if (!TextUtils.isEmpty(cookies)) {
            mHeader.put("Cookie", cookies);
        }
    }

    public void setHeaders(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            mHeader.putAll(map);
        }
    }
}
