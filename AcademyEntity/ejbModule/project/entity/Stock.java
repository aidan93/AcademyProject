package project.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="Stocks")
public class Stock {
	
	public Stock() {
		
	}
	
	public Stock(String symbol, double bid, double ask, double close) {
		super();
		this.stockSymbol = symbol;
		this.bidPrice = bid;
		this.askPrice = ask;
		this.previousClose = close;
	}
	
	public Stock(String symbol, double bid, double ask, double high, double low, double open, double close) {
		super();
		this.stockSymbol = symbol;
		this.bidPrice = bid;
		this.askPrice = ask;
		this.dayHigh = high;
		this.dayLow = low;
		this.todaysOpen = open;
		this.previousClose = close;
	}
	
	@Id
	private int stockId;
	private String stockSymbol;
	private double bidPrice;
	private double askPrice;
	private double dayHigh;
	private double dayLow;
	private double todaysOpen;
	private double previousClose;
	private String time_Of;
	
	
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public String getStockSymbol() {
		return stockSymbol;
	}
	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}
	public double getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(double bidPrice) {
		this.bidPrice = bidPrice;
	}
	public double getAskPrice() {
		return askPrice;
	}
	public void setAskPrice(double askPrice) {
		this.askPrice = askPrice;
	}
	public double getDayHigh() {
		return dayHigh;
	}
	public void setDayHigh(double dayHigh) {
		this.dayHigh = dayHigh;
	}
	public double getDayLow() {
		return dayLow;
	}
	public void setDayLow(double dayLow) {
		this.dayLow = dayLow;
	}
	public double getTodaysOpen() {
		return todaysOpen;
	}
	public void setTodaysOpen(double todaysOpen) {
		this.todaysOpen = todaysOpen;
	}
	public double getPreviousClose() {
		return previousClose;
	}
	public void setPreviousClose(double previousClose) {
		this.previousClose = previousClose;
	}
	public String getTimeOf() {
		return time_Of;
	}
	public void setTimeOf(String timeOf) {
		this.time_Of = timeOf;
	}
	
	@Override
	public String toString() {
		return "Stock: " + this.getStockSymbol() + ", \n Bid Price: " + this.getBidPrice() + ", Ask Price: " 
				+ this.getAskPrice() + ", Today's Open Price: " + this.getTodaysOpen() + ", Previous Close: " 
				+ this.getPreviousClose() + ", Time: " + this.getTimeOf();
	}
}
