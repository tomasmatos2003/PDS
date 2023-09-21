package lab05.Movie;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Bigodes", 1);
        Person p2 = new Person("Pé de Pano", 2);
        Person p3 = new Person("Riczão", 3);
        Person p4 = new Person("The Fazers", 2);

        Place pl1 = new Place("Lisboa", 1);
        Place pl2 = new Place("Porto", 2);
        Place pl3 = new Place("Coimbra", 3);
        Place pl4 = new Place("Braga", 4);

        System.out.println("Persons:");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);


        System.out.println("\nPlaces:");
        System.out.println(pl1);
        System.out.println(pl2);
        System.out.println(pl3);
        System.out.println(pl4);

        Movie m1 = new Movie.MovieBuilder("The Fazers", 2020)
            .director(p1)
            .writer(p2)
            .genres(List.of("Comedy", "Drama"))
            .languages(List.of("Portuguese", "English"))
            .series("The Fazers")
            .cast(List.of(p3, p4))
            .locations(List.of(pl1, pl2, pl3, pl4))
            .isTelevision(true)
            .isNetflix(true)
            .isIndependent(true)
            .build();

        System.out.println("\nMovies:");
        System.out.println(m1);

        
    }
}
