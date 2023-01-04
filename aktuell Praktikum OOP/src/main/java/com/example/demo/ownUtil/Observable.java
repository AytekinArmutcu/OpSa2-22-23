package com.example.demo.ownUtil;

public interface Observable {

    public void addObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObserver();
}
