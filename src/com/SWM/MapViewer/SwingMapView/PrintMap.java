package com.SWM.MapViewer.SwingMapView;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
		setBounds(100, 100, 646, 680);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	
	public void PrintMapJ()
	{
		int y_bound = 0;
		int i;
		for(ArrayList<Integer> ar : arr)
		{
			int x_bound = 0;
			for(i = 0; i < ar.size(); i++)
			{
				switch(ar.get(i))
				{
					case 20 :
						JLabel tree = new JLabel();
						tree.setIcon(new ImageIcon("Resources/Imgs/Tree.png"));
						tree.setBounds(x_bound, y_bound, 16, 16);
						tree.setLayout(null);
						contentPane.add(tree);
					break;
					case 21 :
						JLabel chtree = new JLabel();
						chtree.setIcon(new ImageIcon("Resources/Imgs/ChTree.png"));
						chtree.setBounds(x_bound, y_bound, 16, 16);
						chtree.setLayout(null);
						contentPane.add(chtree);
					break;
					case 22 :
						JLabel water = new JLabel();
						water.setIcon(new ImageIcon("Resources/Imgs/Water.png"));
						water.setBounds(x_bound, y_bound, 16, 16);
						water.setLayout(null);
						contentPane.add(water);
					break;
					case 1 :
						JLabel path = new JLabel();
						path.setIcon(new ImageIcon("Resources/Imgs/Path.png"));
						path.setBounds(x_bound, y_bound, 16, 16);
						path.setLayout(null);
						contentPane.add(path);
					break;
					case 2 :
						JLabel grass = new JLabel();
						grass.setIcon(new ImageIcon("Resources/Imgs/Grass.png"));
						grass.setBounds(x_bound, y_bound, 16, 16);
						grass.setLayout(null);
						contentPane.add(grass);
					break;
					case 3 :
						JLabel flower = new JLabel();
						flower.setIcon(new ImageIcon("Resources/Imgs/Flower.png"));
						flower.setBounds(x_bound, y_bound, 16, 16);
						flower.setLayout(null);
						contentPane.add(flower);
					break;
					default :
					break;
				}
				x_bound = x_bound + 16;
			}
			y_bound = y_bound + 16;
		}
		contentPane.repaint();
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
		nw.PrintMapJ();
	}
}
