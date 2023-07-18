package com.csi.controller;

import com.csi.model.Employee;
import com.csi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeServiceImpl;


    @PostMapping("/savedata")
    public ResponseEntity<String> savedata(@RequestBody Employee employee) {
        employeeServiceImpl.savedata(employee);
        return ResponseEntity.ok("Save Data SuccessFully..");
    }

    @GetMapping("/getalldata")
    public ResponseEntity<List<Employee>> getalldata() {
        return ResponseEntity.ok(employeeServiceImpl.getalldata());
    }

    @PutMapping("/updateData/{empid}")

    public ResponseEntity<String> updatedata(@PathVariable int empid, @RequestBody Employee employee) {
        employeeServiceImpl.updatedata(empid, employee);
        return ResponseEntity.ok("Update data SuccessFully..");
    }

    @DeleteMapping("/deletedata/{empid}")

    public ResponseEntity<String> deletedatbyid(@PathVariable int empid) {
        employeeServiceImpl.deletedatabyid(empid);
        return ResponseEntity.ok("Delete Data SuccessFully..");
    }

}
