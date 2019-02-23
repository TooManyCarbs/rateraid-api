package com.rateraid.rateraidapi.media;

import com.rateraid.rateraidapi.core.BaseEntity;
import com.rateraid.rateraidapi.core.Reviewable;
import com.rateraid.rateraidapi.review.Review;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Movie extends BaseEntity implements Reviewable {

    private String title;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Review> reviews;

    public Movie(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void addReview(Review review) {
        this.reviews.add(review);
    }

    @Override
    public List<Review> getReviews() {
        return this.reviews;
    }
}
