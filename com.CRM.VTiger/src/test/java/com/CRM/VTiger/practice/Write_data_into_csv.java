package com.CRM.VTiger.practice;

import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.CSVWriter;

public class Write_data_into_csv {

	public static void main(String[] args) throws IOException {
		//
		FileWriter fw=new FileWriter("./src/test/resources/NewFile.csv");
		
		//
		CSVWriter csw=new CSVWriter(fw);
		
		//
		String cell[]=new String[3];
		
		cell[0]="Raju";
		cell[1]="Adithi";
		cell[2]="sriyanka";
		
		//
		csw.writeNext(cell);
		
		//
		csw.flush();
		System.out.println("data Added");
	}

}
