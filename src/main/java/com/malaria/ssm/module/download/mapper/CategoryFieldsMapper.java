package com.malaria.ssm.module.download.mapper;

import com.malaria.ssm.module.download.pojo.CategoryFieldsRe;

import java.util.List;

/**
 * Created by 郑晓辉 on 2016/10/13.
 */
public interface CategoryFieldsMapper {
    List<CategoryFieldsRe> selectCategoryFields(String Disease) throws  Exception;
}
