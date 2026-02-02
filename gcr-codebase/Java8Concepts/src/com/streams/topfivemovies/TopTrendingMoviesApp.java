package com.streams.topfivemovies;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TopTrendingMoviesApp {
    public static void main(String[] args) {
        // sample large movie list (as if from database/API)
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Oppenheimer", 2023, 8.4, 620000));
        movies.add(new Movie("Dune: Part Two", 2024, 8.6, 480000));
        movies.add(new Movie("Barbie", 2023, 6.8, 520000));
        movies.add(new Movie("Poor Things", 2023, 7.9, 210000));
        movies.add(new Movie("The Holdovers", 2023, 7.9, 180000));
        movies.add(new Movie("Killers of the Flower Moon", 2023, 7.6, 190000));
        movies.add(new Movie("Inception", 2010, 8.8, 2500000));
        movies.add(new Movie("The Shawshank Redemption", 1994, 9.3, 2800000));
        movies.add(new Movie("Interstellar", 2014, 8.7, 2100000));
        movies.add(new Movie("Parasite", 2019, 8.5, 950000));
        movies.add(new Movie("Everything Everywhere All at Once", 2022, 7.8, 650000));
        movies.add(new Movie("Top Gun: Maverick", 2022, 8.2, 720000));
        movies.add(new Movie("Avatar: The Way of Water", 2022, 7.6, 480000));
        movies.add(new Movie("Joker", 2019, 8.4, 1500000));
        movies.add(new Movie("Avengers: Endgame", 2019, 8.4, 1300000));

        System.out.println("Top 5 Trending Movies (Stream API Demo)");
        System.out.println("Criteria: Highest rating first, then most recent year");
        System.out.println("Only considering movies from 2019 onwards for trending");
        System.out.println("-------------------------------------------------------------");

        // Stream pipeline: filter recent -> sort (rating desc, year desc) -> limit 5
        movies.stream()
                .filter(m -> m.getReleaseYear() >= 2019) // recent movies
                .sorted(Comparator.comparingDouble(Movie::getRating) // highest rating first
                        .reversed()
                        .thenComparingInt(Movie::getReleaseYear) // newer year first
                        .reversed())
                .limit(5) // top 5 only
                .forEach(System.out::println);

        System.out.println("-------------------------------------------------------------");
        System.out.println("Total movies considered: " + movies.size());
    }
}