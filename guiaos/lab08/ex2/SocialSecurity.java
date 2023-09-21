package lab08.ex2;

import java.util.ArrayList;
import java.util.List;

class SocialSecurity {
    private List<Person> people;
    
    SocialSecurity() {
        this.people = new ArrayList<>();
    }

    void regist(Person person) {
        people.add(person);
    }    
}
