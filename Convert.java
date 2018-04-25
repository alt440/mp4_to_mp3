package main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.sun.org.apache.bcel.internal.Repository;
import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.EncodingAttributes;
import java.util.Scanner;
import java.io.File;
/**
 *
 * @author Turlu
 */
public class Convert {
    
    public static void main(String[] args){
        
        Encoder forMusic = new Encoder();

        EncodingAttributes specifications = new EncodingAttributes();
        specifications.setFormat("mp3");
        //audioAttribute obj
        AudioAttributes a = new AudioAttributes();
        a.setVolume(256);//default
        a.setCodec("mp2");

        specifications.setAudioAttributes(a);
        
        try{
            forMusic.encode(new File("C:\\Users\\Turlu\\Downloads\\talking goat yeah.mp4"), new File("C:\\Users\\Turlu\\Downloads\\mp3OfGoat.mp3"), specifications);
        }
        catch(EncoderException ex){
            ex.printStackTrace();
        }
    }
    
    public static void convertMp4ToMp3(File source, File output){
        Encoder forMusic = new Encoder();

        EncodingAttributes specifications = new EncodingAttributes();
        specifications.setFormat("mp3");
        //audioAttribute obj
        AudioAttributes a = new AudioAttributes();
        a.setVolume(256);//default
        a.setCodec("mp2");

        specifications.setAudioAttributes(a);
        
        try{
            forMusic.encode(source, output, specifications);
        }
        catch(EncoderException ex){
            ex.printStackTrace();
        }
    }
}
