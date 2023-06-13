package ru.molokoin;

import java.beans.XMLDecoder;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

public class RestClient {
    private final Client client = ClientBuilder.newClient();
    private String URL = "http://molokoin.ru:8080/j210_rs/api";

    public Collection<ru.molokoin.entities.Client> getClients(){
        
        String msg = client.target(URL + "/" + "clients").request(MediaType.APPLICATION_XML).get(String.class);
        System.out.println("MSG >>> " + msg);
        System.out.println("----------------- DESERIALIZATION -----------------");

        InputStream is = new ByteArrayInputStream(msg.getBytes());
        XMLDecoder x = new XMLDecoder(is);
        Collection <ru.molokoin.entities.Client> clients = (Collection <ru.molokoin.entities.Client>)x.readObject();
        

        // Collection<ru.molokoin.entities.Client> clients = (ru.molokoin.entities.Client)x.readObject();


        // Collection<ru.molokoin.entities.Client> clients = client.target(URL + "/" + "clients").request(MediaType.APPLICATION_XML).get(new GenericType<Collection<ru.molokoin.entities.Client>>(){});

        return clients;
    }
    public ru.molokoin.entities.Client getClientById(Integer id){
        String msg = client.target(URL + "/" + "clients" + "/" + id).request(MediaType.APPLICATION_XML).get(String.class);
        System.out.println("MSG >>> " + msg);
        System.out.println("----------------- DESERIALIZATION -----------------");

        // InputStream is = new ByteArrayInputStream(msg.getBytes());
        // XMLDecoder x = new XMLDecoder(is);
        // ru.molokoin.entities.Client c = (ru.molokoin.entities.Client)x.readObject();
        // return c;







        return client.target(URL + "/" + "clients" + "/" + id).request(MediaType.APPLICATION_XML).get(ru.molokoin.entities.Client.class);
    }
    
}
