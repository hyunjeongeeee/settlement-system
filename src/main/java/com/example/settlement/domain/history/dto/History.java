package com.example.settlement.domain.history.dto;

import com.example.settlement.domain.user.dto.User;
import com.example.settlement.domain.vedio.dto.Video;
import jakarta.persistence.*;

import java.security.Timestamp;
import java.util.Date;

@Entity
@Table(name = "HISTORY")
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