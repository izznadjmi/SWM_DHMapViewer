package com.SWM.MapViewer.Main;

import com.neet.DiamondHunter.Main.Game;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Launcher_Controller {
	@FXML
	Button GameLaunch;
	
	@FXML
	Button ViewerLaunch;
	
	public void Launch_Game()
	{
		Game nw = new Game();
		nw.RunGame();
	}
	
	public Stage secondaryStage;
	
	public void Launch_Viewer()
	{
		try 
		{
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/SWM/MapViewer/ViewApp/MapViewer.fxml"));
			AnchorPane root = (AnchorPane) fxmlLoader.load();
			Scene scene = new Scene(root, 840, 665);
			secondaryStage = new Stage();
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			secondaryStage.setTitle("Map Viewer");
			secondaryStage.setScene(scene);
			secondaryStage.show();
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
}
