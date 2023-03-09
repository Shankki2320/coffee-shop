package com.digital.coffeeshop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "menu", schema = "coffeeshop")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "item1")
    private String item1;

    @Column(name = "price1")
    private BigDecimal price1;

    @Column(name = "item2")
    private String item2;

    @Column(name = "price2")
    private BigDecimal price2;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "shop_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Shop shop;
}
