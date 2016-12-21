package com.SWM.MapViewer.SwingMapView;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.*;

@SuppressWarnings("serial")
public class PrintMap extends JFrame{
	private JPanel contentPane;
	private ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
	
	public PrintMap()
	{
		
	}
	
	public void CreateFrame()
	{
		setTitle("Map Generator");
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 645);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	
	public void GetArrayList()
	{
		FileRead fr = new FileRead();
		fr.GetLines();
		this.arr = fr.arr;
	}
	
	public static void main(String[] args) throws IOException
	{
		PrintMap nw = new PrintMap();
		nw.CreateFrame();
		nw.GetArrayList();
	}
}
