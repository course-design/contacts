package cxw.java.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CXWMainApp extends Application {

	@Override
	public void start ( Stage primaryStage ) throws Exception {
		Parent root = FXMLLoader.load ( getClass ().getResource ( "/cxw/resources/xml/main.fxml" ) );
		primaryStage.setTitle ( "Preview" );
		primaryStage.setScene ( new Scene ( root, 800, 494 ) );
		primaryStage.setResizable ( true );
		primaryStage.show ();
	}

	public static void main ( String[] args ) {
		launch ( args );
	}
}
