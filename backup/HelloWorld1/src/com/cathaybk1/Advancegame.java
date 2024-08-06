package com.cathaybk1;

import java.util.Random;

public class Advancegame {

	public static void main(String[] args) {
		Random rand = new Random();
		
		
		int a = 0;
		int b = 0;
		while(a < 2 && b < 2) {
			int xd = rand.nextInt(2);
			int xd2 = rand.nextInt(2);
		if(xd == 0 && xd2 == 1) {
			System.out.println("a出剪刀b出石頭b贏");
			b++;
		}
		else if(xd == 0 && xd2 == 2){
			System.out.println("a出剪刀b出布a贏");
			a++;
		}
		else if(xd == 1 && xd2 == 0){
			System.out.println("a出石頭b出剪刀a贏");
			a++;
		}
		else if(xd == 1 && xd2 == 2){
			System.out.println("a出石頭b出布b贏");
			b++;
		}
		else if(xd == 2 && xd2 == 0){
			System.out.println("a出布b出剪刀b贏");
			b++;
		}
		else if(xd == 2 && xd2 == 1){
			System.out.println("a出布b出石頭a贏");
			a++;
		}
		else{
			System.out.println("平手");
		}
		
		}
		if(a == 2) {
			System.out.println("a最後贏");
		}
		else {
			System.out.println("b最後贏");
		}
	}

}
