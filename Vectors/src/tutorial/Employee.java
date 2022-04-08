package tutorial;

public class Employee
{
    private long ID;
    private String firstName;
    private String lastName;

    public Employee(long ID, String firstName, String lastName)
    {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getID()
    {
        return ID;
    }

    public void setID(long ID)
    {
        this.ID = ID;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (ID != employee.ID) return false;
        if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) return false;
        return lastName != null ? lastName.equals(employee.lastName) : employee.lastName == null;
    }

    @Override
    public int hashCode()
    {
        int result = (int) (ID ^ (ID >>> 32));
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString()
    {
        return "Employee {" + "ID=" + ID + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + '}';
    }

}