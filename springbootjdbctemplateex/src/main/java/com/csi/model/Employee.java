package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {

    private int empid;

    private String empname;

    private String empaddress;

    private double empsalary;

    private long empcontactnumber;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date empdob;
}
