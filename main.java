package main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.io.File;
import javafx.geometry.Pos;
import main.Convert;

/**
 *
 * @author Turlu
 */
public class main extends Application {
    
    private static File[] filePaths;
    private static File destination;
    private static boolean areFilesSet=false;
    private static boolean isDestinationSet=false;
    @Override
    public void start(Stage primaryStage) {
        
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        
        Button selectDirectory = new Button("Select Your Files");
        selectDirectory.setOnAction(e->{
            //i want to be able to put a list of files
            JFileChooser chose=new JFileChooser();
            chose.setMultiSelectionEnabled(true);
            chose.setDialogTitle("Choose files to convert to MP3");
            chose.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int r=chose.showOpenDialog(new JFrame());
            if(r == chose.APPROVE_OPTION){
                filePaths= chose.getSelectedFiles();
            }
        });
        
        Button selectDestination = new Button("Select Destination");
        selectDestination.setOnAction(e->{
            //i want to be able to put a list of files
            JFileChooser chose=new JFileChooser();
            chose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chose.setDialogTitle("Choose the Destination of the Converted Files");
            int r=chose.showOpenDialog(new JFrame());
            if(r == chose.APPROVE_OPTION){
                destination = chose.getSelectedFile();
            }
        });
        
        Button convert = new Button("Convert files to MP3");
        convert.setOnAction(e->{
            
            for(int i=0;i<filePaths.length;i++){
                String[] nameFile = filePaths[i].getAbsolutePath().split("\\\\");
                /*for(int j=0;j<nameFile.length;j++)
                    System.out.println(nameFile[j]);*/
                String[] removeExtension = nameFile[nameFile.length-1].split("\\.");
                /*for(int j=0;j<removeExtension.length;j++)
                    System.out.println(removeExtension[j]);*/
                File destinationOfficial = new File(destination.getAbsolutePath()+"\\"+removeExtension[0]+".mp3");
                System.out.println(destinationOfficial.getAbsolutePath());
                Convert.convertMp4ToMp3(filePaths[i], destinationOfficial);
            }
            System.out.println("DONE!");
        });
        
        root.getChildren().addAll(selectDirectory, selectDestination, convert);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("MP4 to MP3");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
