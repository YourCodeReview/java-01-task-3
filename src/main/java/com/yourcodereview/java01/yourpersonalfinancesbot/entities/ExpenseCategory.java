package com.yourcodereview.java01.yourpersonalfinancesbot.entities;

import javax.persistence.*;

@Entity
public class ExpenseCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private BotUser botUser;

    @Column(nullable = false, unique = true)
    private String name;

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
}
