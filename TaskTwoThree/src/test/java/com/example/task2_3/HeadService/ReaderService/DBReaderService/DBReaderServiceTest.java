package com.example.task2_3.HeadService.ReaderService.DBReaderService;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.taskTwoThree.Repository.EmployeeRepo;
import com.example.taskTwoThree.HeadService.ReaderService.dataReaderService.DBReaderService;

@ExtendWith(MockitoExtension.class)
class DBReaderServiceTest {

	@Mock
	private EmployeeRepo employeeRepoMock;

	private DBReaderService dbReaderService;

	@BeforeEach
	void setUp() {
		this.dbReaderService = new DBReaderService(this.employeeRepoMock);
	}

	@Test
	void getDataTest() {

		dbReaderService.getData();
		verify(employeeRepoMock).findAll();
	}

}
