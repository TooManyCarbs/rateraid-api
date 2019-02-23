package com.rateraid.rateraidapi.media;

import com.rateraid.rateraidapi.core.BaseEntity;
import com.rateraid.rateraidapi.core.Reviewable;
import com.rateraid.rateraidapi.review.Review;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
@Data
@Entity
public class Game extends BaseEntity implements Reviewable {

    public enum ESRB_RATINGS {
        EC,
        E,
        E10,
        T,
        M,
        AO
    }

    protected Game(){
        super();
    }

    @NotNull
    @Size(min = 2, max = 140)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private ESRB_RATINGS esrbRating;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    private List<Review> reviews;

    public Game(String title, String description, ESRB_RATINGS esrbRating) {
        this.title = title;
        this.description = description;
        this.esrbRating = esrbRating;
    }

    @Override
    public void addReview(Review review) {
        reviews.add(review);
    }

    @Override
    public List<Review> getReviews() {
        return this.reviews;
    }
}
