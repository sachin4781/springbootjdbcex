package com.csi.service;

import com.csi.model.Employee;

import java.util.List;

public interface EmployeeService {


    public void savedata(Employee employee);

    public List<Employee> getalldata();

    public void updatedata(int empid, Employee employee);

    public void deletedatabyid(int empid);
}
