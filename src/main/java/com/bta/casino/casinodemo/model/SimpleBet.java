package com.bta.casino.casinodemo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "simple_bet")
public class SimpleBet implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    @Enumerated(value = EnumType.STRING)
    private SimpleResult bet;

    @Column(name = "bet_value")
    private int betValue;

    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "user_account_id", nullable = false)
    private UserAccount userAccount;
}
