package com.example.taskTwoThree.HeadService.ReaderService.dataReaderService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taskTwoThree.Repository.EmployeeRepo;
import com.example.taskTwoThree.entity.EmployeeEntity;
import com.example.taskTwoThree.HeadService.ReaderService.ReaderService;

@Service
public class DBReaderService implements ReaderService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public List<EmployeeEntity> getData() {
		return employeeRepo.findAll();
	}

	public DBReaderService(EmployeeRepo employeeRepo) {
		this.employeeRepo = employeeRepo;
	}
	
	

}
