package org.sisloja.une.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.sisloja.une.gui.util.Alerts;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class MainViewController implements Initializable {

	@FXML
	private AnchorPane anchorPane;

	@FXML
	private Pane backPane;

	@FXML
	private JFXDrawer drawer;

	@FXML
	private JFXHamburger hamburger;

	private SideBarController sideBar;

	public void initialize(URL location, ResourceBundle resources) {

		// loads and sets SideBar to the drawer
		Parent node = null;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/SideBar.fxml"));
			node = loader.load();
			sideBar = loader.getController();
			// warns side bar controller to pick this main view
			sideBar.init(this);

		} catch (IOException ex) {
			Alerts.showAlert("IO Exception", "Error loading view", ex.getMessage(), AlertType.ERROR);
		}
		VBox box = (VBox) node;
		drawer.setSidePane(box);

		//
		final HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hamburger);
		transition.setRate(-1);
		hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				transition.setRate(transition.getRate() * -1);
				transition.play();

				if (drawer.isOpened()) {
					drawer.close();
				} else {
					drawer.open();
				}
			}
		});

	}

	//Changes views according to option from sidebar
	public void changeMainPane(String sourceId) {

		if(sourceId.equals("btnDepartamentos")) {
			AnchorPane newPane =  load("/fxml/DepartamentosView.fxml");
			//Group view = new Group(new JFXButton("HI"), new Label("ola"));
			
			backPane.getChildren().setAll(newPane);
			
		}
		if(sourceId.equals("btnProdutos")) {
			AnchorPane newPane =  load("/fxml/ProdutosView.fxml");
			//Group view = new Group(new JFXButton("HI"), new Label("ola"));
			
			backPane.getChildren().setAll(newPane);
			
		}
		
	}
	
	private AnchorPane load(String location) {
		AnchorPane node = null;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(location));
			node = loader.load();

		} catch (IOException ex) {
			Alerts.showAlert("IO Exception", "Error loading view", ex.getMessage(), AlertType.ERROR);
			System.out.println(ex.getMessage());
			ex.printStackTrace();
			
		}
		
		return node;
	}





}
