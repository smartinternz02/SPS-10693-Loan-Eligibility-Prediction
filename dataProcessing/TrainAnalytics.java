package org;

import java.io.IOException;

import tech.tablesaw.api.*;
import tech.tablesaw.plotly.Plot;
import tech.tablesaw.plotly.components.Figure;
import tech.tablesaw.plotly.components.Layout;
import tech.tablesaw.plotly.traces.*;

public class LoanPrediction {
	public static void main(String args[]){
		try {
			Table data = Table.read().csv("D:\\ML_data_sets\\train_data.csv");
			System.out.println("size of data set : "+data.shape());
			System.out.println("\n");
			System.out.println("number of columns in data set\n"+data.columnCount());
			System.out.println("\n");
			System.out.println("empty\n"+data.emptyCopy());
			System.out.println("\n");
			System.out.println("First 5 rows of data\n"+data.first(5));
			System.out.println("\n");
			System.out.println("Structure of data\n"+data.structure());
			System.out.println("\n");
			System.out.println("Summary of data\n"+data.summary());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
