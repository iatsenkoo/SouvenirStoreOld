package com.example.demo2.model;

import com.example.demo2.entities.Souvenir;

import java.util.List;

import static com.example.demo2.FileUtils.getSouvenirs;
import static com.example.demo2.FileUtils.saveSouvenir;

public class SouvenirModel {
    private static SouvenirModel souvenirModel = new SouvenirModel();
    private List<Souvenir> souvenirList;

    public SouvenirModel() {
        souvenirList = getSouvenirs();
    }

    public static SouvenirModel getInstance() {
        return souvenirModel;
    }

    public List<Souvenir> list(){
        return souvenirList;
    }

    public void add(Souvenir souvenir){
        souvenirList.add(souvenir);
        saveSouvenir(souvenirList);
    }

    public void edit(Souvenir souvenir){
        List<Souvenir> souvenirs = souvenirList.stream()
                .filter(s -> s.getId()==souvenir.getId())
                .toList();
        souvenirList.removeAll(souvenirs);
        souvenirList.add(souvenir);
        saveSouvenir(souvenirList);
    }


    public void delete(int id) {
        List<Souvenir> souvenirs = souvenirList.stream()
                .filter(s->s.getId()==id)
                .toList();
        souvenirList.removeAll(souvenirs);
        saveSouvenir(souvenirList);
    }
}
