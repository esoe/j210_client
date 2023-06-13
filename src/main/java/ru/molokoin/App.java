package ru.molokoin;

import java.util.Collection;

public class App 
{
    public static void main( String[] args )
    {
        RestClient rest = new RestClient();

        // Collection<ru.molokoin.entities.Client> clients = rest.getClients();
        // for (ru.molokoin.entities.Client client : clients) {
        //     System.out.println(client.toString());
            
        // }
        ru.molokoin.entities.Client c = rest.getClientById(3);
        System.out.println(c.toString());
    }
}
