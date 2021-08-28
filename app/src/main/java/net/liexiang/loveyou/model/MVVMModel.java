package net.liexiang.loveyou.model;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author sbqfile
 * @Date 2020-01-30 14:40
 * @Description
 **/
public interface MVVMModel {

    /**
     * 获取所需ViewModel
     *
     * @param modelCls
     * @param <T>
     * @return
     */
    <T extends IModel> T getModel(Class<T> modelCls);

    /**
     * Model返回数据
     *
     */
    void onResponse(int requestCode, JSONObject  object);
}
