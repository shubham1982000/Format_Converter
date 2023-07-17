package com.example.taskTwoThree.HeadService.WriterService.FileWriterService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.taskTwoThree.entity.EmployeeEntity;

@SpringBootTest
class ExcelWriterServiceTest {
	@Autowired
	private ExcelWriterService excelWriterServiceTest;

	long yourmilliseconds = System.currentTimeMillis();
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
	Date resultdate = new Date(yourmilliseconds);
	String format = sdf.format(resultdate);
	List<EmployeeEntity> employeeData;
	String filePath = ("files/EXCELFile" + format + ".xls");

	@BeforeEach
	void setUp() {
		EmployeeEntity emp1 = new EmployeeEntity(1, "SSM", 12.33);
		EmployeeEntity emp2 = new EmployeeEntity(2, "AAA", 33.4);

		employeeData = Arrays.asList(emp1, emp2);

	}

	@Test
	public void testDataInputAndFileExists() throws IOException {
		for (File file : new java.io.File("files/").listFiles())
			if (!file.isDirectory())
				file.delete();

		excelWriterServiceTest.writeData(employeeData);

		Path path = Paths.get("D:\\WORKSPACE STS\\TaskTwoThree\\files");
		assertTrue(Files.exists(path));

	}

	@Test
	void testDataInExcel() throws IOException {
		final String sheetName = "Employee Info";

		List<EmployeeEntity> employeeListTest = new ArrayList<>();

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
				employeeListTest.add(ee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertEquals(employeeData.size(), employeeListTest.size());
		assertEquals(employeeData.get(0).getEmp_id(), employeeListTest.get(0).getEmp_id());
	}

	@Test
	void testWriteData_emptyList() throws IOException {
		for (File file : new java.io.File("files/").listFiles())
			if (!file.isDirectory())
				file.delete();

		List<EmployeeEntity> emptyEmployeeData = Collections.<EmployeeEntity>emptyList();
		excelWriterServiceTest.writeData(emptyEmployeeData);

		boolean flag = true;
		File file = new File("D:\\WORKSPACE STS\\TaskTwoThree\\files\\");
		if (file.isDirectory() && file.list().length > 0) {
			flag = false;
		}
		assertTrue(flag);
	}

}
//org.apache.poi.EmptyFileException: The supplied file was empty (zero bytes long)
