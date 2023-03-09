package com.digital.coffeeshop.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders", schema = "coffeeshop")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "items")
    private int numberOfItems;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "order_date_time")
    private LocalDateTime localDateTime;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    private Shop shop;

}
