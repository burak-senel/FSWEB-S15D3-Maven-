package org.example;


import org.example.entity.Employee;

import java.util.*;

import static org.example.WordCounter.calculateWord;

public class Main {

    private static Map<Long, Employee> employeeMap;

    public static void main(String[] args) {
        Employee employee1=new Employee(1,"Burak","Şenel");
        Employee employee2=new Employee(1,"Tekrar","Şenol");
        Employee employee3=new Employee(2,"Demet1","Akalın1");
        Employee employee4=new Employee(3,"Demet2","Akalın2");
        Employee employee5=new Employee(4,"Demet3","Akalın3");
        Employee employee6=new Employee(4,"Demet4","Akalın4");

        List<Employee>employees=new LinkedList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);
        employees.add(employee6);
        System.out.println("Duplicates: " + findDuplicates(employees));
        System.out.println("Uniques: " + findUniques(employees));
        System.out.println("After Removing Duplicates: " + removeDuplicates(employees));
    }
    public static List<Employee> findDuplicates(List<Employee> employees) {
        HashSet<Employee> seen = new HashSet<>();
        LinkedList<Employee> duplicates = new LinkedList<>();

        for (Employee emp : employees) {
            if (!seen.add(emp)) {
                duplicates.add(emp);
            }
        }
        return duplicates;
    }

    public static Map<Long, Employee> findUniques(List<Employee> employees) {

        Iterator<Employee> iterator = employees.iterator();
        employeeMap = new HashMap<>();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee == null) {
                System.out.println("null data buldum");
                continue;
            }
            if (!employeeMap.containsKey(employee.getId())) {
                employeeMap.put(employee.getId(), employee);

            }

        }
        return employeeMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees) {
        HashMap<Long, Employee> uniques = new HashMap<>();
        HashSet<Employee> duplicates = new HashSet<>();

        for (Employee emp : employees) {
            if (uniques.containsKey(emp.getId())) {
                duplicates.add(emp);
                duplicates.add(uniques.remove(emp.getId()));
            } else if (!duplicates.contains(emp)) {
                uniques.put(emp.getId(), emp);
            }
        }
        return new LinkedList<>(uniques.values());
    }
}