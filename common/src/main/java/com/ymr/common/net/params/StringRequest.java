package com.ymr.common.net.params;

import java.util.Map;

/**
 * Created by ymr on 15/7/8.
 */
public abstract class StringRequest extends SimpleNetParams {
    public StringRequest(String tailUrl) {
        super(tailUrl);
    }

    @Override
    protected Map<String, String> getChildGETParams() {
        return null;
    }
}
