package com.example.taskTwoThree.HeadService.WriterService.DBWriterService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taskTwoThree.Repository.DBWriterRepo;
import com.example.taskTwoThree.entity.DBWriterEntity;
import com.example.taskTwoThree.entity.EmployeeEntity;
import com.example.taskTwoThree.HeadService.WriterService.WriterService;

@Service
public class DBWriter implements WriterService {

	@Autowired
	private DBWriterRepo dbWriterRepo;

	@Override
	public void writeData(List<EmployeeEntity> employeeList) {
		DBWriterEntity dbWriterEntity = new DBWriterEntity();

		for (EmployeeEntity employee : employeeList) {
			dbWriterEntity.setEmp_id(employee.getEmp_id());
			dbWriterEntity.setEmp_name(employee.getEmp_name());
			dbWriterEntity.setEmp_sal(employee.getEmp_sal());

			dbWriterRepo.save(dbWriterEntity);
		}
	}
}
