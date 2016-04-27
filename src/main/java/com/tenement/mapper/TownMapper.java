package com.tenement.mapper;

import com.tenement.model.Town;
import com.tenement.model.TownExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TownMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table town
     *
     * @mbggenerated Wed Apr 27 15:07:33 CST 2016
     */
    int countByExample(TownExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table town
     *
     * @mbggenerated Wed Apr 27 15:07:33 CST 2016
     */
    int deleteByExample(TownExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table town
     *
     * @mbggenerated Wed Apr 27 15:07:33 CST 2016
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table town
     *
     * @mbggenerated Wed Apr 27 15:07:33 CST 2016
     */
    int insert(Town record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table town
     *
     * @mbggenerated Wed Apr 27 15:07:33 CST 2016
     */
    int insertSelective(Town record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table town
     *
     * @mbggenerated Wed Apr 27 15:07:33 CST 2016
     */
    List<Town> selectByExample(TownExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table town
     *
     * @mbggenerated Wed Apr 27 15:07:33 CST 2016
     */
    Town selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table town
     *
     * @mbggenerated Wed Apr 27 15:07:33 CST 2016
     */
    int updateByExampleSelective(@Param("record") Town record, @Param("example") TownExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table town
     *
     * @mbggenerated Wed Apr 27 15:07:33 CST 2016
     */
    int updateByExample(@Param("record") Town record, @Param("example") TownExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table town
     *
     * @mbggenerated Wed Apr 27 15:07:33 CST 2016
     */
    int updateByPrimaryKeySelective(Town record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table town
     *
     * @mbggenerated Wed Apr 27 15:07:33 CST 2016
     */
    int updateByPrimaryKey(Town record);
}