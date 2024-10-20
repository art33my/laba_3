import java.util.HashMap;
import java.util.Scanner;

public class EmployeeManager {
    
    static class Employee {
        public String name;
        public String position;
        public double salary;

        public Employee(String name, String position, double salary) {
            this.name = name;
            this.position = position;
            this.salary = salary;
        }

        public String toString() {
            return "Имя: " + name + ", Должность: " + position + ", Зарплата: " + salary;
        }
    }

    private HashMap<Integer, Employee> employeeMap;

    public EmployeeManager() {
        employeeMap = new HashMap<>();
    }

    public void addEmployee(int id, String name, String position, double salary) {
        Employee newEmployee = new Employee(name, position, salary);
        employeeMap.put(id, newEmployee);
    }

    public Employee getEmployee(int id) {
        return employeeMap.get(id); 
    }

    public void removeEmployee(int id) {
        employeeMap.remove(id); 
    }

    public void printAllEmployees() {
        for (Integer id : employeeMap.keySet()) {
            System.out.println("ID: " + id + ", " + employeeMap.get(id).toString());
        }
    }

    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();
        Scanner scanner = new Scanner(System.in);

        boolean running = true; 

        while (running) {
            System.out.println("Меню:");
            System.out.println("1. Добавить сотрудника");
            System.out.println("2. Найти сотрудника по ID");
            System.out.println("3. Удалить сотрудника");
            System.out.println("4. Вывести всех сотрудников");
            System.out.println("5. Выйти");
            System.out.print("Выберите действие: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Введите ID сотрудника: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Введите имя сотрудника: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите должность сотрудника: ");
                    String position = scanner.nextLine();
                    System.out.print("Введите зарплату сотрудника: ");
                    double salary = scanner.nextDouble();
                    manager.addEmployee(id, name, position, salary);
                    System.out.println("Сотрудник добавлен!");
                    break;
                case 2:
                    System.out.print("Введите ID сотрудника для поиска: ");
                    int searchId = scanner.nextInt();
                    Employee employee = manager.getEmployee(searchId);
                    if (employee != null) {
                        System.out.println("Найден сотрудник: " + employee.toString());
                    } else {
                        System.out.println("Сотрудник с таким ID не найден.");
                    }
                    break;
                case 3:
                    System.out.print("Введите ID сотрудника для удаления: ");
                    int removeId = scanner.nextInt();
                    manager.removeEmployee(removeId);
                    System.out.println("Сотрудник удалён!");
                    break;
                case 4:
                    System.out.println("Все сотрудники:");
                    manager.printAllEmployees();
                    break;
                case 5:
                    running = false;
                    System.out.println("Выход из программы...");
                    break;
                default:
                    System.out.println("Неверный выбор, попробуйте снова.");
            }
        }

        scanner.close();
    }
}
