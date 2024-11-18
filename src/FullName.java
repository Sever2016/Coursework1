public class FullName {
    private String name;
    private String surname;
    private String patronymic;

    public FullName(String surname, String name, String patronymic) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getName() {
        return this.name;
    }

    public String getPatronymic() {
        return this.patronymic;
    }

    @Override
    public String toString() {
        String c = "|ФИО сотрудника: " + surname + " " + name + " " + patronymic;
        while (c.length() < 50) {
            c += " ";
        }
        return c + "|";
    }
}
