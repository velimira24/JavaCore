package JDK.lesson4;

public class Main {
    public static void main(String[] args) {

        EmployeeDirectory dir = new EmployeeDirectory();

        Employee employee1 = new Employee(1, 666333, "Павел", 4);
        Employee employee2 = new Employee(2, 777, "Мария", 1);
        Employee employee3 = new Employee(3, 987654, "Василий", 7);
        Employee employee4 = new Employee(4, 123123, "Инна", 3);

        dir.addEmployee(employee1);
        dir.addEmployee(employee2);
        dir.addEmployee(employee3);
        dir.addEmployee(employee4);
        System.out.println(dir);
        System.out.println();

        System.out.println("1. Поиск сотрудника по стажу");
        System.out.println(dir.searchByExperience(4));

        System.out.println();
        System.out.println("2. Поиск сотрудника по номеру телефона. ");
        System.out.println(dir.getPhoneByName("Мария"));

        System.out.println();
        System.out.println("3. Поиск сотрудника по табельному номеру");
        System.out.println(dir.searchByServiceNumber(3));

        System.out.println();
        System.out.println("4. Добавляем сотрудника с именем Лидия: ");
        Employee employee5 = new Employee(5, 111, "Лидия", 2);
        dir.addEmployee(employee5);

        System.out.println(dir);
    }

}