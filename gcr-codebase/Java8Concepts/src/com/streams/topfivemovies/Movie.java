package com.streams.topfivemovies;

public class Movie {
    private String title;
    private int releaseYear;
    private double rating; // out of 10.0
    private int votes; // number of votes

    // constructor
    public Movie(String title, int releaseYear, double rating, int votes) {
	this.title = title;
	this.releaseYear = releaseYear;
	this.rating = rating;
	this.votes = votes;
    }

    // getters
    public String getTitle() {
	return title;
    }

    public int getReleaseYear() {
	return releaseYear;
    }

    public double getRating() {
	return rating;
    }

    public int getVotes() {
	return votes;
    }

    // good string representation
    @Override
    public String toString() {
	return String.format("%-35s | Year: %d | Rating: %.1f (%d votes)", title, releaseYear, rating, votes);
    }
}