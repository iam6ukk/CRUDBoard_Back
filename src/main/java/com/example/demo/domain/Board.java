package com.example.demo.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "TB_BOARD")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, name = "SEQ", nullable = false)
    private Integer seq;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CONTENT")
    private String content;


    @Column(name = "REG_DT", nullable = true)
    private String reg_dt;

}