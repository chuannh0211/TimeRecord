package com.aht.service;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import com.aht.model.Employee;

@Service
public class CsvService {
	String forget = "17:15";
	String forget1 = "8:15";
	static int gioLam, hours, mins, hoursGiovao, minsGiovao, hoursGiora, minsGiora, convertIn, convertOut;
	static List<Employee> list = new ArrayList<Employee>();

	public void readCSV(String link) throws IOException {

		try (Reader reader = new FileReader("E:\\data\\" + link);
				CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withNullString(null));) {
			Iterable<CSVRecord> csvRecord = csvParser.getRecords();
			for (CSVRecord csvRecord2 : csvRecord) {
				Employee emp = new Employee();
				emp.setTen(csvRecord2.get(4));
				emp.setNgay(csvRecord2.get(5));
				emp.setCa(csvRecord2.get(7));
				if (csvRecord2.get(7).toString().equals("")) {
					emp.setCa(forget1);
				} else {
					emp.setRa(csvRecord2.get(7));
				}
				if (csvRecord2.get(10).toString().equals("")) {
					emp.setRa(forget);
				} else {
					emp.setRa(csvRecord2.get(10));
				}
				list.add(emp);
			}
		}

		String bientam = list.get(1).getTen();

		int nghitrua = 0;
		int sum = 0;

		String csvFilee = "E:\\result/result.csv";
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilee));
				CSVPrinter csvPrinter = new CSVPrinter(writer,
						CSVFormat.DEFAULT.withNullString(null).withIgnoreSurroundingSpaces().withHeader("Ten", "Ngay",
								"Vao", "Ra", "Gio lam", "Gio", "Phut", "Phat"));) {
			for (int i = 1; i < list.size(); i++) {
				String gioVao = list.get(i).getCa();
				String gioRa = list.get(i).getRa();
				try {

					if (list.get(i).getRa() != null) {
						hoursGiovao = Integer.parseInt(gioVao.substring(0, 1));
						minsGiovao = Integer.parseInt(gioVao.substring(2));
						convertIn = hoursGiovao * 60 + minsGiovao;

						hoursGiora = Integer.parseInt(gioRa.substring(0, 2));
						minsGiora = Integer.parseInt(gioRa.substring(3));
						convertOut = hoursGiora * 60 + minsGiora;
						if (list.get(i).getRa() != null) {
							if (convertOut < 780) {
								gioLam = convertOut - convertIn - nghitrua;
								hours = gioLam / 60;
								mins = gioLam - hours * 60;
							} else {
								gioLam = convertOut - convertIn - 90;
								hours = gioLam / 60;
								mins = gioLam - hours * 60;
							}
						}

					}
					//
					int phat = 0;
					if (convertIn > 495 && convertIn <= 510) {
						phat = 20;
						// System.out.println(phat);
					} else if (convertIn >= 511 && convertIn <= 525) {
						phat = 30;
						// System.out.println(phat);
					} else if (convertIn >= 526 && convertIn <= 540) {
						phat = 40;
						// System.out.println(phat);
					} else if (convertIn >= 541 && convertIn <= 570) {
						phat = 50;
						// System.out.println(phat);
					} else if (convertIn >= 571 && convertIn <= 600) {
						phat = 80;
						// System.out.println(phat);
					} else if (convertIn >= 601 && convertIn <= 660) {
						phat = 100;
						// System.out.println(phat);
					}

					if (bientam.equals(list.get(i).getTen())) {
						sum += phat;
					} else {
						csvPrinter.printRecord("Tong phat", "", "", "", "", "", "", sum);
						sum = 0;
						bientam = list.get(i).getTen();
						// duyá»‡t láº¡i máº£ng
						if (bientam.equals(list.get(i).getTen())) {
							sum += phat;
						}
					}

					//

					//
					csvPrinter.printRecord(list.get(i).getTen(), list.get(i).getNgay(), list.get(i).getCa(),
							list.get(i).getRa(), gioLam, hours, mins, phat);
					csvPrinter.flush();

				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}

}
