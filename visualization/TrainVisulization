package org;

import java.io.IOException;

import tech.tablesaw.api.*;
import tech.tablesaw.plotly.Plot;
import tech.tablesaw.plotly.components.Figure;
import tech.tablesaw.plotly.components.Layout;
import tech.tablesaw.plotly.traces.*;

public class TrainVisulization {
	public static void main(String args[]){
		try {
			Table data = Table.read().csv("D:\\ML_data_sets\\train_data.csv");
			Layout layout = Layout.builder().title("Self-Employed").build();
			HistogramTrace trace = HistogramTrace.builder(data.nCol("Self_Employed")).build();
			Plot.show(new Figure(layout,trace));
			Layout layout1 = Layout.builder().title("ApplicantIncome Vs LoanAmount").build();
			ScatterTrace trace1 = ScatterTrace.builder(data.nCol("ApplicantIncome"), data.nCol("LoanAmount")).build();
			Plot.show(new Figure(layout1,trace1));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
