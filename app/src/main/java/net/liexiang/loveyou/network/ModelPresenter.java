package net.liexiang.loveyou.network;

import java.util.Map;

import io.reactivex.Observable;

public interface ModelPresenter {
    /**     * 下载box数据接口     */
    Observable<String> getSystem(Map<String,Object> map);

}