package com.belajarspringboot.resto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;
    @Column(name = "bayar", columnDefinition = "float")
    private float bayar;

    @Column(name="disc", columnDefinition = "float")
    private float disc;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            joinColumns = {@JoinColumn(name = "noCart")},
            inverseJoinColumns= {@JoinColumn(name = "noCartItem")}
    )
    private Set<CartItem> cartItems = new HashSet<>();
    @Column(name="status")
    private boolean status=false;

    @ManyToOne
    @JoinColumn(name = "no_user")
    private User user;
    public Cart() {
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public float getBayar() {
        return bayar;
    }

    public void setBayar(float bayar) {
        this.bayar = bayar;
    }

    public float getDisc() {
        return disc;
    }

    public void setDisc(float disc) {
        this.disc = disc;
    }

    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Set<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addCartItem(CartItem cartItem){
        this.cartItems.add(cartItem);
        cartItem.getCart().add(this);
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
