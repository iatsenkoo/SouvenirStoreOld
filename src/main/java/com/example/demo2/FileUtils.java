package com.example.demo2;

import com.example.demo2.entities.Factory;
import com.example.demo2.entities.Souvenir;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static List<Souvenir> getSouvenirs(){
        ObjectInputStream objectInputStream;
        List<Souvenir> souvenirList = new ArrayList<>();
        Object obj;
        try {
            objectInputStream = new ObjectInputStream(Files.newInputStream(Paths.get("C:/dev/souvenir.txt")));
        } catch (EOFException e){
            return souvenirList;
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            obj = objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if(obj instanceof ArrayList<?>){
            return (ArrayList<Souvenir>) obj;
        }
        return souvenirList;
    }
    public static List<Factory> getFactories() {
        ObjectInputStream objectInputStream;
        List<Factory> factories = new ArrayList<>();
        try {
            objectInputStream = new ObjectInputStream(Files.newInputStream(Paths.get("C:/dev/factory.txt")));
        } catch (EOFException e){
            return factories;
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        Object obj;
        try {
            obj = objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if(obj instanceof ArrayList<?>){
            factories = (ArrayList<Factory>) obj;
        }

        return factories;
    }

    public static void saveFactory(List<Factory> factories) {
        ObjectOutputStream objectOutputStream;
        try {
            objectOutputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get("C:/dev/factory.txt")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            objectOutputStream.writeObject(factories);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void saveSouvenir(List<Souvenir> souvenirs){
        ObjectOutputStream objectOutputStream;
        try {
            objectOutputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get("C:/dev/souvenir.txt")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            objectOutputStream.writeObject(souvenirs);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
