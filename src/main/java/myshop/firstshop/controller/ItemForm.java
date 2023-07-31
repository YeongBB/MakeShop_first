package myshop.firstshop.controller;

import lombok.Getter;

@Getter
public class ItemForm {

    private Long id;
    private String name;
    private int price;
    private int quantity;

    public ItemForm() {
    }

    public ItemForm(Long id, String name, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
