package com.example.taskTwoThree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.taskTwoThree.HeadService.HeadService;
import com.example.taskTwoThree.entity.RequestProcessing;

/**
 * The Class EmployeeController.
 * 
 */
@RestController
@RequestMapping("/api/v2_3/employee")
@ComponentScan
public class EmployeeController {

	/** The head service. */
	@Autowired
	private HeadService headService;

	@GetMapping("/sayhello")
	public String sayHello() {
		return "Say Hello...";
	}
	
//	  With PathVariable Example-------------------------------------------------------------------------------
	@GetMapping("/process/{readerCriteria}/{writerCriteria}")
	public void processEmployees(@PathVariable String readerCriteria, @PathVariable String writerCriteria)
			throws Exception {
		headService.process(readerCriteria, writerCriteria);
	}

//	@Get-----------------------------------------------------------------------------------------------------

	/*
	 * RequestBody Example with PostMapping
	 * 
	 * @PostMapping("/process") public void processEmp(@RequestBody
	 * RequestProcessing requestProcess) {
	 * headService.process(requestProcess.getReaderCriteria(),
	 * requestProcess.getWriterCriteria()); }
	 */
	/**
	 * Process employees. RequestBody Example with GetMapping
	 * 
	 * @param requestProcess the request process
	 * @throws Exception the exception
	 */
//	With RequestBody
	
//	@GetMapping("/process")
//	public void processEmployees(@RequestBody RequestProcessing requestProcess) throws Exception {
//		headService.process(requestProcess.getReaderCriteria(), requestProcess.getWriterCriteria());
//	}
////------------------------------------------------------------------------------------------------------
// passing local file form local machine with request parameter
	
//	@GetMapping("/process")
//	public void processEmployeesWithFileInput() throws Exception {
//
//		FileReader fileReader = new FileReader("RequestProcess/Request.txt");
//		BufferedReader br = new BufferedReader(fileReader);
//		String line = null;
//		String splitBy = ",";
//
//		String reader = "", writer = "";
//
//		while ((line = br.readLine()) != null) {
//			String[] reqString = line.split(splitBy);
//
//			reader = reqString[0];
//			writer = reqString[1];
//
//		}
//		headService.process(reader, writer);
//		br.close();
//	}
//-------------------------------------------------------------------------------------------------------------
// Passing File as a request with request parameters
	
//	@PostMapping({"/requestFile","/requestFile1","/requestFile2"})//multiEndpoint concept
//	public void processEmployeesWithFileInput(@RequestParam("requestFiletxt") MultipartFile file) throws Exception {
//
//		BufferedReader br = new BufferedReader(new java.io.InputStreamReader(file.getInputStream(), "UTF-8"));
//		String line = null;
//		String splitBy = ",";
//
//		String reader = "", writer = "";
//
//		while ((line = br.readLine()) != null) {
//			String[] reqString = line.split(splitBy);
//
//			reader = reqString[0];
//			writer = reqString[1];
//
//		}
//		headService.process(reader, writer);
//		br.close();
//
//	}
//	----------------------------------------------------------------------------------------------
}