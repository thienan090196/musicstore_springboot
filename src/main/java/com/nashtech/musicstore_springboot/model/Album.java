package com.nashtech.musicstore_springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.multipart.MultipartFile;
import javax.persistence.*;
import javax.validation.GroupSequence;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "album", schema = "musicstore")
@GroupSequence({GroupSequenceOrder.class, Album.class})
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AlbumID", nullable = false)
    private Integer albumId;

    @Column(name = "GenreID", insertable = false, updatable = false)
    private Integer genreId;

    @ManyToOne
    @JoinColumn(name = "GenreID", nullable = false)
    private Genre genre;

    @Column(name = "ArtistID", insertable = false, updatable = false)
    private Integer artistId;

    @ManyToOne
    @JoinColumn(name = "ArtistID", nullable = false)
    private Artist artist;

    @NotBlank(message = "Title is required!", groups = GroupSequenceOrder.First.class)
    @Size(min = 6, max = 255, message = "Title must be between {2} and {1} characters!", groups = GroupSequenceOrder.Second.class)
    @Pattern(message = "Only letters, numbers and whitespace are accepted!", regexp = "^[A-Za-z0-9 ]+$", groups = GroupSequenceOrder.Third.class)
    @Column(name = "Title", nullable = false)
    private String title;

    @NotNull(message = "Price is required!", groups = GroupSequenceOrder.First.class)
    @DecimalMin(value = "0.01", message = "Price must be greater then {1}", groups = GroupSequenceOrder.Second.class)
    @Column(name = "Price", nullable = false)
    private BigDecimal price;

    @Column(name = "ImagePath", nullable = false)
    private String imagePath;

    @Column(name = "CreatedAt", nullable = false)
    private Timestamp createdAt;

    @Column(name = "ModifiedAt", nullable = false)
    private Timestamp modifiedAt;

    @JsonIgnore
    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;

    @Transient
    private int quantity;

    public Album() {
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public Integer getGenreId() {
        return genreId;
    }

    public void setGenreId(Integer genreId) {
        this.genreId = genreId;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
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

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}