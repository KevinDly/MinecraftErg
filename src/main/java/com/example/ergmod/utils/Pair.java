package com.example.ergmod.utils;

public class Pair<X, Y> {
	X first;
	Y second;
	public Pair(X first, Y second){
		this.first = first;
		this.second = second;
	}
	
	public X getFirst(){
		return first;
	}
	
	public Y getSecond(){
		return second;
	}
	
	public void setFirst(X first){
		this.first = first;
	}
	
	public void setSecond(Y second){
		this.second = second;
	}
}
