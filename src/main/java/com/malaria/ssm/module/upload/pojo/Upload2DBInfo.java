package com.malaria.ssm.module.upload.pojo;

/**
 * Created by 郑晓辉 on 2017/1/24.
 */
public class Upload2DBInfo {
    private boolean isNeedUpdate;
    private boolean isNeedInsert;
    private boolean isSuccessOp;

    public boolean isNeedUpdate() {
        return isNeedUpdate;
    }

    public void setNeedUpdate(boolean needUpdate) {
        isNeedUpdate = needUpdate;
    }

    public boolean isNeedInsert() {
        return isNeedInsert;
    }

    public void setNeedInsert(boolean needInsert) {
        isNeedInsert = needInsert;
    }

    public boolean isSuccessOp() {
        return isSuccessOp;
    }

    public void setSuccessOp(boolean successOp) {
        isSuccessOp = successOp;
    }
}
