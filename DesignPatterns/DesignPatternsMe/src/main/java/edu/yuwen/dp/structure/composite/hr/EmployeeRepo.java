package edu.yuwen.dp.structure.composite.hr;

import java.util.List;

public interface EmployeeRepo {

    double getEmployeeSalary(Long employeeId);

    List<Long> getDepartmentEmployeeIds(long id);

}
