package project.strategies;

import project.entity.Stock;

public class Strategy {
	private String stock;
	private int length;
	private int avgCurrentRow;
	private int mAvgCurrentRow;
	private double[] movingAvg;
	private double[] avgOfPrices;

	public Strategy(String stock, int length) {
		this.stock = stock;
		this.length = length;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double[] getMovingAvg() {
		return movingAvg;
	}

	public void setMovingAvg(double[] movingAvg) {
		this.movingAvg = movingAvg;
	}
	
	public double[] getAvgOfPrices() {
		return avgOfPrices;
	}

	public void setAvgOfPrices(double[] avgOfPrices) {
		this.avgOfPrices = avgOfPrices;
	}
	
	public void calculateMovingAvg(Stock stock, long startTime, int length) {
		
		double bid = stock.getBidPrice();
		double ask = stock.getAskPrice();
		double avg = (bid + ask)/2;
    	avg = Math.round(avg * 100.0)/100.0;
   
		if((System.currentTimeMillis()-startTime) < length*60*1000) {
        	avgOfPrices[avgCurrentRow] = avg;
        	avgCurrentRow++;
		} else {
			double totalAvg = 0;
			for(Double d : avgOfPrices) {
				totalAvg += d;
			}
			//avg prices
			double movingAvgPrice = Math.round(totalAvg * 100.0)/100.0;
			movingAvg[mAvgCurrentRow] = movingAvgPrice;
			mAvgCurrentRow++;
			slideArray(avgOfPrices);
			stock.setMovingAvg(movingAvgPrice);
		}
	}

	public static void slideArray(double[] thearray){
		for(int i = 0;i < thearray.length - 1;i++)
		{
			thearray[i] = thearray[i + 1];
		}
	}
}
