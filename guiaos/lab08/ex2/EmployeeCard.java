package lab08.ex2;

class EmployeeCard {
    private String name;
    private int number;
    private static int numbers = 0;
    
    EmployeeCard(String name) {
        this.name = name;
        this.number = numbers++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }
}
