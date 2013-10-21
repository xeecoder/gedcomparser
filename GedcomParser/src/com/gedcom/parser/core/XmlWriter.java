package com.gedcom.parser.core;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class XmlWriter {
	
	private String out = null;
	
	public XmlWriter(String out){
		this.out = out;
	}
	
	public void writeXml(DataCache cache){
			
		try{
		       boolean hasChild = false;
		       StringBuilder buffer = new StringBuilder();
		       buffer.append("<gedcom>\n");
		
					for(String tag : cache.get().keySet()){
					  buffer.append("<indi id=\"" + tag + "\">\n");	
					   List<DataNode> nodes = cache.get().get(tag);
						 for(DataNode node : nodes){
						  if(node.getParent()>0) continue;  
							 hasChild = false;  
							   buffer.append("<" + node.getKey() + ">");
							        for(DataNode child : nodes){
							        	if(node.getId() == child.getParent() && child.getId() != node.getId()){
							        		hasChild = true;
							        		buffer.append("<" + child.getKey() + ">" + child.getData() + "</" + child.getKey() + ">\n" );
							        	}
							        }
							   if(!hasChild)   buffer.append(node.getData());
							   buffer.append("</" + node.getKey() + ">\n");     
						   }
					  buffer.append("</indi>\n");   
					}
				
		   	     BufferedWriter out = new BufferedWriter(new FileWriter(this.out));
		    	 out.write(buffer.toString());
			     out.close();
		}
		catch(IOException e){
			 System.out.println("File IO exception: " + e.getMessage());
		}
		catch (Exception e)  {
			 System.out.println(e.getMessage());
		}

	}	
		

}
