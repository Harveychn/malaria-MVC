package com.malaria.ssm.module.download.mapper;

import com.malaria.ssm.module.download.pojo.SQLQuery;

import java.util.List;
import java.util.Map;

/**
 * Created by 郑晓辉 on 2016/10/14.
 */
public interface IndicatorByFieldsMapper {
//    List<Indicator> selectIndicatorByFields(List<String> displayFields) throws Exception;

    List<String> selectBelongTables() throws Exception;

    List<Map<String,Object>> selectData(SQLQuery sqlQuery)throws Exception;
}
