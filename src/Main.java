public class Main {
    static int counter = 0;

    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();

        // базовая сложность
        employeeBook.printEmployees(employeeBook.getStorage());
        System.out.println();
        System.out.println(employeeBook.countSalaryExpenses(employeeBook.getStorage()) + " рублей - затраты на ЗП в месяц.");
        System.out.println("Сотрудник с минимальной зарплатой - " + employeeBook.foundMinSalaryEmployee(employeeBook.getStorage()));
        System.out.println("Сотрудник с максимальной зарплатой - " + employeeBook.foundMaxSalaryEmployee(employeeBook.getStorage()));
        System.out.println(employeeBook.countAverageSalary(employeeBook.getStorage()) + " рублей - средняя зарплата сотрудников.");
        System.out.println();
        employeeBook.printEmployeesFullName(employeeBook.getStorage());
        System.out.println();

        //повышенная сложность
        double percentageIncrease = 25;
        int departmentNumber = 2;
        employeeBook.indexSalary(employeeBook.getStorage(), percentageIncrease);
        System.out.println("Сотрудник с минимальной зарплатой в отделе - " + employeeBook.foundMinSalaryEmployeeInDepartment(employeeBook.getStorage(), departmentNumber));
        System.out.println("Сотрудник с максимальной зарплатой в отделе - " + employeeBook.foundMaxSalaryEmployeeInDepartment(employeeBook.getStorage(), departmentNumber));
        System.out.println(employeeBook.countSalaryExpensesInDepartment(employeeBook.getStorage(), departmentNumber) + " рублей - траты на зарплату у " + departmentNumber + "-го отдела.");
        System.out.println("Средняя зарплата " + departmentNumber + "-го отдела: " + employeeBook.countAverageSalaryInDepartment(employeeBook.getStorage(), departmentNumber));
        employeeBook.indexSalaryInDepartment(employeeBook.getStorage(), departmentNumber, percentageIncrease);
        System.out.println();
        employeeBook.printDepartmentEmployees(employeeBook.getStorage(), departmentNumber);
        System.out.println();
        employeeBook.printEmployeesWithLowerSalary(employeeBook.getStorage(), 46000);
        System.out.println();
        employeeBook.printEmployeesWithHigherSalary(employeeBook.getStorage(), 77000);
        System.out.println();

        //очень сложно
        employeeBook.deleteEmployee(3);
        Employee cc = new Employee(new FullName("Семенова", "Диана", "Ивановна"), 3, 290400);
        if (employeeBook.addEmployee(cc)) {
            System.out.println("Добавлен новый сотрудник");
        } else {
            System.out.println("Для нового сотрудника нет места");
        }
        System.out.println();
        System.out.println("Сотрудник найденный по id " + employeeBook.getEmployeeById(1));
    }
}
