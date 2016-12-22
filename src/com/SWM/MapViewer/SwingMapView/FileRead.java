package com.SWM.MapViewer.SwingMapView;
import java.util.ArrayList;
import java.io.*;

public class FileRead {
	public ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
	
	public void GetLines()
	{
		try(BufferedReader br = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/Maps/testmap.map"))))
		{
			String currentLine;
			
			while((currentLine = br.readLine()) != null)
			{
				if(currentLine.isEmpty())
				{
					continue;
				}
				
				ArrayList<Integer> row = new ArrayList<>();
				
				String[] values = currentLine.trim().split(" ");
				
				for(String val : values)
				{
					row.add(Integer.parseInt(val));
				}
				
				arr.add(row);
			}
			
			arr.remove(0);
			arr.remove(0);
		}
		catch (IOException e)
		{
			System.out.println("Can't read from file or file not found! (Map)");
		}
	}
}
