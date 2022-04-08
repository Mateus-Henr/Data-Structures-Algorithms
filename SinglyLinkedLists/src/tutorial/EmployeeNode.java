package tutorial;

// The only reason why we would use generics is if the app is going to be released publicly.
public class EmployeeNode
{
    private Employee employee;
    private EmployeeNode nextNode;

    public EmployeeNode(Employee employee)
    {
        this.employee = employee;
    }

    public Employee getEmployee()
    {
        return employee;
    }

    public void setEmployee(Employee employee)
    {
        this.employee = employee;
    }

    public EmployeeNode getNextNode()
    {
        return nextNode;
    }

    public void setNextNode(EmployeeNode nextNode)
    {
        this.nextNode = nextNode;
    }

    @Override
    public String toString()
    {
        return employee.toString();
    }

}
