package com.yourcodereview.java01.yourpersonalfinancesbot.entities;

import javax.persistence.*;

@Entity
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private BotUser botUser;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private long currencyAmount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BotUser getBotUser() {
        return botUser;
    }

    public void setBotUser(BotUser botUser) {
        this.botUser = botUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCurrencyAmount() {
        return currencyAmount;
    }

    public void setCurrencyAmount(long currencyAmount) {
        this.currencyAmount = currencyAmount;
    }
}
