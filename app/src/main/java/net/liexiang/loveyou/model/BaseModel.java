package net.liexiang.loveyou.model;

/**
 * @Author sbqfile
 * @Date 2020-01-29 19:43
 * @Description 所有Model继承此类
 **/
public class BaseModel implements IModel {
    private MVVMModel mvvmModel;

    public MVVMModel getMVVMModel() {
        return mvvmModel;
    }

    public BaseModel(MVVMModel mvvmModel) {
        this.mvvmModel = mvvmModel;
    }

    @Override
    public void onRelease() {
        mvvmModel = null;
    }
}
