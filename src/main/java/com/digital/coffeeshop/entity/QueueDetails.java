package com.digital.coffeeshop.entity;

import javax.persistence.*;

@Entity
@Table(name = "queue_details", schema = "coffeeshop")
public class QueueDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @Column(name = "waiting_number")
    private int waitingNumber;



}
