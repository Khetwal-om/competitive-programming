


# ArrayList

1. Employee class

```java
import java.util.Objects;

public class Employee{
    private String firstName;
    private String lastName;
    private int id;

    public Employee(String firstName,String lastName,int id){
        this.firstName=firstName;
        this.lastName=lastName;
        this.id=id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, id);
    }
}














```



2. Main java class

```java

import java.util.ArrayList;
import java.util.List;

public class Hi{
    public static void main(String[] args) {
        List<Employee> employeeList=new ArrayList<>();
        employeeList.add(new Employee("Jane","Jones",123));
        employeeList.add(new Employee("John","Doe",125));
        employeeList.add(new Employee("Mary","Smith",120));
        employeeList.add(new Employee("James","henry",121));

        employeeList.forEach(employee -> System.out.println(employee));


        System.out.println(employeeList.get(1));

        System.out.println(employeeList.isEmpty());

        employeeList.set(1,new Employee("John","Adams",3455));



        employeeList.forEach(employee -> System.out.println(employee));


        System.out.println(employeeList.size());

//        add element at specific index


        employeeList.add(3,new Employee("John","Doe",1234));


    // say w
//        Object[] employeeArray = employeeList.toArray();



    // from employee list to employee array


        Employee[] employeeArray=employeeList.toArray(new Employee[employeeList.size()]);
        for(Employee employee:employeeArray){
            System.out.println(employee);
        }


        // check if list contains an employee

        // This will return false because we haven't implemented in Employee class
        System.out.println(employeeList.contains(new Employee("Mary","Smith",120)));


        // override it in Employee : true :)


        System.out.println(employeeList.indexOf(new Employee("John","Doe",1234)));



        employeeList.remove(2);

        employeeList.forEach(employee -> System.out.println(employee));



    }
}




```




2. Vectors


> Vectors exist before ArrayList so why they came into existence. Vectors are thread safe (Synchronised) , the latter one isn't. \
The fact that ArrayList came into existence because synchronisation has an overhead involved it \
slows things down. So when only vector class was available if we wanted to  use list backed by an \
array we were forced to use synchronised class even if we did'nt need synchronization.



```java
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Hi{
    public static void main(String[] args) {
        List<Employee> employeeList=new ArrayList<>();
        employeeList.add(new Employee("Jane","Jones",123));
        employeeList.add(new Employee("John","Doe",125));
        employeeList.add(new Employee("Mary","Smith",120));
        employeeList.add(new Employee("James","henry",121));

        

    }
}

```






3. __SinglyLinkedList__


1. Employee

```java
import java.util.Objects;

public class Employee{
    private String firstName;
    private String lastName;
    private int id;

    public Employee(String firstName,String lastName,int id){
        this.firstName=firstName;
        this.lastName=lastName;
        this.id=id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, id);
    }
}

```


2. EmployeeNode.java

```java
public class EmployeeNode {
    private Employee employee;
    private EmployeeNode next;

    public EmployeeNode(Employee employee){
        this.employee=employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeNode getNext() {
        return next;
    }

    public void setNext(EmployeeNode next) {
        this.next = next;
    }

    public String toString(){
        return employee.toString();
    }

}

```


3. EmployeeLinkedList

```java
public class EmployeeLinkedList {
    private EmployeeNode head;
    private int size;


    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return head==null;
    }


    public void addToFront(Employee employee){
        EmployeeNode node=new EmployeeNode(employee);
        node.setNext(head);
        head=node;
        size++;
    }



    public EmployeeNode removeFromFront(){
      if(isEmpty()) {
          return null;
      }

      EmployeeNode removeNode=head;
      head=head.getNext();
      size--;
//      to be diligent removeNode.setNext(null);
      return removeNode;

    }



    public void printList(){
        EmployeeNode current=head;
        while (current!=null){
            System.out.print(current);
            System.out.print(" -> ");
            current=current.getNext();
        }
        System.out.println("null");
    }

}


```