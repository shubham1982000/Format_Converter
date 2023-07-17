package com.example.taskTwoThree.HeadService.WriterService.FileWriterService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.taskTwoThree.entity.EmployeeEntity;

@SpringBootTest
class CsvWriterServiceTest {

	@Autowired
	private CsvWriterService CsvWriterServiceTest;

	long yourmilliseconds = System.currentTimeMillis();
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
	Date resultdate = new Date(yourmilliseconds);
	String format = sdf.format(resultdate);
	List<EmployeeEntity> employeeData;
	String filePath = ("files/CSVFile" + format + ".csv");

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
		CsvWriterServiceTest.writeData(employeeData);
		Path path = Paths.get("D:\\WORKSPACE STS\\TaskTwoThree\\files");
		assertTrue(Files.exists(path));

	}

	@Test
	public void testDataInFile() throws IOException {
		FileReader fileReader = new FileReader(filePath);
		BufferedReader br = new BufferedReader(fileReader);
		String line = null;
		String splitBy = ",";
		List<EmployeeEntity> testEmpList = new ArrayList<>();

		while ((line = br.readLine()) != null) // returns a Boolean value
		{
			String[] employee = line.split(splitBy);

			if (line.contains("emp_id , emp_name, emp_sal")) {
				continue;
			} else {
				System.out.println(line);
				int index = 0;
				testEmpList.add(index, new EmployeeEntity(Integer.parseInt(employee[0]), employee[1],
						Double.parseDouble(employee[2])));
				index++;
			}
		}
		assertEquals(employeeData.size(), testEmpList.size());
		assertEquals(employeeData.get(0).getEmp_id(), testEmpList.get(1).getEmp_id());

		br.close();
	}

	@Test
	void testWriteData_emptyList() throws IOException {
		for (File file : new java.io.File("files/").listFiles())
			if (!file.isDirectory())
				file.delete();

		List<EmployeeEntity> emptyEmployeeData = Collections.<EmployeeEntity>emptyList();
		CsvWriterServiceTest.writeData(emptyEmployeeData);

		boolean flag = Boolean.FALSE;
		File file = new File("D:\\WORKSPACE STS\\TaskTwoThree\\files\\");
		if (file.isDirectory() && file.list().length > 0) {
			flag = false;
		}
		assertTrue(flag);
	}
}