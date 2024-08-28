package com.example.movies.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.example.movies.Movies;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	public Review createReview(String reviewBody, String imdbId) {
		Review review = reviewRepository.save(new Review(reviewBody));

			mongoTemplate.update(Movies.class)
			.matching(Criteria.where("imdbId").is(imdbId))
				.apply(new Update().push("reviewIds").value(review))
				.first();
			
			return review;
		}
}