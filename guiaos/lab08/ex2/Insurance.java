package lab08.ex2;

import java.util.ArrayList;
import java.util.List;

class Insurance {
    private List<Person> people;

    Insurance() {
        this.people = new ArrayList<>();
    }

    boolean regist(Person person) {
        if (!people.contains(person)) {
            people.add(person);
            return true;
        } else
            return false;
    }

    public List<Person> getPeople() {
        return people;
    }
}
