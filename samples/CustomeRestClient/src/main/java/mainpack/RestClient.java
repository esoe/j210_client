package mainpack;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class RestClient {
    private final Client client = ClientBuilder.newClient();

    private String URL = "http://localhost:8080/dev_j200_2-1.0-SNAPSHOT/api/domain";

    public List<Domain> getAllDomain(){
        return client.target(URL).request(MediaType.APPLICATION_JSON).get(new GenericType<List<Domain>>(){});
    }

    public Domain getDomainById(Long id) {
        return client.target(URL + "/" + id).request(MediaType.APPLICATION_JSON).get(Domain.class);
    }

    public void updateDomain(Domain domain){
        client.target(URL).request().put(Entity.entity(domain, MediaType.APPLICATION_JSON));
    }

}
