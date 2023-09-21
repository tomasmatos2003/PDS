package lab08.ex2;

import java.util.ArrayList;
import java.util.List;

class Parking {
    private List<Person> allowedPeople;
    
    Parking() {
        this.allowedPeople = new ArrayList<>();
    }

    void allow(Person person) {
        if (!allowedPeople.contains(person))
            allowedPeople.add(person); 
    }
}
