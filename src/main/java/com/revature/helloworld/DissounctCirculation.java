package com.revature.helloworld;

public class DissounctCirculation {
	
	public static void main(String[] args) {
		System.out.println("--- Calculation Discount..a ---");
		System.out.println("discountCalculation.main");
		DissounctCirculation dc = new DissounctCirculation();
		float finalAmt = dc.calculateTotal(100);
		System.out.println(finalAmt);
	}
	
	float calculateTotal(int saleAmount) {
		int taxRate = 6;
		float discount = 2.5f;
		
		float discountedAmount = saleAmount*(discount/100);
		float taxAmount = (saleAmount - discountedAmount) * taxRate/100;
		float totalBill = (saleAmount - discountedAmount + taxAmount);
		
		return totalBill;
	}

}
