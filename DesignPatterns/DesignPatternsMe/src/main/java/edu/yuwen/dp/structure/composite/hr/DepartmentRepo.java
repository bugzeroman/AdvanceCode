package edu.yuwen.dp.structure.composite.hr;

import java.util.List;

public interface DepartmentRepo {

    List<Long> getSubDepartmentIds(long id);

}
