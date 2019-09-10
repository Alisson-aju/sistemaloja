package org.sisloja.une.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.sisloja.une.gui.util.Alerts;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class MainViewController implements Initializable{

    @FXML
    private JFXDrawer drawer;

    @FXML
    private JFXHamburger hamburger;

	public void initialize(URL location, ResourceBundle resources) {
		
		
		VBox box = (VBox) loadNode("/fxml/SideBar.fxml");
		drawer.setSidePane(box);
		
		//sidebar nodes
		for(Node node: box.getChildren()) {
			
		}
		
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
	
	private Parent loadNode(String absolutePath) {
		Parent node = null;
		try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(absolutePath));
            node = loader.load();

        } catch (IOException ex) {
        	Alerts.showAlert("IO Exception", "Error loading view", ex.getMessage(), AlertType.ERROR);
        }
		
		return node;
	}

}

