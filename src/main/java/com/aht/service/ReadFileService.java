//package com.aht.service;
//
//import java.io.BufferedWriter;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.Reader;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.commons.csv.CSVFormat;
//import org.apache.commons.csv.CSVParser;
//import org.apache.commons.csv.CSVPrinter;
//import org.apache.commons.csv.CSVRecord;
//import org.springframework.stereotype.Service;
//
//import com.aht.model.Employee;
//
//@Service
//public class ReadFileService {
//	static List<Employee> list = new ArrayList<Employee>();
//
//	public void readCSV(String link) throws IOException {
//
//		try (Reader reader = new FileReader("E:\\" + link);
//				CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);) {
//			Iterable<CSVRecord> csvRecord = csvParser.getRecords();
//			for (CSVRecord csvRecord2 : csvRecord) {
//				Employee emp = new Employee();
//				emp.setTen(csvRecord2.get(4));
//				emp.setNgay(csvRecord2.get(5));
//				emp.setCa(csvRecord2.get(7));
//				emp.setRa(csvRecord2.get(10));
//				list.add(emp);
//			}
//		}
//
//	}
//
//}
