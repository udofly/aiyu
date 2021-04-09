package net.liexiang.loveyou.base;

/**
 * Describe: 应用状态
 * Created by Gao Chunfa on 4/9/21.
 * Company: Hainan DaDi(Jinan) Network Technology Co. Ltd
 */
public class StatusHolder {
    private static StatusHolder mInstance;
    private boolean isKill = true;

    public boolean isKill() {
        return isKill;
    }

    public void setKill(boolean kill) {
        isKill = kill;
    }

    private StatusHolder() {

    }

    public static StatusHolder getInstance() {
        if (mInstance == null) {
            synchronized (StatusHolder.class) {
                if (mInstance == null) {
                    mInstance = new StatusHolder();
                }
            }
        }
        return mInstance;
    }
}
