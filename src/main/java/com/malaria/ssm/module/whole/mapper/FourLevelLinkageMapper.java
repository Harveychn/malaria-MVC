package com.malaria.ssm.module.whole.mapper;

import com.malaria.ssm.module.whole.pojo.FourLevelLinkageExample;
import com.malaria.ssm.module.whole.pojo.FourLevelLinkage;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FourLevelLinkageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table four_level_linkage
     *
     * @mbggenerated
     */
    int countByExample(FourLevelLinkageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table four_level_linkage
     *
     * @mbggenerated
     */
    int deleteByExample(FourLevelLinkageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table four_level_linkage
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table four_level_linkage
     *
     * @mbggenerated
     */
    int insert(FourLevelLinkage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table four_level_linkage
     *
     * @mbggenerated
     */
    int insertSelective(FourLevelLinkage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table four_level_linkage
     *
     * @mbggenerated
     */
    List<FourLevelLinkage> selectByExample(FourLevelLinkageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table four_level_linkage
     *
     * @mbggenerated
     */
    FourLevelLinkage selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table four_level_linkage
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") FourLevelLinkage record, @Param("example") FourLevelLinkageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table four_level_linkage
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") FourLevelLinkage record, @Param("example") FourLevelLinkageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table four_level_linkage
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(FourLevelLinkage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table four_level_linkage
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(FourLevelLinkage record);
}