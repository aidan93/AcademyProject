package project.strategies;

import java.util.List;

import project.entity.Stock;

public class Strategy {

	public Strategy() {

	}
	
	//Calculates moving average for the specified array of data
	public static double calcMovingAverage(List<Stock> thearray){
		double av = 0, total = 0;
		for(int i = 0;i < thearray.size();i++)
		{
			double bid = thearray.get(i).getBidPrice();
			double ask = thearray.get(i).getAskPrice();
			double avg = Math.round(((bid+ask)/2)*100.0)/100.0;
			total += avg;
		}
		av = total/thearray.size();
		System.out.println("Array Length: " + thearray.size());
		return Math.round(av * 100.0)/100.0;
	}
}
