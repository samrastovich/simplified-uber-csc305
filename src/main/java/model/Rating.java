package model;

public class Rating {
	
	private int rating;
	private String review;
	
	public Rating(int rating) {
		if (validateRating(rating)) {
			this.rating = rating;
		} else {
			throw new IllegalArgumentException("Rating can only be 1-5");
		}
	}
	
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		if (validateRating(rating))
			this.rating = rating;
		else 
			throw new IllegalArgumentException("Rating can only be 1-5");
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	
	private boolean validateRating(int rating) {
		boolean res = true;
		if (rating > 5 || rating < 1) {
			res = false;
		}
		return res;
	}
	
}
