package com.csi.service;

import com.csi.dao.EmployeeDao;
import com.csi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDaoImpl;


    @Override
    public void savedata(Employee employee) {

        employeeDaoImpl.savedata(employee);
    }

    @Override
    public List<Employee> getalldata() {
        return employeeDaoImpl.getalldata();
    }

    @Override
    public void updatedata(int empid, Employee employee) {

        employeeDaoImpl.updatedata(empid, employee);
    }

    @Override
    public void deletedatabyid(int empid) {

        employeeDaoImpl.deletedatabyid(empid);
    }
}
