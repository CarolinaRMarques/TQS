package salarySearch;

public class Employee {

    private int id;
    private String user;
    private float salary;

    public Employee(int id, String user, float salary) {
        this.id = id;
        this.user = user;
        this.salary = salary;
    }
    public Employee() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }


    // constructor, getter, setter ommitted
}