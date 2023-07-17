package com.example.taskTwoThree.HeadService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taskTwoThree.entity.EmployeeEntity;
import com.example.taskTwoThree.HeadService.ReaderService.ReaderService;
import com.example.taskTwoThree.HeadService.ReaderService.ReaderServiceFactory;
import com.example.taskTwoThree.HeadService.WriterService.WriterService;
import com.example.taskTwoThree.HeadService.WriterService.WriterServiceFactory;

@Service
public class HeadService {
	@Autowired
	private ReaderServiceFactory readerServiceFactory;
	@Autowired
	private WriterServiceFactory writerServiceFactory;

	public void process(String readerCriteria, String writerCriteria) {

		ReaderService readerService = readerServiceFactory.dataReader(readerCriteria);
		List<EmployeeEntity> employeeList = readerService.getData();

		WriterService writerService = writerServiceFactory.getWriter(employeeList, writerCriteria);
		writerService.writeData(employeeList);
	}
}
