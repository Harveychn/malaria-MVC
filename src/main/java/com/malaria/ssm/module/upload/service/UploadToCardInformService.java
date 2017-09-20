package com.malaria.ssm.module.upload.service;

import com.malaria.ssm.module.upload.pojo.Data2DBInfo;

/**
 * Created by 郑晓辉 on 2017/1/21.
 */
public interface UploadToCardInformService {
    Data2DBInfo saveDataToDB(String filePath) throws Exception;
}
