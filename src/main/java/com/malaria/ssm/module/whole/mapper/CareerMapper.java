package com.malaria.ssm.module.whole.mapper;

import com.malaria.ssm.module.whole.pojo.Career;
import com.malaria.ssm.module.whole.pojo.CareerExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CareerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table career
     *
     * @mbggenerated
     */
    int countByExample(CareerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table career
     *
     * @mbggenerated
     */
    int deleteByExample(CareerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table career
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer careerid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table career
     *
     * @mbggenerated
     */
    int insert(Career record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table career
     *
     * @mbggenerated
     */
    int insertSelective(Career record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table career
     *
     * @mbggenerated
     */
    List<Career> selectByExample(CareerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table career
     *
     * @mbggenerated
     */
    Career selectByPrimaryKey(Integer careerid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table career
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Career record, @Param("example") CareerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table career
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Career record, @Param("example") CareerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table career
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Career record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table career
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Career record);
}