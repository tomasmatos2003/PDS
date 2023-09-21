package lab05.Movie;

import java.util.*;

public class Movie { 

    private final String title;
    private final int year;
    private final Person director;
    private final Person writer;
    private final String series;
    private final List<Person> cast;
    private final List<Place> locations;
    private final List<String> languages;
    private final List<String> genres;
    private final boolean isTelevision;
    private final boolean isNetflix;
    private final boolean isIndependent;

    public static class MovieBuilder { 
        private final String title;
        private final int year;

        // optional arguments
        private Person director;
        private Person writer;        
        private List<String> genres;
        private List<String> languages = null;
        private String series = null;
        private List<Person> cast = null;
        private List<Place> locations = null;
        private boolean isTelevision = false;
        private boolean isNetflix = false;
        private boolean isIndependent = false;

        public MovieBuilder(String title, int year) {
            this.title = title;
            this.year = year;
        }

        public MovieBuilder director(Person director) {
            this.director = director;
            return this;
        }

        public MovieBuilder writer(Person writer) {
            this.writer = writer;
            return this;
        }

        public MovieBuilder genres(List<String> genres) {
            this.genres = genres;
            return this;
        }

        public MovieBuilder languages(List<String> languages) {
            this.languages = languages;
            return this;
        }

        public MovieBuilder series(String series) {
            this.series = series;
            return this;
        }

        public MovieBuilder cast(List<Person> cast) {
            this.cast = cast;
            return this;
        }

        public MovieBuilder locations(List<Place> locations) {
            this.locations = locations;
            return this;
        }

        public MovieBuilder isTelevision(boolean isTelevision) {
            this.isTelevision = isTelevision;
            return this;
        }

        public MovieBuilder isNetflix(boolean isNetflix) {
            this.isNetflix = isNetflix;
            return this;
        }

        public MovieBuilder isIndependent(boolean isIndependent) {
            this.isIndependent = isIndependent;
            return this;
        }

        public Movie build() {
            return new Movie(this);
        }
    }

    private Movie(MovieBuilder builder) {
        title = builder.title;
        year = builder.year;
        director = builder.director;
        writer = builder.writer;
        series = builder.series;
        cast = builder.cast;
        locations = builder.locations;
        languages = builder.languages;
        genres = builder.genres;
        isTelevision = builder.isTelevision;
        isNetflix = builder.isNetflix;
        isIndependent = builder.isIndependent;
    }

    @Override
    public String toString() {
        return "Movie [\n cast=" + cast + ",\n director=" + director + ",\n genres=" + genres + ",\n isIndependent="
                + isIndependent + ",\n isNetflix=" + isNetflix + ",\n isTelevision=" + isTelevision + ",\n languages="
                + languages + ",\n locations=" + locations + ",\n series=" + series + ",\n title=" + title + ",\n writer="
                + writer + ",\n year=" + year + "]";
    }
}
