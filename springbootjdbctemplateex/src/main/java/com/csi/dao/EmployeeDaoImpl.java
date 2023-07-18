package com.csi.dao;

import com.csi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    String Insert_Sql = "insert into employee(empid,empname,empaddress,empsalary,empcontactnumber,empdob) values(?,?,?,?,?,?)";

    String Select_Sql = "select * from employee";

    String Update_Sql = "update employee set empid=?,empname=?,empaddress=?,empsalary=?,empcontactnumber=?,empdob=? where empid=?";

    String Delete_Sql = "delete from employee where empid=?";

    private Employee employee(ResultSet resultSet, int numRow) throws SQLException {
        return Employee.builder().empid(resultSet.getInt(1)).empname(resultSet.getString(2)).empaddress(resultSet.getString(3)).
                empsalary(resultSet.getDouble(4)).empcontactnumber(resultSet.getLong(5)).empdob(resultSet.getDate(6)).build();
    }


    @Override
    public void savedata(Employee employee) {
        jdbcTemplate.update(Insert_Sql, employee.getEmpid(), employee.getEmpname(), employee.getEmpaddress(), employee.getEmpsalary(), employee.getEmpcontactnumber(), employee.getEmpdob());
    }

    @Override
    public List<Employee> getalldata() {
        return jdbcTemplate.query(Select_Sql, this::employee);
    }

    @Override
    public void updatedata(int empid, Employee employee) {
        jdbcTemplate.update(Update_Sql, employee.getEmpid(), employee.getEmpname(), employee.getEmpaddress(), employee.getEmpsalary(), employee.getEmpcontactnumber(), employee.getEmpdob(), empid);
    }

    @Override
    public void deletedatabyid(int empid) {

        jdbcTemplate.update(Delete_Sql, empid);
    }
}
