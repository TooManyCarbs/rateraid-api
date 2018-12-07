package com.rateraid.api.core;

import com.rateraid.api.review.Review;

import java.util.List;

public interface Reviewable {

    public void addReview(Review review);

    public List<Review> getReviews();
}
