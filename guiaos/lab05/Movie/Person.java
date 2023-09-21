package lab05.Movie;

public class Person {
    private final String name;
    private final int id;
    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    
    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + "]";
    }
}
