package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ExLista01 {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        List<Employee> list = new ArrayList<>();
        
        System.out.print("How many employees will be registered? ");
        int x = sc.nextInt();
        
        for(int i = 1; i <= x; i++){
            System.out.println("");
            System.out.println("Employee #"+i+ " :");
            System.out.print("Id: ");
            Integer id = sc.nextInt();
            while(hasId(list, id)){
                System.out.print("Id already taken! Try again: ");
                id = sc.nextInt();
            }
            
            System.out.print("Name: ");
            sc.nextLine(); //clear input buffer
            String name = sc.nextLine();
            
            System.out.print("Salary: ");
            Double salary = sc.nextDouble();
            
            Employee emp = new Employee(id, salary, name);
            list.add(emp);
        }
        
        System.out.println("");
        System.out.print("Enter the employee ID that will have salary increase: ");
        int idsalary = sc.nextInt();
        System.out.print("");
        Integer position = positionId(list, idsalary);
        
        //Employee emp = list.stream().filter(x -> x.getId() == idsalary).findFirst().orElse(null); -> 1 line code to search for ID (lambda function)
        
        if (position == null){
            System.out.println("This Id doesn't exist!");
        } else {
            System.out.print("Enter the percentage: ");
            double percent = sc.nextDouble();
            list.get(position).increaseSalary(percent);
        }
        
        System.out.println("");
        System.out.println("List of Employees:");
        for(Employee emp: list){
            System.out.println(emp);
        }
        sc.close();
    }
    
    public static Integer positionId(List<Employee> list, int id ){ //verify if idsalry exists
        for (int i = 0 ; i < list.size(); i++){
            if (list.get(i).getId() == id){
                return i;
            }
        }
        return null;
    }
    
    public static boolean hasId(List<Employee> list, int id) {
            Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
            return emp != null;
	}
    
}
