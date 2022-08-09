package com.volodymyrbaranivskyi.test_shop.model.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "products", schema = "shop_eva")
@NoArgsConstructor
@AllArgsConstructor
public class Products {

    @Id
    @Column(name="id")
    @GeneratedValue(generator="product_id_sequence",strategy=GenerationType.SEQUENCE)
    @SequenceGenerator(name="product_id_sequence",sequenceName="shop_eva.product_id_sequence")
    private int id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    public Products(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
