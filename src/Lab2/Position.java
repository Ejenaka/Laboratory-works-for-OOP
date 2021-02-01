package Lab2;

public enum Position {
    RECTOR(35000, 20),
    DEPUTY_RECTOR(20000, 18),
    DEAN(15000, 15),
    HEAD_OF_DEPARTMENT(12000, 15),
    PROFESSOR(10000, 15),
    DOCENT(9000, 15),
    SENIOR_LECTURER(8000, 15);

    private int salary;
    private int vacationDaysCount;

    Position(int salary, int vacationDaysCount) {
        this.salary = salary;
        this.vacationDaysCount = vacationDaysCount;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getVacationDaysCount() {
        return vacationDaysCount;
    }

    public void setVacationDaysCount(int vacationDaysCount) {
        this.vacationDaysCount = vacationDaysCount;
    }

}
