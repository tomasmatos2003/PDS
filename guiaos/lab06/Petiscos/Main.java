package lab06.Petiscos;

public class Main {
    public static void main(String[] args) {
        
        Database db = new Database();
        db.addEmployee(new Employee("Tomás Matos", 1, 420));
        db.addEmployee(new Employee("Quitaneiro", 2, 422));
        db.addEmployee(new Employee("Riczãoo", 3, 5000));

        System.out.println("Empregados:");
        for (Employee emp : db.getAllEmployees())
            System.out.printf("%-15s %5d %5f€\n", emp.getName(), emp.getEmpNum(), emp.getSalary());

        
        System.out.println("\nDelete employee n1\n");
        db.deleteEmployee(1);

        System.out.println("Empregados:");
        for (Employee emp : db.getAllEmployees())
            System.out.printf("%-15s %5d %5f€\n", emp.getName(), emp.getEmpNum(), emp.getSalary());
    
        Registos rg = new Registos();

        rg.insere(new Empregado("Tomás", "Matos", 1, 120));
        rg.insere(new Empregado("Ric", "Fazeres", 2, 200));
        rg.insere(new Empregado("ze", "ric", 3, 10));
        System.out.println("\nRegistos:");
        for (Empregado emp : rg.listaDeEmpregados())
            System.out.printf("%-15s %5d %5f€\n", emp.nome() + " " + emp.apelido(), emp.codigo(), emp.salario());

        if (rg.isEmpregado(1))
            System.out.println("\n1 exists");
        else
            System.out.println("1 doesn't exist");
        
        if (rg.isEmpregado(2))
            System.out.println("2 exists");
        else
            System.out.println("2 doesn't exist");

        System.out.println("\nRemove empregado com código 2\n");
        rg.remove(2);

        if (rg.isEmpregado(1)){
            System.out.println("1 existe");
        }else{
            System.out.println("1 não existe");
        }
            
        

        if (rg.isEmpregado(2)){
            System.out.println("2 existe");
        }else{
            System.out.println("2 não existe");
        }
            

        System.out.println("\nLista de empregados:");
        for (Empregado emp : rg.listaDeEmpregados()){
            System.out.printf("%-15s %5d %5f€\n", emp.nome() + " " + emp.apelido(), emp.codigo(), emp.salario());
        }
        

        System.out.println("\n\nExercício 2\n");


        DBInterface[] dbInterfaces = { new RegistosAdapter(), new DBAdapter() };

        dbInterfaces[0].insere(new Empregado("John", "Doe", 1, 1000));
        dbInterfaces[1].insere(new Empregado("Jane", "Doe", 2, 2000));
        dbInterfaces[1].insere(new Empregado("John", "Smith", 3, 3000));

        DBInterface SPDB = new SPDatabase(dbInterfaces);
        SPDB.insere(new Empregado("Jane", "Smith", 4, 4000));
        SPDB.remove(2);     // Remove empregado com código 2 usando a nova base de dados
        for (Empregado empregado : SPDB.listaDeEmpregados()) {
            System.out.println(empregado.nome() + ' ' + empregado.apelido() + ' ' + empregado.codigo() + ' ' + empregado.salario() + '€');            
        }
        System.out.println("O código 5 associa-se a um empregado? " + SPDB.isEmpregado(5));
    }
}
