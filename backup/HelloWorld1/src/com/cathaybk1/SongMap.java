package com.cathaybk1;

import java.io.ObjectInputStream.GetField;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;


public class SongMap {

	public static void main(String[] args) {
		Map<String,String> map = new TreeMap<>();
		map.put("coldplay", "yellow" );
		map.put("adele", "skyfall");
		map.put("lady gaga", "shallow");
		for(Entry<String, String> entry : map.entrySet()) {
			System.out.println("singer:" + entry.getKey() + ",song:" + entry.getValue());
		}
		
		
		System.out.println(map.keySet());
		System.out.println(map.values());
	}

	
	
}
