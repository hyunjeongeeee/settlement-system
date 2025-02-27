package com.example.settlement.video.entity;

import com.example.settlement.user.entity.User;
import jakarta.persistence.*;


import java.security.Timestamp;


@Entity
@Table(name = "VIDEOS")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VIDEO_ID")
    private Long videoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User userId;

    @Column(name = "VIDEO_VIEWS", nullable = false)
    private int videoViews;

    @Column(name = "VIDEO_TITLE", nullable = false, length = 100)
    private String videoTitle;

    @Column(name = "VIDEO_PLAY_TIME", nullable = true)
    private Timestamp videoPlayTime;

    @Column(name = "VIDEO_UPLOAD_DATE", nullable = true)
    private Timestamp videoUploadDate;

}