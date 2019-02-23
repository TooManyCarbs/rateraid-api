package com.rateraid.rateraidapi.media;

import com.rateraid.rateraidapi.core.BaseEntity;
import com.rateraid.rateraidapi.core.Reviewable;
import com.rateraid.rateraidapi.review.Review;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Book extends BaseEntity implements Reviewable {
    @NotNull
    @Size(min = 2, max = 140)
    private String title;

    private String author;
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Review> reviews;

    public Book(@NotNull String title, String author) {
        this();
        this.title = title;
        this.author = author;
    }

    protected Book() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public void addReview(Review review) {
        reviews.add(review);
    }

    @Override
    public List<Review> getReviews() {
        return reviews;
    }
}
