package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;





public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void checkValid(String first, String second, String third)
    {
        if (!first.matches("[0-9]")) throw new IllegalArgumentException("Первая сторона не валидна");
        if (!second.matches("[0-9]")) throw new IllegalArgumentException("Вторая сторона не валидна");
        if (!third.matches("[0-9]")) throw new IllegalArgumentException("Третья сторона не валидна");
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setResizable(false);
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 400, 150);
        VBox mainBox = new VBox();
        mainBox.setPadding(new Insets(0,25, 15,15));
        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(5));
        gridpane.setHgap(3);
        gridpane.setVgap(3);

        Label label = new Label("Сторона 1");
        gridpane.add(label, 0, 0);
        TextField firstTextField = new TextField();
        firstTextField.setMinWidth(300);
        gridpane.add(firstTextField, 1, 0);
        label = new Label("Сторона 2");
        gridpane.add(label, 0, 1);
        TextField secondTextField = new TextField();
        gridpane.add(secondTextField, 1, 1);
        label = new Label("Сторона 3");
        gridpane.add(label, 0, 2);
        TextField thirdTextField = new TextField();
        gridpane.add(thirdTextField, 1, 2);
        mainBox.getChildren().add(gridpane);

        HBox resultBox = new HBox();
        resultBox.setPadding(new Insets(35, 0, 0, 0));
        HBox squareBox = new HBox();
        squareBox.setPadding(new Insets(0, 120, 0, 0));
        Button squareButton = new Button("Площадь");
        squareButton.setMinWidth(100);
        squareButton.setMaxHeight(5);
        Label squareLabel = new Label();
        squareBox.getChildren().add(squareButton);
        squareBox.getChildren().add(squareLabel);
        HBox perimeterBox = new HBox();
        Button perimeterButton = new Button("Периметр");
        perimeterButton.setMinWidth(100);
        perimeterButton.setMaxHeight(5);
        Label perimeterLabel = new Label();
        perimeterBox.getChildren().add(perimeterButton);
        perimeterBox.getChildren().add(perimeterLabel);
        squareButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                try {
                    String firstString = firstTextField.getText();
                    String secondString = secondTextField.getText();
                    String thirdString = thirdTextField.getText();
                    checkValid(firstString, secondString, thirdString);
                    Integer first, second, third;
                    first = Integer.parseInt(firstString);
                    second = Integer.parseInt(secondString);
                    third = Integer.parseInt(thirdString);
                    Integer p = (first + second + third) / 2;
                    squareLabel.setText(" " + Long.toString(Math.round(Math.sqrt(p * (p - first) * (p - second) * (p - third)))));
                }
                catch (IllegalArgumentException ex)
                {
                    JOptionPane.showMessageDialog(new Frame(),ex.getMessage());
                }

            }
        });
        perimeterButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                try {
                    String firstString = firstTextField.getText();
                    String secondString = firstTextField.getText();
                    String thirdString = firstTextField.getText();
                    checkValid(firstString, secondString, thirdString);
                    Integer first, second, third;
                    first = Integer.parseInt(firstString);
                    second = Integer.parseInt(secondString);
                    third = Integer.parseInt(thirdString);
                    perimeterLabel.setText(" " + Integer.toString(first + second + third));
                }
                catch(IllegalArgumentException ex)
                {
                    JOptionPane.showMessageDialog(new Frame(),ex.getMessage());
                }
            }
        });
        resultBox.getChildren().add(squareBox);
        resultBox.getChildren().add(perimeterBox);
        mainBox.getChildren().add(resultBox);
        root.setCenter(mainBox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}