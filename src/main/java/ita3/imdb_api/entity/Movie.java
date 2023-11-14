package ita3.imdb_api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int year;
    private int length;
    private String title;
    private String subject;
    private int popularity;
    private boolean awards;

    public Movie() {
    }

    public Movie(int year, int length, String title, String subject, int popularity, boolean awards) {
        this.year = year;
        this.length = length;
        this.title = title;
        this.subject = subject;
        this.popularity = popularity;
        this.awards = awards;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public boolean isAwards() {
        return awards;
    }

    public void setAwards(boolean awards) {
        this.awards = awards;
    }
}
