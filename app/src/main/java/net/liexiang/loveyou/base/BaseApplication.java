package net.liexiang.loveyou.base;


import androidx.multidex.MultiDexApplication;

/**
 * Describe:
 * Created by Gao Chunfa on 4/9/21.
 * Company: Hainan DaDi(Jinan) Network Technology Co. Ltd
 */
public class BaseApplication extends MultiDexApplication {

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        StatusHolder.getInstance().setKill(true);
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
//        if (level == TRIM_MEMORY_COMPLETE) {
//            StatusHolder.getInstance().setKill(true);
//        }
    }
}
