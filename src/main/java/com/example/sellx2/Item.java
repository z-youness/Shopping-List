package com.example.sellx2;

public class Item implements Comparable<Item> {

	
	String Name;
	int Qte,Priority,Price;
	
	public Item() {
		
		
	}
	
	public Item(String n , int P, int Q ,int price) {
		
		this.Name = n;
		this.Qte = Q;
		this.Priority = P;
		this.Price = price;
		
		
		
	}

	@Override
	public int compareTo(Item o) {
		
		if(o.Priority > this.Priority)
			return 1;
		else if(o.Priority == this.Priority)
			return 0;
		else 
			return -1;
	
	}
	
	
}
