package com.example.settlement.domain.settlement.dto;

import com.example.settlement.domain.user.dto.User;
import com.example.settlement.domain.vedio.dto.Video;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "SETTLEMENT")
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
