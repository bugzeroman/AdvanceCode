package edu.yuwen.dp.structure.composite.hr;

import java.util.List;

/**
 * 6.组合模式（结构型）
 * 
 *
 * Demo:人力资源包括部门和员工，部门下面又有子部门和员工，可以计算部门的薪资成本
 */
public class HumanResourceDemo {
    // 构建组织架构的代码
    private static final long ORGANIZATION_ROOT_ID = 1001;
    // 依赖注入
    private DepartmentRepo departmentRepo;
    // 依赖注入
    private EmployeeRepo employeeRepo;

    public void buildOrganization() {
        Department rootDepartment = new Department(ORGANIZATION_ROOT_ID);
        buildOrganization(rootDepartment);
    }

    private void buildOrganization(Department department) {
        List<Long> subDepartmentIds = departmentRepo.getSubDepartmentIds(department.getId());
        for (Long subDepartmentId : subDepartmentIds) {
            Department subDepartment = new Department(subDepartmentId);
            department.addSubNode(subDepartment);
            buildOrganization(subDepartment);
        }
        List<Long> employeeIds = employeeRepo.getDepartmentEmployeeIds(department.getId());
        for (Long employeeId : employeeIds) {
            double salary = employeeRepo.getEmployeeSalary(employeeId);
            department.addSubNode(new Employee(employeeId, salary));
        }
    }
}