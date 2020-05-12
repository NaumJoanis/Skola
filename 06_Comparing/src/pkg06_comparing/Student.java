
package pkg06_comparing;

/**
 *
 * @author Joanis Naum
 */
public class Student implements CompareInterface, Comparable<Student> {
    private String firstName;
    private String lastName;
    private int age;
    private int number;

    public Student(String firstName, String lastName, int number, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Student{" + "firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", number=" + number + '}';
    }

    boolean startLater(Student student) {
        return this.number > student.number;
    }

    boolean isOlder(Student student) {
        return this.age > student.age;
    }

    @Override
    public boolean isSmaller(CompareInterface o) {
        return this.number > ((Student)o).number;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public int getNumber() {
        return number;
    }

    
    
    /*@Override
    public int compareTo(Object o) { //zaporne, 0, kladne int
        return this.number - ((Student)o).number;
    }*/

    @Override
    public int compareTo(Student o) {
        return this.number - o.number;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.number;
        return hash;
    }
    
    //x.equals(y) , y.equals(z) , x.equals(z)
    //x.equals(y) musi platit y.equals(x)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (this.number != other.number) {
            return false;
        }
        return true;
    }
    
    
    
}
