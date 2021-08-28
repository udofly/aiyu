package net.liexiang.loveyou.network;

import java.util.Map;

import io.reactivex.Observable;

public class ModelPresenterImpl extends HttpConfig implements ModelPresenter {

    @Override
    public Observable<String> getSystem(Map<String, Object> map) {
        return LxRequest.get().getServiceDetail().getSystemInfo2(map);
    }



}