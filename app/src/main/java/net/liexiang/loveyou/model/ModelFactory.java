package net.liexiang.loveyou.model;

/**
 * @Author sbqfile
 * @Date 2020-01-30 10:22
 * @Description
 **/
public class ModelFactory {

    public static <T> T getModel(Class<T> mCls, MVVMModel mvvmModel) {
        try {
            return mCls.getConstructor(MVVMModel.class).newInstance(mvvmModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
