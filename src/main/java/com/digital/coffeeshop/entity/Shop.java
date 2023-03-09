package com.digital.coffeeshop.entity;

import javax.persistence.*;

/**
 * @author Shankar Katkade
 * @since 10/03/2023
 * @version 1.0
 */

@Entity
@Table(name = "shop", schema = "coffeeshop")
public class Shop{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "shop_name")
    private String shopName;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zipcode")
    private String zipcode;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "queue_size")
    private int queueSize;

    @Column(name = "max_queue_size")
    private int maxQueueSize;


}
