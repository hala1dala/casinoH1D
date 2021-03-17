package com.bta.casino.casinodemo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@ToString
@Entity
@Table(name = "simple_game_result")
public class SimpleGameResult implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    @Enumerated(value = EnumType.STRING)
    private SimpleResult result;

    @Column(name = "date_time")
    private LocalDateTime dateTime;
}
