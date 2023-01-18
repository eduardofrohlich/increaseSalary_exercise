package entities;
public class Employee {
    private Integer id;
    private Double salary;
    private String name;

    public Employee(){
        
    }
    
    public Employee(Integer id, Double salary, String name) {
        this.id = id;
        this.salary = salary;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void increaseSalary(double percentage){
        salary += salary * percentage / 100;
    }

    @Override
    public String toString() {
        return id + ", " + name + ", " + String.format("R$ %.2f", salary);
    }
  
    
}
