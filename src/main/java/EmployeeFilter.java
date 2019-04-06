import java.util.List;

@FunctionalInterface
public interface EmployeeFilter {
    public boolean testEmployee(Employee employee);

}
