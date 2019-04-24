//package com.aht.service;
//
//import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.commons.csv.CSVFormat;
//import org.apache.commons.csv.CSVPrinter;
//import org.springframework.stereotype.Service;
//
//import com.aht.model.Employee;
//
//@Service
//public class WriteFileService {
//	static List<Employee> list = new ArrayList<Employee>();
//
//	String bientam = list.get(1).getTen();
//	int sum = 0;
//
//	String csvFilee = "E:\\data/result.csv";
//
//	public void writeCSV() throws IOException {
//		try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilee));
//				CSVPrinter csvPrinter = new CSVPrinter(writer,
//						CSVFormat.DEFAULT.withHeader("Ten", "Ngay", "Vao", "Ra", "Gio lam", "Gio", "Phut", "Phat"));) {
//
//			for (int i = 1; i < list.size(); i++) {
//				try {
//					String vao = list.get(i).getCa();
//					int hours = Integer.parseInt(vao.substring(0, 1));
//					int mins = Integer.parseInt(vao.substring(2));
//					int a = hours * 60 + mins;
//					// System.out.println("a" + a);
//					String ra = list.get(i).getRa();
//					int hourss = Integer.parseInt(ra.substring(0, 2));
//					int minss = Integer.parseInt(ra.substring(3));
//					int b = hourss * 60 + minss;
//					// System.out.println("b" + b);
//					int m = b - a - 90;
//					int h = m / 60;
//					int l = m - h * 60;
//					//
//					int phat = 0;
//					if (a > 495 && a <= 510) {
//						phat = 20;
//						// System.out.println(phat);
//					} else if (a >= 511 && a <= 525) {
//						phat = 30;
//						// System.out.println(phat);
//					} else if (a >= 526 && a <= 540) {
//						phat = 40;
//						// System.out.println(phat);
//					} else if (a >= 541 && a <= 570) {
//						phat = 50;
//						// System.out.println(phat);
//					} else if (a >= 571 && a <= 600) {
//						phat = 80;
//						// System.out.println(phat);
//					} else if (a >= 601 && a <= 660) {
//						phat = 100;
//						// System.out.println(phat);
//					}
//
//					if (bientam.equals(list.get(i).getTen())) {
//						sum += phat;
//
//					} else {
//						csvPrinter.printRecord("Tong phat", "", "", "", "", "", "", sum);
//						sum = 0;
//						bientam = list.get(i).getTen();
//						// duyá»‡t láº¡i máº£ng
//						if (bientam.equals(list.get(i).getTen())) {
//							sum += phat;
//						}
//					}
//
//					csvPrinter.printRecord(list.get(i).getTen(), list.get(i).getNgay(), list.get(i).getCa(),
//							list.get(i).getRa(), m, h, l, phat);
//					csvPrinter.flush();
//				} catch (Exception e) {
//					// TODO: handle exception
//				}
//
//			}
//
//		}
//	}
//
//}
