package com.labbox.lab.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long roomId;

    @Column(name = "room_name")
    private String roomName;

    @Column(name = "room_note")
    private String note;

    @Column(name = "checked")
    private boolean checked;

    @Column(name = "date_of_checked")
    private LocalDateTime dateOfChecked;

    @ManyToOne
    @JoinColumn(name = "sector_id",nullable = false)
    private Sector sector;

    @Column(name = "status")
    private boolean status;

    @Column(name = "create_at")
    private LocalDateTime createAt;

}
