package cn.epimore.gmv.api.model;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "SingleParamModel")
public class SingleParamModel<T> {
    private T param;

    public T getParam() {
        return param;
    }

    public void setParam(T param) {
        this.param = param;
    }
}
