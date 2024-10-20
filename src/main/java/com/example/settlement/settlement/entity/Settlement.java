package com.example.settlement.settlement.entity;

import com.example.settlement.user.entity.User;
import com.example.settlement.video.entity.Video;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "SETTLEMENTS")
public class Settlement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SETTLEMENT_ID")
    private Long settlementId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VIDEO_ID")
    private Video videoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User userId;

    @Column(name = "SETTLEMENT_TOTAL_REVENUE", nullable = false)
    private int settlementTotalRevenue;

    @Column(name = "SETTLEMENT_DATE", nullable = false)
    private Date settlementDate;

}
