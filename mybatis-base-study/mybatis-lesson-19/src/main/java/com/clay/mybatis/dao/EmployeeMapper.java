package com.clay.mybatis.dao;

import com.clay.mybatis.bean.Employee;
import java.util.List;

public interface EmployeeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_employee
     *
     * @mbg.generated Sun Aug 28 19:09:43 CST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_employee
     *
     * @mbg.generated Sun Aug 28 19:09:43 CST 2022
     */
    int insert(Employee row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_employee
     *
     * @mbg.generated Sun Aug 28 19:09:43 CST 2022
     */
    Employee selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_employee
     *
     * @mbg.generated Sun Aug 28 19:09:43 CST 2022
     */
    List<Employee> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_employee
     *
     * @mbg.generated Sun Aug 28 19:09:43 CST 2022
     */
    int updateByPrimaryKey(Employee row);
}