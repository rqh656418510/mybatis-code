package com.clay.mybatis.dao;

import com.clay.mybatis.bean.Department;
import java.util.List;

public interface DepartmentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_department
     *
     * @mbg.generated Sun Aug 28 19:09:43 CST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_department
     *
     * @mbg.generated Sun Aug 28 19:09:43 CST 2022
     */
    int insert(Department row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_department
     *
     * @mbg.generated Sun Aug 28 19:09:43 CST 2022
     */
    Department selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_department
     *
     * @mbg.generated Sun Aug 28 19:09:43 CST 2022
     */
    List<Department> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_department
     *
     * @mbg.generated Sun Aug 28 19:09:43 CST 2022
     */
    int updateByPrimaryKey(Department row);
}