package com.example.taskTwoThree.HeadService.WriterService.FileWriterService;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taskTwoThree.entity.EmployeeEntity;
import com.example.taskTwoThree.HeadService.WriterService.WriterService;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class ExcelWriterService implements WriterService {

	@Autowired
	HttpServletResponse servletResponse;

	@Override
	public void writeData(List<EmployeeEntity> employeeList) {
		final Logger logger = LoggerFactory.getLogger(ExcelWriterService.class);
		if (employeeList.isEmpty()) {
			logger.info("LIST IS EMPTY ...EXCEL");
		} else {
			try {

				HSSFWorkbook workbook = new HSSFWorkbook();
				HSSFSheet sheet = workbook.createSheet("Employee Info");
				HSSFRow row = sheet.createRow(0);

				row.createCell(0).setCellValue("emp_id");
				row.createCell(1).setCellValue("emp_name");
				row.createCell(2).setCellValue("emp_sal");

				int dataRowIndex = 1;

				for (EmployeeEntity employee : employeeList) {
					HSSFRow dataRow = sheet.createRow(dataRowIndex);

					dataRow.createCell(0).setCellValue(employee.getEmp_id());
					dataRow.createCell(1).setCellValue(employee.getEmp_name());
					dataRow.createCell(2).setCellValue(employee.getEmp_sal());

					dataRowIndex++;
				}

				servletResponse.setContentType("application/octet-stream");
				String headerKey = "Content-Disposition";
				long yourmilliseconds = System.currentTimeMillis();
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
				Date resultdate = new Date(yourmilliseconds);
				String format = sdf.format(resultdate);

				String filePath = "D:/WORKSPACE_STS/TaskTwoThree/files/EXCELFile" + format + ".xls";
				File file = new File(filePath);
				String headerValue = "attachment;filename=" + file.getName();

				servletResponse.setHeader(headerKey, headerValue);

				ServletOutputStream ops = servletResponse.getOutputStream();
				FileOutputStream fileOut = new FileOutputStream(filePath);
				workbook.write(fileOut);
				fileOut.close();
				
				workbook.write(ops);
				workbook.close();
				ops.close();

			} catch (Exception e) {

			}
		}
	}
}
