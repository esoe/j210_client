package mainpack;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Person {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private Set<Domain> domainEntitySet = new HashSet<>();
}
