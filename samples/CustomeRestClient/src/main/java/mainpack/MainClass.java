package mainpack;

public class MainClass {

    public static void main(String[] args) {
        RestClient client = new RestClient();

        Domain domain = client.getDomainById(1L);
        domain.setCountryReg("Blabla");
        client.updateDomain(domain);
    }
}
