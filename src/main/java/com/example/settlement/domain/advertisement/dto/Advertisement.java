package com.example.settlement.domain.advertisement.dto;

import com.example.settlement.domain.vedio.dto.Video;
import jakarta.persistence.*;

@Entity
@Table(name = "ADVERTISEMENT")
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADVERTISEMENT_ID")
    private Long adId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VIDEO_ID")
    private Video videoId;

    @Column(name = "ADVERTISEMENT_VIEWS", nullable = false)
    private int adViews;

    @Enumerated(EnumType.STRING)
    @Column(name = "ADVERTISEMENT_TYPE", nullable = false)
    private AdType adType;

}
