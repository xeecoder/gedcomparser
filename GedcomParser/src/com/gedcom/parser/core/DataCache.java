package com.gedcom.parser.core;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class DataCache {
	
	private String node = null;
	private String root = null;
	private int nChild = 2;
	private int parent = 0;
	private TreeMap<String, List<DataNode>> cache = new TreeMap<String, List<DataNode>>();
		
	public TreeMap<String, List<DataNode>>  get(){
		return cache;
	}
	
	private void addRoot(String tag){
		cache.put(tag, new ArrayList<DataNode>());
	}
	
	private void addNode(DataNode node){
		this.cache.get(this.root).add(node);
	}
	
	public void processBuffer(String bf){
		
		try{
			String[] data = bf.split(" ", 3); 
			
			if(data.length == 0 ) return;
			else if(data.length == 2) data = new String[]{data[0], data[1], ""};
							
				if(data[0].equals("0")){					
					this.addRoot(data[1]);
					this.root = data[1];
					nChild = 2;
					parent = 0;
				}
				else{	
					if(Integer.parseInt(data[0]) > 1 && !data[0].equals(this.node)){
						parent = nChild-1;
					}
					else if(Integer.parseInt(data[0]) == 1){
						parent = 0;
					}
					DataNode node = new DataNode(parent, nChild, data[1], data[2]);
					this.addNode(node);
					this.node = data[0];
					nChild++;
				}						
			
		}	
		catch(Exception e){
		  System.out.println(e.getMessage());	
		}
	}
	
}
