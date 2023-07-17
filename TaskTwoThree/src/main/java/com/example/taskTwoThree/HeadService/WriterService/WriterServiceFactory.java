package com.example.taskTwoThree.HeadService.WriterService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taskTwoThree.entity.EmployeeEntity;

import com.example.taskTwoThree.entity.WriteCrireriaEnum;
import com.example.taskTwoThree.HeadService.WriterService.DBWriterService.DBWriter;
import com.example.taskTwoThree.HeadService.WriterService.FileWriterService.CsvWriterService;
import com.example.taskTwoThree.HeadService.WriterService.FileWriterService.ExcelWriterService;
import com.example.taskTwoThree.HeadService.WriterService.FileWriterService.PipeWriterService;
import com.example.taskTwoThree.HeadService.WriterService.FileWriterService.XmlWriterService;

@Service
public class WriterServiceFactory {
	@Autowired
	private PipeWriterService pipeWriterService;
	@Autowired
	private CsvWriterService csvWriterService;
	@Autowired
	private ExcelWriterService excelWriterService;
	@Autowired
	private XmlWriterService xmlWriterService;
	@Autowired
	private DBWriter dbWriter;

	public WriterService getWriter(List<EmployeeEntity> employeeList, String writerCriteria) {
		
		WriteCrireriaEnum writeCriteriaEnum = WriteCrireriaEnum.valueOf(writerCriteria);

		switch (writeCriteriaEnum) {
		case PIPEWRITE: {
			return pipeWriterService;
		}
		case CSVWRITE: {
			return csvWriterService;
		}
		case EXCELWRITE: {
			return excelWriterService;
		}
		case XMLWRITE: {
			return xmlWriterService;
		}
		case DBWRITE: {
			return dbWriter;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + writerCriteria);
		}
	}
}
