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

    public Employee[] getStorage(){
        return storage;
    }
    public Employee getStorage1(int e) {
        return storage[e];
    }

    public void printEmployees(Employee[] storage) {
        for (Employee employee : storage) {
            System.out.println(employee.toString());
        }
    }

    public double countSalaryExpenses(Employee[] storage) {
        double salaryExpenses = 0;
        for (Employee employee : storage) {
            salaryExpenses += employee.getSalary();
        }
        return salaryExpenses;
    }

    public int foundMinSalaryId(Employee[] storage) {
        double minSalary = storage[0].getSalary();
        int id = storage[0].getId();
        for (Employee employee : storage) {
            if (minSalary >= employee.getSalary()) {
                minSalary = employee.getSalary();
                id = employee.getId();
            }
        }
        return id;
    }

    public int foundMaxSalaryId(Employee[] storage) {
        double maxSalary = storage[0].getSalary();
        int id = storage[0].getId();
        for (Employee employee : storage) {
            if (maxSalary <= employee.getSalary()) {
                maxSalary = employee.getSalary();
                id = employee.getId();
            }
        }
        return id;
    }

    public double countAverageSalary(Employee[] storage) {
        return countSalaryExpenses(storage) / storage.length;
    }

    public void printEmployeesFullName(Employee[] storage) {
        System.out.println("ФИО сотрудников:");
        for (Employee employee : storage) {
            System.out.println(employee.getFullName().getSurname() + " " + employee.getFullName().getName() + " " + employee.getFullName().getPatronymic());
        }
    }

    public void indexSalary(Employee[] storage, double percentageIncrease) {
        for (Employee employee : storage) {
            employee.setSalary(employee.getSalary() * (1 + (percentageIncrease / 100)));
        }
    }

    public int foundMinSalaryIdInDepartment(Employee[] storage, int depatmentNumber) {
        double minSalary = countSalaryExpenses(storage);
        int id = 0;
        for (Employee employee : storage) {
            if (minSalary >= employee.getSalary() && employee.getDepartmentNumber() == depatmentNumber) {
                minSalary = employee.getSalary();
                id = employee.getId();
            }
        }
        return id;
    }

    public int foundMaxSalaryIdInDepartment(Employee[] storage, int depatmentNumber) {
        double maxSalary = -1;
        int id = 0;
        for (Employee employee : storage) {
            if (maxSalary <= employee.getSalary() && employee.getDepartmentNumber() == depatmentNumber) {
                maxSalary = employee.getSalary();
                id = employee.getId();
            }
        }
        return id;
    }

    public double countSalaryExpensesInDepartment(Employee[] storage, int departmentNumber) {
        double salaryExpenses = 0;
        for (Employee employee : storage) {
            if (departmentNumber == employee.getDepartmentNumber()) {
                salaryExpenses += employee.getSalary();
            }
        }
        return salaryExpenses;
    }

    public double countAverageSalaryInDepartment(Employee[] storage, int departmentNumber) {
        double employeePerDepartment = 0;
        for (Employee employee : storage) {
            if (departmentNumber == employee.getDepartmentNumber()) {
                employeePerDepartment++;
            }
        }
        return countSalaryExpensesInDepartment(storage, departmentNumber) / employeePerDepartment;
    }

    public void indexSalaryInDepartment(Employee[] storage, int departmentNumber, double percentageIncrease) {
        for (Employee employee : storage) {
            if (employee.getDepartmentNumber() == departmentNumber) {
                employee.setSalary(employee.getSalary() * (1 + (percentageIncrease / 100)));
            }
        }
    }

    public void printDepartmentEmployees(Employee[] storage, int departmentNumber) {
        System.out.println("Сотрудники " + departmentNumber + "-го отдела.");
        for (Employee employee : storage) {
            if (employee.getDepartmentNumber() == departmentNumber) {
                System.out.println("|Id: " + employee.getId() + " " + employee.getFullName().toString() + "Зарплата: " + employee.getSalary() + " рублей|");
            }
        }
    }

    public void printEmployeesWithLowerSalary(Employee[] storage, double maxSalary) {
        System.out.println("Сотрудники с зарплатой меньше " + maxSalary + " рублей.");
        for (Employee employee : storage) {
            if (employee.getSalary() < maxSalary) {
                System.out.println(employee.getFullName().toString() + employee.getId() + " его id.| " + employee.getSalary() + " рублей - зарплата.|");
            }
        }
    }

    public void printEmployeesWithHigherSalary(Employee[] storage, double minSalary) {

        System.out.println("Сотрудники с зарплатой больше " + minSalary + " рублей.");
        for (Employee employee : storage) {
            if (employee.getSalary() >= minSalary) {
                System.out.println(employee.getFullName().toString() + employee.getId() + " его id.| " + employee.getSalary() + " рублей - зарплата.|");
            }
        }
    }

    public boolean addEmployee(Employee employee) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = employee;
                return true;
            }
        }
        return false;
    }

    public void deleteEmployee(int deleteEmployeeId) {
        for (int i = 0; i < storage.length; i++) {
            if (deleteEmployeeId == storage[i].getId()) {
                storage[i] = null;
            }
        }
    }

    public Employee getEmployeeById(int employeeId) {
        for (Employee employee : storage) {
            if (employee.getId() == employeeId) {
                return employee;
            }
        }
        return null;
    }
}
