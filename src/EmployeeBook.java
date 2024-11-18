public class EmployeeBook {

    private Employee[] storage = {
            new Employee(new FullName("Семенова", "Алина", "Артёмовна"), 2, 29000),
            new Employee(new FullName("Павлов", "Дмитрий", "Егорович"), 2, 28000),
            new Employee(new FullName("Новиков", "Мирон", "Романович"), 1, 76000),
            new Employee(new FullName("Уткин", "Николай", "Тимофеевич"), 3, 62500),
            new Employee(new FullName("Смирнов", "Тимофей", "Андреевич"), 1, 27900),
            new Employee(new FullName("Некрасова", "Дарья", "Ярославовна"), 4, 42000),
            new Employee(new FullName("Лазарев", "Илья", "Александрович"), 5, 176000),
            new Employee(new FullName("Коновалов", "Иван", "Максимович"), 3, 54009),
            new Employee(new FullName("Воробьева", "Арина", "Артёмовна"), 2, 89000),
            new Employee(new FullName("Астафьев", "Андрей", "Олегович"), 2, 32000)
    };

    public boolean cheekNull(Employee employee) {

        return employee != null;
    }

    public Employee[] getStorage() {
        return storage;
    }

    public Employee getStorage1(int e) {
        return storage[e];
    }

    public void printEmployees(Employee[] storage) {
        for (Employee employee : storage) {
            if (cheekNull(employee)) {
                System.out.println(employee.toString());
            }
        }
    }

    public double countSalaryExpenses(Employee[] storage) {
        double salaryExpenses = 0;
        for (Employee employee : storage) {
            if (cheekNull(employee)) {
                salaryExpenses += employee.getSalary();
            }
        }
        return salaryExpenses;
    }

    public Employee foundMinSalaryEmployee(Employee[] storage) {
        double minSalary = storage[0].getSalary();
        Employee minSalaryEmployee = storage[0];
        for (Employee employee : storage) {
            if (cheekNull(employee) && minSalary >= employee.getSalary()) {
                minSalary = employee.getSalary();
                minSalaryEmployee = employee;
            }
        }
        return minSalaryEmployee;
    }

    public Employee foundMaxSalaryEmployee(Employee[] storage) {
        double maxSalary = storage[0].getSalary();
        Employee maxSalaryEmployee = storage[0];
        for (Employee employee : storage) {
            if (cheekNull(employee) && maxSalary <= employee.getSalary()) {
                maxSalary = employee.getSalary();
                maxSalaryEmployee = employee;
            }
        }
        return maxSalaryEmployee;
    }

    public double countAverageSalary(Employee[] storage) {
        return countSalaryExpenses(storage) / storage.length;
    }

    public void printEmployeesFullName(Employee[] storage) {
        System.out.println("ФИО сотрудников:");
        for (Employee employee : storage) {
            if (cheekNull(employee)) {
                System.out.println(employee.getFullName().getSurname() + " " + employee.getFullName().getName() + " " + employee.getFullName().getPatronymic());
            }
        }
    }

    public void indexSalary(Employee[] storage, double percentageIncrease) {
        for (Employee employee : storage) {
            if (cheekNull(employee)) {
                employee.setSalary(employee.getSalary() * (1 + (percentageIncrease / 100)));
            }
        }
    }

    public Employee[] makeListDepartmentEmployees(Employee[] storage, int departmentNumber) {
        int countEmployees = 0;
        for (Employee employee : storage) {
            if (cheekNull(employee) && employee.getDepartmentNumber() == departmentNumber) {
                countEmployees++;
            }
        }
        Employee[] departmentList = new Employee[countEmployees];
        int i = 0;
        for (Employee employee : storage) {
            if (cheekNull(employee) && employee.getDepartmentNumber() == departmentNumber) {
                departmentList[i] = employee;
                i++;
            }
        }
        return departmentList;
    }

    public Employee foundMinSalaryEmployeeInDepartment(Employee[] storage, int departmentNumber) {
        return foundMinSalaryEmployee(makeListDepartmentEmployees(storage, departmentNumber));
    }

    public Employee foundMaxSalaryEmployeeInDepartment(Employee[] storage, int departmentNumber) {
        return foundMaxSalaryEmployee(makeListDepartmentEmployees(storage, departmentNumber));
    }

    public double countSalaryExpensesInDepartment(Employee[] storage, int departmentNumber) {
        return countSalaryExpenses(makeListDepartmentEmployees(storage, departmentNumber));
    }

    public double countAverageSalaryInDepartment(Employee[] storage, int departmentNumber) {
        return countAverageSalary(makeListDepartmentEmployees(storage, departmentNumber));
    }

    public void indexSalaryInDepartment(Employee[] storage, int departmentNumber, double percentageIncrease) {
        indexSalary(makeListDepartmentEmployees(storage, departmentNumber), percentageIncrease);
    }

    public void printDepartmentEmployees(Employee[] storage, int departmentNumber) {
        System.out.println("Сотрудники " + departmentNumber + "-го отдела.");
        printEmployees(makeListDepartmentEmployees(storage, departmentNumber));
    }

    public void printEmployeesWithLowerSalary(Employee[] storage, double maxSalary) {
        System.out.println("Сотрудники с зарплатой меньше " + maxSalary + " рублей.");
        for (Employee employee : storage) {
            if (cheekNull(employee) && employee.getSalary() < maxSalary) {
                System.out.println(employee.getFullName().toString() + employee.getId() + " его id.| " + employee.getSalary() + " рублей - зарплата.|");
            }
        }
    }

    public void printEmployeesWithHigherSalary(Employee[] storage, double minSalary) {
        System.out.println("Сотрудники с зарплатой больше " + minSalary + " рублей.");
        for (Employee employee : storage) {
            if (cheekNull(employee) && employee.getSalary() >= minSalary) {
                System.out.println(employee.getFullName().toString() + employee.getId() + " его id.| " + employee.getSalary() + " рублей - зарплата.|");
            }
        }
    }

    public boolean addEmployee(Employee newEmployee) {
        for (Employee employee : storage) {
            if (cheekNull(employee) && newEmployee.getId() == employee.getId()) {
                return false;
            }
        }
        for (int i = 0; i < storage.length; i++) {
            if (!cheekNull(storage[i])) {
                storage[i] = newEmployee;
                return true;
            }
        }
        return false;
    }

    public void deleteEmployee(int deleteEmployeeId) {
        for (int i = 0; i < storage.length; i++) {
            if (cheekNull(storage[i]) && deleteEmployeeId == storage[i].getId()) {
                storage[i] = null;
            }
        }
    }

    public Employee getEmployeeById(int employeeId) {
        for (Employee employee : storage) {
            if (cheekNull(employee) && employee.getId() == employeeId) {
                return employee;
            }
        }
        return null;
    }
}