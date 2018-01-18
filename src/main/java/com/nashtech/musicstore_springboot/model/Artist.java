package com.nashtech.musicstore_springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "artist", schema = "musicstore")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ArtistID", nullable = false)
    private Integer artistId;

    @Column(name = "ArtistName", nullable = false)
    private String name;

    @Column(name = "CreatedAt", nullable = false)
    private Timestamp createdAt;

    @Column(name = "ModifiedAt", nullable = false)
    private Timestamp modifiedAt;

    @JsonIgnore
    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
    private List<Album> albums;

    public Artist() {
    }

    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Timestamp modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }
}
