package com.SWM.MapViewer.ViewApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import com.neet.DiamondHunter.Main.Game;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
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
	public static int axeRow = 26, axeCol = 37;
	public static int boatRow = 12, boatCol = 4;
	ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
	
	public Viewer_Controller()
	{
		
	}
	
	public ArrayList<ArrayList<Integer>> GetLines()
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
			System.out.println("Can't read from file or file not found!");
		}
		
		return arr;
	}
	
	@SuppressWarnings("static-access")
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle)
	{
		Viewer_Controller nw = new Viewer_Controller();
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
						Image pathImgFx = new Image(this.getClass().getResourceAsStream("/Imgs/Path.png"));
						Label path = new Label();
						int column = col, rows = row;
						path.setOnMouseClicked(e -> {
							if(axeFlag == 1)
							{
								grid.getChildren().remove(axe);
								Image axeImgFx =  new Image(this.getClass().getResourceAsStream("/Imgs/Axe.png"));
								axe = new Label();
								axe.setGraphic(new ImageView(axeImgFx));
								grid.setConstraints(axe, column, rows);
								grid.getChildren().add(axe);
								axeRow = grid.getRowIndex(path);
								axeCol = grid.getColumnIndex(path);
								axeFlag = 0;
							}
							else if(boatFlag == 1)
							{
								grid.getChildren().remove(boat);
								Image boatImgFx = new Image(this.getClass().getResourceAsStream("/Imgs/Boat.png"));
								boat = new Label();
								boat.setGraphic(new ImageView(boatImgFx));
								grid.setConstraints(boat, column, rows);
								grid.getChildren().add(boat);
								boatRow = grid.getRowIndex(path);
								boatCol = grid.getColumnIndex(path);
								boatFlag = 0;
							}
						});
						path.setGraphic(new ImageView(pathImgFx));
						grid.setConstraints(path, col, row);
						grid.getChildren().add(path);
					break;
					case 2 :
						Image grassImgFx = new Image(this.getClass().getResourceAsStream("/Imgs/Grass.png"));
						Label grass = new Label();
						column = col;
						rows = row;
						grass.setOnMouseClicked(e -> {
							if(axeFlag == 1)
							{
								grid.getChildren().remove(axe);
								Image axeImgFx = new Image(this.getClass().getResourceAsStream("/Imgs/Axe.png"));
								axe = new Label();
								axe.setGraphic(new ImageView(axeImgFx));
								grid.setConstraints(axe, column, rows);
								grid.getChildren().add(axe);
								axeRow = grid.getRowIndex(grass);
								axeCol = grid.getColumnIndex(grass);
								axeFlag = 0;
							}
							else if(boatFlag == 1)
							{
								grid.getChildren().remove(boat);
								Image boatImgFx = new Image(this.getClass().getResourceAsStream("/Imgs/Boat.png"));
								boat = new Label();
								boat.setGraphic(new ImageView(boatImgFx));
								grid.setConstraints(boat, column, rows);
								grid.getChildren().add(boat);
								boatRow = grid.getRowIndex(grass);
								boatCol = grid.getColumnIndex(grass);
								boatFlag = 0;
							}
						});
						grass.setGraphic(new ImageView(grassImgFx));
						grid.setConstraints(grass, col, row);
						grid.getChildren().add(grass);
					break;
					case 3 :
						Image flowerImgFx = new Image(this.getClass().getResourceAsStream("/Imgs/Flower.png"));
						Label flower = new Label();
						column = col;
						rows = row;
						flower.setOnMouseClicked(e -> {
							if(axeFlag == 1)
							{
								grid.getChildren().remove(axe);
								Image axeImgFx = new Image(this.getClass().getResourceAsStream("/Imgs/Axe.png"));
								axe = new Label();
								axe.setGraphic(new ImageView(axeImgFx));
								grid.setConstraints(axe, column, rows);
								grid.getChildren().add(axe);
								axeRow = grid.getRowIndex(flower);
								axeCol = grid.getColumnIndex(flower);
								axeFlag = 0;
							}
							else if(boatFlag == 1)
							{
								grid.getChildren().remove(boat);
								Image boatImgFx = new Image(this.getClass().getResourceAsStream("/Imgs/Boat.png"));
								boat = new Label();
								boat.setGraphic(new ImageView(boatImgFx));
								grid.setConstraints(boat, column, rows);
								grid.getChildren().add(boat);
								boatRow = grid.getRowIndex(flower);
								boatCol = grid.getColumnIndex(flower);
								boatFlag = 0;
							}
						});
						flower.setGraphic(new ImageView(flowerImgFx));
						grid.setConstraints(flower, col, row);
						grid.getChildren().add(flower);
					break;
					case 20 :
						Image treeImgFx = new Image(this.getClass().getResourceAsStream("/Imgs/Tree.png"));
						Label tree = new Label();
						tree.setGraphic(new ImageView(treeImgFx));
						grid.setConstraints(tree, col, row);
						grid.getChildren().add(tree);
					break;
					case 21 :
						Image chtreeImgFx = new Image(this.getClass().getResourceAsStream("/Imgs/ChTree.png"));
						Label chtree = new Label();
						chtree.setGraphic(new ImageView(chtreeImgFx));
						grid.setConstraints(chtree, col, row);
						grid.getChildren().add(chtree);
					break;
					case 22 :
						Image waterImgFx = new Image(this.getClass().getResourceAsStream("/Imgs/Water.png"));
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
		Image axeImgFx = new Image(this.getClass().getResourceAsStream("/Imgs/Axe.png"));
		axe = new Label();
		axe.setGraphic(new ImageView(axeImgFx));
		grid.setConstraints(axe, axeCol, axeRow);
		grid.getChildren().add(axe);
		
		Image boatImgFx = new Image(this.getClass().getResourceAsStream("/Imgs/Boat.png"));
		boat = new Label();
		boat.setGraphic(new ImageView(boatImgFx));
		grid.setConstraints(boat, boatCol, boatRow);
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
		axeCol = 37;
		axeRow = 26;
		
		grid.getChildren().remove(axe);
		Image axeImgFx = new Image(this.getClass().getResourceAsStream("/Imgs/Axe.png"));
		axe = new Label();
		axe.setGraphic(new ImageView(axeImgFx));
		grid.setConstraints(axe, axeCol, axeRow);
		grid.getChildren().add(axe);
	}
	
	@SuppressWarnings("static-access")
	public void BoatToDefault()
	{
		
		boatCol = 4;
		boatRow = 12;
		
		grid.getChildren().remove(boat);
		Image boatImgFx = new Image(this.getClass().getResourceAsStream("/Imgs/Boat.png"));
		boat = new Label();
		boat.setGraphic(new ImageView(boatImgFx));
		grid.setConstraints(boat, boatCol, boatRow);
		grid.getChildren().add(boat);
	}
	
	public void RunDH()
	{
		Game nw = new Game();
		nw.RunGame();
	}
	
	public void AboutMapViewer()
	{
		try 
		{
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/SWM/MapViewer/ViewApp/About/About.fxml"));
			AnchorPane root = (AnchorPane) fxmlLoader.load();
			Scene scene = new Scene(root, 320, 500);
			Stage helpStage = new Stage();
			helpStage.getIcons().add(new Image(this.getClass().getResourceAsStream("/Imgs/DH.png")));
			helpStage.setTitle("About Map");
			helpStage.setResizable(false);
			helpStage.setScene(scene);
			helpStage.show();
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void ExitMapViewer()
	{
		Stage stage = (Stage) rundh.getScene().getWindow();
		stage.close();
	}
}
