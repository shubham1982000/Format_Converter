package com.example.taskTwoThree.HeadService.WriterService.FileWriterService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
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

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.example.taskTwoThree.entity.EmployeeEntity;

@SpringBootTest
class XmlWriterServiceTest {

	@Autowired
	private XmlWriterService xmlWriterServiceTest;

	long yourmilliseconds = System.currentTimeMillis();
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
	Date resultdate = new Date(yourmilliseconds);
	String format = sdf.format(resultdate);
	List<EmployeeEntity> employeeData;
	String filePath = ("files/XMLFile" + format + ".xml");

	@BeforeEach
	void setUp() {
		EmployeeEntity emp1 = new EmployeeEntity(1, null, 12.33);
		EmployeeEntity emp2 = new EmployeeEntity(2, "AAA", 33.4);

		employeeData = Arrays.asList(emp1, emp2);

	}

	@Test
	void testWriteData() throws IOException {
		for (File file : new java.io.File("files/").listFiles())
			if (!file.isDirectory())
				file.delete();

		xmlWriterServiceTest.writeData(employeeData);

		Path path = Paths.get("D:\\WORKSPACE STS\\TaskTwoThree\\files");
		assertTrue(Files.exists(path));
	}

	@Test
	void testDataInXML() {
		try {
			File xmlFile = new File(filePath);

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(xmlFile);
			Element root = document.getDocumentElement();
			NodeList nodeList = root.getChildNodes();
			List<EmployeeEntity> testDataList = new ArrayList<>();

			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {
					String elementValue = node.getTextContent();
					String[] splitStr = elementValue.split("\\s");
					testDataList.add(new EmployeeEntity(Integer.parseInt(splitStr[1]), splitStr[2],
							Double.parseDouble(splitStr[3])));
				}
			}
			assertEquals(employeeData.get(0).getEmp_id(), testDataList.get(0).getEmp_id());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testWriteData_emptyList() throws IOException {
		for (File file : new java.io.File("files/").listFiles())
			if (!file.isDirectory())
				file.delete();

		List<EmployeeEntity> emptyEmployeeData = Collections.<EmployeeEntity>emptyList();
		xmlWriterServiceTest.writeData(emptyEmployeeData);

		boolean flag = true;
		File file = new File("D:\\WORKSPACE STS\\TaskTwoThree\\files\\");
		if (file.isDirectory() && file.list().length > 0) {
			flag = false;
		}
		assertTrue(flag);
	}
}
