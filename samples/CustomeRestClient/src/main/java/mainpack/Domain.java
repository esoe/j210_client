package mainpack;

import lombok.Data;

import java.sql.Date;

@Data
public class Domain {

    private long id;
    private String domainName;
    private String ip;
    private Date dateReg;
    private String countryReg;
    private Person person;
}
