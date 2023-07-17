package com.example.taskTwoThree.HeadService.ReaderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taskTwoThree.entity.ReadCriteriaEnum;
import com.example.taskTwoThree.HeadService.ReaderService.dataReaderService.DBReaderService;
import com.example.taskTwoThree.HeadService.ReaderService.dataReaderService.ExcelReaderService;

/**
 * A factory for creating ReaderService objects.
 */
@Service
public class ReaderServiceFactory {

	/** The db reader service. */
	@Autowired
	private DBReaderService dbReaderService;

	/** The excel reader service. */
	@Autowired
	private ExcelReaderService excelReaderService;

	/**
	 * Data reader.
	 *
	 * @param readerCriteria the reader criteria
	 * @return the reader service
	 */
	public ReaderService dataReader(String readerCriteria) {
		ReadCriteriaEnum readCriteriaEnum = ReadCriteriaEnum.valueOf(readerCriteria);

		switch (readCriteriaEnum) {

		case EXCELREAD: {
			return excelReaderService;
		}

		case DBREAD: {
			return dbReaderService;
		}

		default:
			throw new IllegalArgumentException("Unexpected value: " + readerCriteria);
		}
	}
}
