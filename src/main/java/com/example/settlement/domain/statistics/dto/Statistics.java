package com.example.settlement.domain.statistics.dto;

import com.example.settlement.domain.vedio.dto.Video;
import jakarta.persistence.*;

import java.security.Timestamp;

@Entity
@Table(name = "STATISTICS")
public class Statistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STATISTICS_ID")
    private Long statId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VIDEO_ID")
    private Video videoId;

    @Column(name = "STATISTICS_AD_REVENUE", nullable = false)
    private int statAdRevenue;

    @Column(name = "STATISTICS_VIEW_REVNUE", nullable = false)
    private int statViewRevenue;

    @Column(name = "STATISTICS_PLAY_TIME", nullable = false)
    private int statPlayTime;

    @Column(name = "STATISTICS_DATE", nullable = false)
    private Timestamp statDate;

}
