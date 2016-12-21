package com.SWM.MapViewer.ViewApp;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.ResourceBundle;
import java.util.Scanner;

import javax.imageio.ImageIO;

import com.neet.DiamondHunter.Main.Game;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Viewer_Controller implements Initializable{
	@FXML
	GridPane grid;
	
	@FXML
	AnchorPane base;
	
	@FXML
	Button setaxeloc;
	
	@FXML
	Button setboatloc;
	
	@FXML
	Button rundh;
	
	@FXML
	MenuItem ExitMenu;
	
	static Label axe, boat;
	static int axeFlag = 0, boatFlag = 0;
	public int axeRow, axeCol;
	public int boatRow, boatCol;
	int[] axeVal, boatVal;
	Scanner file = null, axelocfile = null, boatlocfile = null;
	ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
	
	public Viewer_Controller()
	{
		
	}
	
	public void ReadFile()
	{
		try
		{
			file = new Scanner(new File("Resources/Maps/testmap.map"));
		}
		catch(Exception e)
		{
			System.out.println("Can't read from file or file not found!");
		}
	}
	
	public ArrayList<ArrayList<Integer>> GetLines()
	{
		String currentLine;
		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
		
		while(file.hasNext())
		{
			currentLine = file.nextLine();
			
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
		
		return arr;
	}
	
	public int[] AxeLoc()
	{
		try
		{
			axelocfile = new Scanner(new File("Resources/Locations/AxeLoc.file"));
		}
		catch(Exception e)
		{
			System.out.println("Can't read from file or file not found!");
		}
		
		String currentLine;
		currentLine = axelocfile.nextLine();
		
		String[] values = currentLine.trim().split(" ");
		
		int[] val = new int[2];
		
		val[0] = Integer.parseInt(values[0]);
		val[1] = Integer.parseInt(values[1]);
		
		return val;
	}
	
	public int[] BoatLoc()
	{
		try
		{
			boatlocfile = new Scanner(new File("Resources/Locations/BoatLoc.file"));
		}
		catch(Exception e)
		{
			System.out.println("Can't read from file or file not found!");
		}
		
		String currentLine;
		currentLine = boatlocfile.nextLine();
		
		String[] values = currentLine.trim().split(" ");
		
		int[] val = new int[2];
		
		val[0] = Integer.parseInt(values[0]);
		val[1] = Integer.parseInt(values[1]);
		
		return val;
	}
	
	@SuppressWarnings("static-access")
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle)
	{
		Viewer_Controller nw = new Viewer_Controller();
		nw.ReadFile();
		axeVal = nw.AxeLoc();
		boatVal = nw.BoatLoc();
		arr = nw.GetLines();
		int row = 0;
		for(ArrayList<Integer> ar : arr)
		{
			int col = 0;
			for(int b : ar)
			{
				switch(b)
				{
					case 1 :
						BufferedImage pathImg = null;
						try
						{
							pathImg = ImageIO.read(new File("Resources/Imgs/Path.png"));
						} 
						catch (IOException e)
						{
							System.out.println("Image not found!");
						}
						Image pathImgFx = SwingFXUtils.toFXImage(pathImg, null);
						Label path = new Label();
						int column = col, rows = row;
						path.setOnMouseClicked(e -> {
							if(axeFlag == 1)
							{
								grid.getChildren().remove(axe);
								BufferedImage axeImg = null;
								try
								{
									axeImg = ImageIO.read(new File("Resources/Imgs/Axe.png"));
								}
								catch (IOException e1)
								{
									System.out.println("Image not found!");
								}
								Image axeImgFx = SwingFXUtils.toFXImage(axeImg, null);
								axe = new Label();
								axe.setGraphic(new ImageView(axeImgFx));
								grid.setConstraints(axe, column, rows);
								grid.getChildren().add(axe);
								axeRow = grid.getRowIndex(path);
								axeCol = grid.getColumnIndex(path);
								try
								{
									Formatter AxeOut = new Formatter("Resources/Locations/AxeLoc.file");
									AxeOut.format(axeRow + " " + axeCol);
									AxeOut.close();
								}
								catch (Exception e2)
								{
									System.out.println("Cannot write file!");
								}
								axeFlag = 0;
							}
							else if(boatFlag == 1)
							{
								grid.getChildren().remove(boat);
								BufferedImage boatImg = null;
								try
								{
									boatImg = ImageIO.read(new File("Resources/Imgs/Boat.png"));
								}
								catch (IOException e1)
								{
									System.out.println("Image not found!");
								}
								Image boatImgFx = SwingFXUtils.toFXImage(boatImg, null);
								boat = new Label();
								boat.setGraphic(new ImageView(boatImgFx));
								grid.setConstraints(boat, column, rows);
								grid.getChildren().add(boat);
								boatRow = grid.getRowIndex(path);
								boatCol = grid.getColumnIndex(path);
								try
								{
									Formatter BoatOut = new Formatter("Resources/Locations/BoatLoc.file");
									BoatOut.format(boatRow + " " + boatCol);
									BoatOut.close();
								}
								catch (Exception e2)
								{
									System.out.println("Cannot write file!");
								}
								boatFlag = 0;
							}
						});
						path.setGraphic(new ImageView(pathImgFx));
						grid.setConstraints(path, col, row);
						grid.getChildren().add(path);
					break;
					case 2 :
						BufferedImage grassImg = null;
						try
						{
							grassImg = ImageIO.read(new File("Resources/Imgs/Grass.png"));
						}
						catch (IOException e)
						{
							System.out.println("Image not found!");
						}
						Image grassImgFx = SwingFXUtils.toFXImage(grassImg, null);
						Label grass = new Label();
						column = col;
						rows = row;
						grass.setOnMouseClicked(e -> {
							if(axeFlag == 1)
							{
								grid.getChildren().remove(axe);
								BufferedImage axeImg = null;
								try
								{
									axeImg = ImageIO.read(new File("Resources/Imgs/Axe.png"));
								}
								catch (IOException e1)
								{
									System.out.println("Image not found!");
								}
								Image axeImgFx = SwingFXUtils.toFXImage(axeImg, null);
								axe = new Label();
								axe.setGraphic(new ImageView(axeImgFx));
								grid.setConstraints(axe, column, rows);
								grid.getChildren().add(axe);
								axeRow = grid.getRowIndex(grass);
								axeCol = grid.getColumnIndex(grass);
								try
								{
									Formatter AxeOut = new Formatter("Resources/Locations/AxeLoc.file");
									AxeOut.format(axeRow + " " + axeCol);
									AxeOut.close();
								}
								catch (Exception e2)
								{
									System.out.println("Cannot write file!");
								}
								axeFlag = 0;
							}
							else if(boatFlag == 1)
							{
								grid.getChildren().remove(boat);
								BufferedImage boatImg = null;
								try
								{
									boatImg = ImageIO.read(new File("Resources/Imgs/Boat.png"));
								}
								catch (IOException e1)
								{
									System.out.println("Image not found!");
								}
								Image boatImgFx = SwingFXUtils.toFXImage(boatImg, null);
								boat = new Label();
								boat.setGraphic(new ImageView(boatImgFx));
								grid.setConstraints(boat, column, rows);
								grid.getChildren().add(boat);
								boatRow = grid.getRowIndex(grass);
								boatCol = grid.getColumnIndex(grass);
								try
								{
									Formatter BoatOut = new Formatter("Resources/Locations/BoatLoc.file");
									BoatOut.format(boatRow + " " + boatCol);
									BoatOut.close();
								}
								catch (Exception e2)
								{
									System.out.println("Cannot write file!");
								}
								boatFlag = 0;
							}
						});
						grass.setGraphic(new ImageView(grassImgFx));
						grid.setConstraints(grass, col, row);
						grid.getChildren().add(grass);
					break;
					case 3 :
						BufferedImage flowerImg = null;
						try
						{
							flowerImg = ImageIO.read(new File("Resources/Imgs/Flower.png"));
						}
						catch (IOException e)
						{
							System.out.println("Image not found!");
						}
						Image flowerImgFx = SwingFXUtils.toFXImage(flowerImg, null);
						Label flower = new Label();
						column = col;
						rows = row;
						flower.setOnMouseClicked(e -> {
							if(axeFlag == 1)
							{
								grid.getChildren().remove(axe);
								BufferedImage axeImg = null;
								try
								{
									axeImg = ImageIO.read(new File("Resources/Imgs/Axe.png"));
								}
								catch (IOException e1)
								{
									System.out.println("Image not found!");
								}
								Image axeImgFx = SwingFXUtils.toFXImage(axeImg, null);
								axe = new Label();
								axe.setGraphic(new ImageView(axeImgFx));
								grid.setConstraints(axe, column, rows);
								grid.getChildren().add(axe);
								axeRow = grid.getRowIndex(flower);
								axeCol = grid.getColumnIndex(flower);
								try
								{
									Formatter AxeOut = new Formatter("Resources/Locations/AxeLoc.file");
									AxeOut.format(axeRow + " " + axeCol);
									AxeOut.close();
								}
								catch (Exception e2)
								{
									System.out.println("Cannot write file!");
								}
								axeFlag = 0;
							}
							else if(boatFlag == 1)
							{
								grid.getChildren().remove(boat);
								BufferedImage boatImg = null;
								try
								{
									boatImg = ImageIO.read(new File("Resources/Imgs/Boat.png"));
								}
								catch (IOException e1)
								{
									System.out.println("Image not found!");
								}
								Image boatImgFx = SwingFXUtils.toFXImage(boatImg, null);
								boat = new Label();
								boat.setGraphic(new ImageView(boatImgFx));
								grid.setConstraints(boat, column, rows);
								grid.getChildren().add(boat);
								boatRow = grid.getRowIndex(flower);
								boatCol = grid.getColumnIndex(flower);
								try
								{
									Formatter BoatOut = new Formatter("Resources/Locations/BoatLoc.file");
									BoatOut.format(boatRow + " " + boatCol);
									BoatOut.close();
								}
								catch (Exception e2)
								{
									System.out.println("Cannot write file!");
								}
								boatFlag = 0;
							}
						});
						flower.setGraphic(new ImageView(flowerImgFx));
						grid.setConstraints(flower, col, row);
						grid.getChildren().add(flower);
					break;
					case 20 :
						BufferedImage treeImg = null;
						try
						{
							treeImg = ImageIO.read(new File("Resources/Imgs/Tree.png"));
						}
						catch (IOException e)
						{
							System.out.println("Image not found!");
						}
						Image treeImgFx = SwingFXUtils.toFXImage(treeImg, null);
						Label tree = new Label();
						tree.setGraphic(new ImageView(treeImgFx));
						grid.setConstraints(tree, col, row);
						grid.getChildren().add(tree);
					break;
					case 21 :
						BufferedImage chtreeImg = null;
						try
						{
							chtreeImg = ImageIO.read(new File("Resources/Imgs/ChTree.png"));
						}
						catch (IOException e)
						{
							System.out.println("Image not found!");
						}
						Image chtreeImgFx = SwingFXUtils.toFXImage(chtreeImg, null);
						Label chtree = new Label();
						chtree.setGraphic(new ImageView(chtreeImgFx));
						grid.setConstraints(chtree, col, row);
						grid.getChildren().add(chtree);
					break;
					case 22 :
						BufferedImage waterImg = null;
						try
						{
							waterImg = ImageIO.read(new File("Resources/Imgs/Water.png"));
						}
						catch (IOException e)
						{
							System.out.println("Image not found!");
						}
						Image waterImgFx = SwingFXUtils.toFXImage(waterImg, null);
						Label water = new Label();
						water.setGraphic(new ImageView(waterImgFx));
						grid.setConstraints(water, col, row);
						grid.getChildren().add(water);
					break;
					default:
					break;
				}
				col++;
			}
			row++;
		}
		BufferedImage axeImg = null;
		try
		{
			axeImg = ImageIO.read(new File("Resources/Imgs/Axe.png"));
		}
		catch (IOException e1)
		{
			System.out.println("Image not found!");
		}
		Image axeImgFx = SwingFXUtils.toFXImage(axeImg, null);
		axe = new Label();
		axe.setGraphic(new ImageView(axeImgFx));
		grid.setConstraints(axe, axeVal[1], axeVal[0]);
		grid.getChildren().add(axe);
		
		BufferedImage boatImg = null;
		try
		{
			boatImg = ImageIO.read(new File("Resources/Imgs/Boat.png"));
		}
		catch (IOException e1)
		{
			System.out.println("Image not found!");
		}
		Image boatImgFx = SwingFXUtils.toFXImage(boatImg, null);
		boat = new Label();
		boat.setGraphic(new ImageView(boatImgFx));
		grid.setConstraints(boat, boatVal[1], boatVal[0]);
		grid.getChildren().add(boat);
	}
	
	public void SetAxeLocation()
	{
		axeFlag = 1;
	}
	
	public void SetBoatLocation()
	{
		boatFlag = 1;
	}
	
	@SuppressWarnings("static-access")
	public void AxeToDefault()
	{
		Scanner axeDef = null;
		try {
			axeDef = new Scanner(new File("Resources/Locations/DefAxeLoc.file"));
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
		
		String currentLine;
		currentLine = axeDef.nextLine();
		
		String[] values = currentLine.trim().split(" ");
		
		int[] val = new int[2];
		
		val[0] = Integer.parseInt(values[0]);
		val[1] = Integer.parseInt(values[1]);
		
		grid.getChildren().remove(axe);
		BufferedImage axeImg = null;
		try
		{
			axeImg = ImageIO.read(new File("Resources/Imgs/Axe.png"));
		}
		catch (IOException e1)
		{
			System.out.println("Image not found!");
		}
		Image axeImgFx = SwingFXUtils.toFXImage(axeImg, null);
		axe = new Label();
		axe.setGraphic(new ImageView(axeImgFx));
		grid.setConstraints(axe, val[1], val[0]);
		grid.getChildren().add(axe);
		try
		{
			Formatter AxeOut = new Formatter("Resources/Locations/AxeLoc.file");
			AxeOut.format(val[0] + " " + val[1]);
			AxeOut.close();
		}
		catch (Exception e2)
		{
			System.out.println("Cannot write file!");
		}
	}
	
	@SuppressWarnings("static-access")
	public void BoatToDefault()
	{
		Scanner boatDef = null;
		try {
			boatDef = new Scanner(new File("Resources/Locations/DefBoatLoc.file"));
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
		
		String currentLine;
		currentLine = boatDef.nextLine();
		
		String[] values = currentLine.trim().split(" ");
		
		int[] val = new int[2];
		
		val[0] = Integer.parseInt(values[0]);
		val[1] = Integer.parseInt(values[1]);
		
		grid.getChildren().remove(boat);
		BufferedImage boatImg = null;
		try
		{
			boatImg = ImageIO.read(new File("Resources/Imgs/Boat.png"));
		}
		catch (IOException e1)
		{
			System.out.println("Image not found!");
		}
		Image boatImgFx = SwingFXUtils.toFXImage(boatImg, null);
		boat = new Label();
		boat.setGraphic(new ImageView(boatImgFx));
		grid.setConstraints(boat, val[1], val[0]);
		grid.getChildren().add(boat);
		try
		{
			Formatter AxeOut = new Formatter("Resources/Locations/BoatLoc.file");
			AxeOut.format(val[0] + " " + val[1]);
			AxeOut.close();
		}
		catch (Exception e2)
		{
			System.out.println("Cannot write file!");
		}
	}
	
	public void RunDH()
	{
		Game nw = new Game();
		nw.RunGame();
	}
	
	public void ExitMapViewer()
	{
		Stage stage = (Stage) rundh.getScene().getWindow();
		stage.close();
	}
}
