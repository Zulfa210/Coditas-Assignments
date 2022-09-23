package com.dao;

import com.bean.Employee;

/**
 * @author Zulfa Attar
 */
public interface DaoOperations {
    public void createTable();
    public int insertEmployee(Employee employee);

    public int updateEmployee();
    public int deleteEmployee(int employeeId, int addressId);
    public void showAllEmployee();
    public void showOneEmployee(int employeeId);

    public void sortByLastName();

    public void sortByFirstName();

    public void showSalaryAndMumbai();

}
