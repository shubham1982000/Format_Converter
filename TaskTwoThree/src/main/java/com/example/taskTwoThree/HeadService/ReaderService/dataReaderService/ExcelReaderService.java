package com.example.taskTwoThree.HeadService.ReaderService.dataReaderService;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.taskTwoThree.entity.EmployeeEntity;
import com.example.taskTwoThree.HeadService.ReaderService.ReaderService;

@Service
public class ExcelReaderService implements ReaderService {

	@Value("${file.path}")
	private String filePath;

	final String sheetName = "EmpInfo";

	@Override
	public List<EmployeeEntity> getData() {
		List<EmployeeEntity> employeeList = new ArrayList<>();

		try (FileInputStream fis = new FileInputStream(new File(filePath));
				HSSFWorkbook workbook = new HSSFWorkbook(fis);) {
			HSSFSheet sheet = workbook.getSheet(sheetName);
			int rowNumber = 0;

			Iterator<Row> iterator = sheet.iterator();

			while (iterator.hasNext()) {

				Row row = iterator.next();

				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}

				Iterator<Cell> cells = row.iterator();

				int cid = 0;

				EmployeeEntity ee = new EmployeeEntity();

				while (cells.hasNext()) {

					Cell cell = cells.next();

					switch (cid) {
					case 0: {
						ee.setEmp_id((int) cell.getNumericCellValue());
						break;
					}
					case 1: {
						ee.setEmp_name(cell.getStringCellValue());
						break;
					}
					case 2: {
						ee.setEmp_sal(cell.getNumericCellValue());
						break;
					}
					default: {
						break;
					}
					}
					cid++;
				}
				employeeList.add(ee);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return employeeList;
	}

}
