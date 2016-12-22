package com.SWM.MapViewer.ViewApp.About;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class About_Controller implements Initializable{

	@FXML
	AnchorPane ImagePane;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Image dhImg = new Image(this.getClass().getResourceAsStream("/Imgs/DH.png"));
		ImageView imgV = new ImageView(dhImg);
		imgV.setFitHeight(100);
		imgV.setFitWidth(100);
		imgV.setPreserveRatio(true);
		ImagePane.getChildren().add(imgV);
	}

}
