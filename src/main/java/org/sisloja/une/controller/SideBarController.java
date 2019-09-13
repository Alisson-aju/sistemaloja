package org.sisloja.une.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;

public class SideBarController implements Initializable{
	
	@FXML
	private JFXButton btnVendas;
	
	@FXML 
	private JFXButton btnVendedores;

	@FXML 
	private JFXButton btnProdutos;

	@FXML 
	private JFXButton btnDepartamentos;

	@FXML 
	private JFXButton btnRelatorios;
	
	@FXML
	private JFXButton btnSair;
	

	private MainViewController myMainViewController;

	

	public void initialize(URL location, ResourceBundle resources) {
		
		
	}
	
	@FXML
	private void changeViewActionEvent(ActionEvent e) {
		JFXButton whoGenerated = (JFXButton) e.getSource();
		myMainViewController.changeMainPane(whoGenerated.getId());
	}

	@FXML
	private void exitActionEvent(ActionEvent e) {
		System.exit(0);
	}


	public void init(MainViewController mainViewController) {
		myMainViewController = mainViewController;
		
	}

}
