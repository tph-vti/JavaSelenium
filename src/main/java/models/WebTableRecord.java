package models;

import java.util.Objects;

public class WebTableRecord {

    private String firstName;
    private String lastName;
    private String age;
    private String email;
    private String salary;
    private String department;

    public WebTableRecord(
            String firstName,
            String lastName,
            String age,
            String email,
            String salary,
            String department
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.salary = salary;
        this.department = department;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getAge() { return age; }
    public String getEmail() { return email; }
    public String getSalary() { return salary; }
    public String getDepartment() { return department; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WebTableRecord that)) return false;
        return Objects.equals(firstName, that.firstName)
                && Objects.equals(lastName, that.lastName)
                && Objects.equals(age, that.age)
                && Objects.equals(email, that.email)
                && Objects.equals(salary, that.salary)
                && Objects.equals(department, that.department);
    }

    @Override
    public String toString() {
        return "WebTableRecord{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age='" + age + '\'' +
                ", email='" + email + '\'' +
                ", salary='" + salary + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
