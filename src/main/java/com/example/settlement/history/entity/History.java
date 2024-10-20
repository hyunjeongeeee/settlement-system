package com.example.settlement.history.entity;

import com.example.settlement.user.entity.User;
import com.example.settlement.video.entity.Video;
import jakarta.persistence.*;

import java.security.Timestamp;
import java.util.Date;

@Entity
@Table(name = "HISTORIES")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HISTORY_ID")
    private Long historyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VIDEO_ID")
    private Video videoId;

    @Column(name = "HISTORY_TIMESTAMP", nullable = false)
    private Timestamp historyTimestamp;

    @Column(name = "HISTORY_DATE", nullable = false)
    private Date historyDate;

}