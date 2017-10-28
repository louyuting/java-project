package com.example.patterns.strategy;

//现金正常收取
public class CashNormal extends CashSuper{

	@Override
	public double acceptCash(double money) {

		return money;
	}

}
