package com.rateraid.rateraidapi.review;

import com.rateraid.rateraidapi.core.BaseEntity;
import com.rateraid.rateraidapi.media.Book;
import com.rateraid.rateraidapi.media.Game;
import com.rateraid.rateraidapi.media.Movie;
import com.rateraid.rateraidapi.media.TvSeries;
import com.rateraid.rateraidapi.user.User;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Review extends BaseEntity {

    @ManyToOne(optional = false)
    private User reviewer;

    @ManyToOne
    private Book book;
    @ManyToOne
    private Game game;
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private TvSeries tvSeries;
    private String mainContent;
    private String summary;
    private Double rating;
    private Boolean spoilers = true;

    protected Review() {
        super();
    }

    public Review(TvSeries tvSeries, Double rating, Boolean spoilers, String mainContent, String summary) {
        this();
        this.tvSeries = tvSeries;
        this.mainContent = mainContent;
        this.summary = summary;
        this.rating = rating;
        this.spoilers = spoilers;
    }

    public Review(Book book, Double rating, Boolean spoilers, String mainContent, String summary) {
        this();
        this.book = book;
        this.mainContent = mainContent;
        this.summary = summary;
        this.rating = rating;
        this.spoilers = spoilers;
    }

    public Review(Movie movie, Double rating, Boolean spoilers, String mainContent, String summary) {
        this();
        this.movie = movie;
        this.mainContent = mainContent;
        this.summary = summary;
        this.rating = rating;
        this.spoilers = spoilers;
    }

    public Book getBook() {
        return book;
    }

    public Game getGame() {
        return game;
    }

    public Movie getMovie() {
        return movie;
    }

    public TvSeries getTvSeries() {
        return tvSeries;
    }

    public Review(Game game, Double rating, Boolean spoilers, String mainContent, String summary) {
        this();
        this.game = game;
        this.mainContent = mainContent;
        this.summary = summary;
        this.rating = rating;
        this.spoilers = spoilers;

    }

    public User getReviewer() {
        return reviewer;
    }

    public void setReviewer(User reviewer) {
        this.reviewer = reviewer;
    }

    public String getMainContent() {
        return mainContent;
    }

    public void setMainContent(String mainContent) {
        this.mainContent = mainContent;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Boolean getSpoilers() {
        return spoilers;
    }

    public void setSpoilers(Boolean spoilers) {
        this.spoilers = spoilers;
    }
}
