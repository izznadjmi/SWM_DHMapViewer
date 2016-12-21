package com.SWM.MapViewer.ViewApp;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.ResourceBundle;
import javax.imageio.ImageIO;

import com.SWM.MapViewer.SwingMapView.FileRead;
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

public class Viewer_Controller implements Initializable{
	@FXML
	AnchorPane base;
	
	@FXML
	MenuItem ExitMenu;
	
	@FXML
	GridPane grid;
	
	@FXML
	Button setaxeloc;
	
	@FXML
	Button setboatloc;
	
	@FXML
	Button rundh;
	
	static Label axe, boat;
	static int axeFlag = 0, boatFlag = 0;
	public int axeRow = 1, axeCol = 1;
	public int boatRow = 1, boatCol = 1;
	ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
	
	public Viewer_Controller()
	{
		
	}
	
	@SuppressWarnings("static-access")
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle)
	{
		FileRead fr = new FileRead();
		fr.GetLines();
		this.arr = fr.arr;
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
	}
	
	public void SetAxeLocation()
	{
		axeFlag = 1;
		boatFlag = 0;
	}
	
	public void SetBoatLocation()
	{
		boatFlag = 1;
		axeFlag = 0;
	}
	
	public void OutFile()
	{
		try
		{
			Formatter outputFile = new Formatter("Resources/Locations/AxeBoatPosition.file");
			outputFile.format("0 " + axeRow + " " + axeCol + "%n");
    		outputFile.format("1 " + boatRow + " " + boatCol);
    		outputFile.close();
		}
		catch (Exception e)
		{
			System.out.println("Cannot produce output file");
		}
	}
}
