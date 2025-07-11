package com.foodTracker;

import java.time.LocalDate;

public class Item {

    private int id;
    private String name;
    private int quantity;
    private boolean finished;
    private Type type;
    private LocalDate lastBought;

    public Item(){

    }

    public Item(int id, String name, int quantity, boolean finished, Type type) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.finished = finished;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }


    
}
