package com.labbox.lab.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_sector")
public class Sector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sector_id")
    private Long sectorId;

    @Column(name = "sector_name")
    private String sectorName;

    @Column(name = "sector_note")
    private String note;

    @Column(name = "checked")
    private boolean checked;

    @Column(name = "date_of_checked")
    private LocalDateTime dateOfChecked;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @Column(name = "status")
    private boolean status;

    @Column(name = "create_at")
    private LocalDateTime createAt;

}
