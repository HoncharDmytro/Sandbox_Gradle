package com.sandbox_gradle.test_02_01.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "album")
public class Album implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false)
    protected Long id;

    @Version
    @Column(name = "version")
    private int version;

    @Column
    private String title;

    @Temporal(TemporalType.DATE)
    @Column(name = "release_date")
    private Date releaseDate;

    @ManyToOne
    @JoinColumn(name = "singer_id")
    private Singer singer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", version=" + version +
                ", title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", singer=" + singer +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return version == album.version && Objects.equals(id, album.id) && Objects.equals(title, album.title) && Objects.equals(releaseDate, album.releaseDate) && Objects.equals(singer, album.singer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version, title, releaseDate, singer);
    }
}