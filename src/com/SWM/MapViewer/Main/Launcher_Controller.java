package com.SWM.MapViewer.Main;

import com.neet.DiamondHunter.Main.Game;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

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
}
