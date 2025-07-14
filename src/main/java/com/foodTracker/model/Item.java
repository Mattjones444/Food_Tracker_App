package com.foodTracker.model;
import jakarta.persistence.*;
import com.foodTracker.Type;
import java.time.LocalDate;


@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //Many user items can belong to one user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable=false)
    private User user;

    //Many users can link to one item
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "item_id", nullable=false)
    private Item item;

    @Column(nullable=false, unique=true)
    private String name;

    @Column(nullable=false, unique=false)
    private int quantity;

    @Column(nullable=false, unique=false)
    private boolean finished;

    @Column(nullable=false, unique=false)
    private Type type;

    @Column(nullable=false, unique=false)
    private LocalDate lastBought;

    public Item(){}

    public Item(long id, User user, Item item, String name, int quantity, boolean finished, Type type,
            LocalDate lastBought) {
        this.id = id;
        this.user = user;
        this.item = item;
        this.name = name;
        this.quantity = quantity;
        this.finished = finished;
        this.type = type;
        this.lastBought = lastBought;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
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

    public LocalDate getLastBought() {
        return lastBought;
    }

    public void setLastBought(LocalDate lastBought) {
        this.lastBought = lastBought;
    }

}
