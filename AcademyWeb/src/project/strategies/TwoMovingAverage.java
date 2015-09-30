package project.strategies;

import java.util.ArrayList;
import java.util.List;

import project.entity.Stock;

public class TwoMovingAverage extends Strategy {
	
	private String stock;
	private int shortLength;
	private int longLength;
	private List<Double> shortPrices = new ArrayList<>();
	private List<Double> longPrices = new ArrayList<>();
	
	
	public TwoMovingAverage(String stock, int shortTime, int longTime) {
		super(stock, longTime);
		this.shortLength = shortTime;
		this.longLength = longTime;
	}
	
	
	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public int getShortLength() {
		return shortLength;
	}

	public void setShortLength(int shortLength) {
		this.shortLength = shortLength;
	}

	public int getLongLength() {
		return longLength;
	}

	public void setLongLength(int longLength) {
		this.longLength = longLength;
	}
	
	public List<Double> getShortPrices() {
		return shortPrices;
	}

	public void setShortPrices(List<Double> shortPrices) {
		this.shortPrices = shortPrices;
	}

	public List<Double> getLongPrices() {
		return longPrices;
	}

	public void setLongPrices(List<Double> longPrices) {
		this.longPrices = longPrices;
	}
	
}
