package com.dao;

import com.bean.Address;
import com.bean.Employee;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zulfa Attar
 */
public class DaoImplementation implements DaoOperations{
    JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createTable() {

         jdbcTemplate.execute("create table Address(id int primary key auto_increment, " +
                 "flat_no int, house_name varchar(50), city varchar(50), pincode int)");
        jdbcTemplate.execute("create table Employee(id int primary key auto_increment, fname varchar(50)," +
                " lname varchar(50), salary float, address_id int, foreign key (address_id) references Address(id))");

    }

    @Override
    public int insertEmployee(Employee employee) {
        String sql = "insert into address values(?,?,?,?,?)";
        Object[] values = {employee.getEmployeeAddress().getAddressId(), employee.getEmployeeAddress().getFlatNo(),
                employee.getEmployeeAddress().getHouseName(), employee.getEmployeeAddress().getCity(),
        employee.getEmployeeAddress().getPinCode()};

        int check  = jdbcTemplate.update(sql,values);

        check+= jdbcTemplate.update("insert into employee values (?,?,?,?,?)" ,null,employee.getEmployeeFirstName(),
        employee.getEmployeeLastName(),employee.getEmployeeSalary(), employee.getEmployeeAddress().getAddressId());


        return check;
    }

    @Override
    public int updateEmployee() {
        return jdbcTemplate.update("update employee set salary = salary+5000" );
    }

    @Override
    public int deleteEmployee(int employeeId, int addressId) {
         int check =  jdbcTemplate.update("delete from employee where id=?", employeeId);
          check +=  jdbcTemplate.update("delete from address where id=?", addressId);
          return check;
    }

    @Override
    public void showAllEmployee() {

        String sql = "select * from employee inner join address on employee.address_id = address.id";
        List<Employee> employeeList = jdbcTemplate.query(sql, new RowMapper() {
                    @Override
                    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
                       Employee employee = new Employee();
                       employee.setEmployeeId(resultSet.getInt(1));
                       employee.setEmployeeFirstName(resultSet.getString(2));
                       employee.setEmployeeLastName(resultSet.getString(3));
                       employee.setEmployeeSalary(resultSet.getFloat(4));

                        Address address = new Address();
                        address.setAddressId(resultSet.getInt(5));
                        address.setFlatNo(resultSet.getInt(7));
                        address.setHouseName(resultSet.getString(8));
                        address.setCity(resultSet.getString(9));
                        address.setPinCode(resultSet.getInt(10));

                        employee.setEmployeeAddress(address);

                        return  employee;
                    }

                });

        for (Employee employee: employeeList){
            System.out.println(employee);
        }
    }

    @Override
    public void showOneEmployee(int employeeId) {

        String sql = "select * from employee inner join address on employee.address_id = address.id where employee.id = " +employeeId;
        List<Employee> employeeList = jdbcTemplate.query(sql, new RowMapper() {
            @Override
            public Object mapRow(ResultSet resultSet, int i) throws SQLException {
                Employee employee = new Employee();
                employee.setEmployeeId(resultSet.getInt(1));
                employee.setEmployeeFirstName(resultSet.getString(2));
                employee.setEmployeeLastName(resultSet.getString(3));
                employee.setEmployeeSalary(resultSet.getFloat(4));

                Address address = new Address();
                address.setAddressId(resultSet.getInt(5));
                address.setFlatNo(resultSet.getInt(7));
                address.setHouseName(resultSet.getString(8));
                address.setCity(resultSet.getString(9));
                address.setPinCode(resultSet.getInt(10));

                employee.setEmployeeAddress(address);

                return  employee;
            }

        });

        for (Employee employee: employeeList){
            System.out.println(employee);
        }
    }

    @Override
    public void sortByLastName() {
        String sql = "select * from employee inner join address on employee.address_id = address.id order by employee.lname";
        List<Employee> employeeList = jdbcTemplate.query(sql, new RowMapper() {
            @Override
            public Object mapRow(ResultSet resultSet, int i) throws SQLException {
                Employee employee = new Employee();
                employee.setEmployeeId(resultSet.getInt(1));
                employee.setEmployeeFirstName(resultSet.getString(2));
                employee.setEmployeeLastName(resultSet.getString(3));
                employee.setEmployeeSalary(resultSet.getFloat(4));

                Address address = new Address();
                address.setAddressId(resultSet.getInt(5));
                address.setFlatNo(resultSet.getInt(7));
                address.setHouseName(resultSet.getString(8));
                address.setCity(resultSet.getString(9));
                address.setPinCode(resultSet.getInt(10));

                employee.setEmployeeAddress(address);

                return  employee;
            }

        });

        for (Employee employee: employeeList){
            System.out.println(employee);
        }
    }

    @Override
    public void sortByFirstName() {
        String sql = "select * from employee inner join address on employee.address_id = address.id order by employee.fname";
        List<Employee> employeeList = jdbcTemplate.query(sql, new RowMapper() {
            @Override
            public Object mapRow(ResultSet resultSet, int i) throws SQLException {
                Employee employee = new Employee();
                employee.setEmployeeId(resultSet.getInt(1));
                employee.setEmployeeFirstName(resultSet.getString(2));
                employee.setEmployeeLastName(resultSet.getString(3));
                employee.setEmployeeSalary(resultSet.getFloat(4));

                Address address = new Address();
                address.setAddressId(resultSet.getInt(5));
                address.setFlatNo(resultSet.getInt(7));
                address.setHouseName(resultSet.getString(8));
                address.setCity(resultSet.getString(9));
                address.setPinCode(resultSet.getInt(10));

                employee.setEmployeeAddress(address);

                return  employee;
            }

        });

        for (Employee employee: employeeList){
            System.out.println(employee);
        }
    }

    @Override
    public void showSalaryAndMumbai() {
        String sql = "select * from employee inner join address on employee.address_id = address.id where salary>10000 and address.city like 'Mumbai'";
        List<Employee> employeeList = jdbcTemplate.query(sql, new RowMapper() {
            @Override
            public Object mapRow(ResultSet resultSet, int i) throws SQLException {
                Employee employee = new Employee();
                employee.setEmployeeId(resultSet.getInt(1));
                employee.setEmployeeFirstName(resultSet.getString(2));
                employee.setEmployeeLastName(resultSet.getString(3));
                employee.setEmployeeSalary(resultSet.getFloat(4));

                Address address = new Address();
                address.setAddressId(resultSet.getInt(5));
                address.setFlatNo(resultSet.getInt(7));
                address.setHouseName(resultSet.getString(8));
                address.setCity(resultSet.getString(9));
                address.setPinCode(resultSet.getInt(10));

                employee.setEmployeeAddress(address);

                return  employee;
            }

        });

        for (Employee employee: employeeList){
            System.out.println(employee);
        }
    }
}
