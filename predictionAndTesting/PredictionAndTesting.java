package org;
import java.util.Arrays;

import weka.classifiers.Classifier;
import weka.classifiers.evaluation.Evaluation;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;
import weka.core.converters.ConverterUtils.DataSource;
public class PredictionAndTesting {
	
	public static Instances getInstances(String filename)
	{
		DataSource source;
		Instances dataset=null;
		try {
			source = new DataSource(filename);
			dataset = source.getDataSet();
			dataset.setClassIndex(dataset.numAttributes()-1);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return dataset;
	}
	
	public static void main(String[] args) throws Exception
	{
		Instances data=getInstances("D:\\ML_data_sets\\train_data_filtered.csv");
		Instances test=getInstances("D:\\ML_data_sets\\test_data.csv");
		System.out.println(data.size());
		Classifier classifier = new weka.classifiers.functions.Logistic();

		classifier.buildClassifier(data);
		
		
		
		Evaluation eval = new Evaluation(data);
		eval.evaluateModel(classifier, data);
		/** Print the algorithm summary */
		System.out.println("Logistic Regression on loan prediction data: ");
		System.out.println("summary : "+eval.toSummaryString());
		
		
		
		double confusion[][]=eval.confusionMatrix();
		System.out.println("\nConfusion matrix:");
		for(double[] row: confusion)
			System.out.println(Arrays.toString(row));
		
		
		System.out.println("\nArea under the curve");
		System.out.println(eval.areaUnderROC(0));
		
		System.out.println(eval.getAllEvaluationMetricNames());
		
		System.out.println("\nRecall : ");
		System.out.println(Math.round(eval.recall(1)*100.0)/100.0);
		
		System.out.println("\nPrecision: ");
		
		System.out.println(Math.round(eval.precision(1)*100.0)/100.0);
		System.out.print("\nF1 score:");
		System.out.println(Math.round(eval.fMeasure(1)*100.0)/100.0);
		
		System.out.print("\nAccuracy:");
		double acc = eval.correct()/(eval.correct()+ eval.incorrect());
		System.out.println(Math.round(acc*100.0)/100.0);
		
		
		Instance predicationDataSet = data.get(2);
		double value = classifier.classifyInstance(predicationDataSet);
		System.out.println("\nPredicted label:");
		System.out.print(value);
	}
}
