package salarySearch;

import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableEntryTransformer;

import java.util.Locale;
import java.util.Map;

public class Configurer  implements TypeRegistryConfigurer {

    @Override
    public void configureTypeRegistry(TypeRegistry registry) {

        registry.defineDataTableType(new DataTableType(Employee.class, new TableEntryTransformer<Employee>() {
            @Override
            public Employee transform(Map<String, String> entry) {
                Employee employee =  new Employee();
                employee.setId( Integer.parseInt( entry.get("id")) );
                employee.setUser( entry.get("user"));
                employee.setSalary( Float.parseFloat( entry.get("salary")));
                return employee;
            }
        }));
    }

    public Locale locale() {
        return Locale.ENGLISH;
    }
}
