package com.rateraid.rateraidapi.core;

import com.rateraid.rateraidapi.review.Review;

import java.util.List;

public interface Reviewable {

    public void addReview(Review review);

    public List<Review> getReviews();
}
