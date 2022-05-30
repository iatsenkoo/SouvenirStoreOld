package com.example.demo2.model;

import com.example.demo2.entities.Factory;
import java.util.List;

import static com.example.demo2.FileUtils.getFactories;
import static com.example.demo2.FileUtils.saveFactory;

public class FactoryModel {
    private static final FactoryModel model = new FactoryModel();
    private static List<Factory> listFactory;

    public static FactoryModel getInstance(){
        return model;
    }

    public void editFactory(int id,String name,String country){
        List<Factory> factories = listFactory.stream()
                .filter(s -> s.getId() == id)
                .toList();
        listFactory.removeAll(factories);
        listFactory.add(new Factory(id,name,country));
        saveFactory(listFactory);
    }

    public void deleteFactory(int id){
        List<Factory> factories = listFactory.stream()
                .filter(s -> s.getId()==id)
                .toList();
        listFactory.removeAll(factories);
        saveFactory(listFactory);
    }

    public FactoryModel() {
        listFactory = getFactories();
    }

    public void add(Factory factory){
        listFactory.add(factory);
        saveFactory(listFactory);
    }

    public List<Factory> list(){
        return listFactory;
    }
}
