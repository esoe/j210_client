package ru.molokoin.j210_client;

import java.util.Collection;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import ru.molokoin.j210_client.transport.AddressModel;
import ru.molokoin.j210_client.transport.ClientModel;

public class Rest {
    private final Client client = ClientBuilder.newClient();
    private String URL = "http://molokoin.ru:8080/j210_rs/api";

    /**
     * Получение всех сущностей "Клиент"
     * @return
     */
    public Collection<ClientModel> getClients(){
        System.out.println("----------------- PURE-CONTENT -----------------");
        String msg = client.target(URL + "/" + "clients").request(MediaType.APPLICATION_XML).get(String.class);
        System.out.println("MSG >>> " + msg);
        System.out.println("----------------- DESERIALIZATION -----------------");

        // InputStream is = new ByteArrayInputStream(msg.getBytes());
        // XMLDecoder x = new XMLDecoder(is);
        // Collection <ClientModel> clients = (Collection <ClientModel>)x.readObject();
        

        // Collection<ru.molokoin.entities.Client> clients = (ru.molokoin.entities.Client)x.readObject();


        Collection<ClientModel> clients = client.target(URL + "/" + "clients").request(MediaType.APPLICATION_XML).get(new GenericType<Collection<ClientModel>>(){});

        return clients;
    }

    /**
     * Получение всех сущностей "Адрес"
     * @return
     */
    public Collection<AddressModel> getAddresses(){
        System.out.println("----------------- PURE-CONTENT -----------------");
        String msg = client.target(URL + "/" + "addresses").request(MediaType.APPLICATION_XML).get(String.class);
        System.out.println("MSG >>> " + msg);
        System.out.println("----------------- DESERIALIZATION -----------------");
        Collection<AddressModel> addresses = client.target(URL + "/" + "addresses").request(MediaType.APPLICATION_XML).get(new GenericType<Collection<AddressModel>>(){});
        return addresses;
    }

    /**
     * Получение сущности "Адрес" по идентификационному номеру
     * @param id
     * @return
     */
    public AddressModel getAddressById(Integer id){
        System.out.println("----------------- PURE-CONTENT -----------------");
        String msg = client.target(URL + "/" + "addresses" + "/" + id).request(MediaType.APPLICATION_XML).get(String.class);
        System.out.println("MSG >>> " + msg);
        System.out.println("----------------- DESERIALIZATION -----------------");
        return client.target(URL + "/" + "addresses" + "/" + id).request(MediaType.APPLICATION_XML).get(AddressModel.class);
    }

    /**
     * Получение сущности "Клиент" по идентификационному номеру
     * @param id
     * @return
     */
    public ClientModel getClientById(Integer id){
        System.out.println("----------------- PURE-CONTENT -----------------");
        String msg = client.target(URL + "/" + "clients" + "/" + id).request(MediaType.APPLICATION_XML).get(String.class);
        System.out.println("MSG >>> " + msg);
        System.out.println("----------------- DESERIALIZATION -----------------");
        return client.target(URL + "/" + "clients" + "/" + id).request(MediaType.APPLICATION_XML).get(ClientModel.class);
    }

    /**
     * Обновление данных сущности "Клиент"
     * @param cm
     */
    public void updateClient(ClientModel cm){
        System.out.println("----------------- UPDATE-CLIENT -----------------");
        String msg = cm.toString();
        System.out.println("MSG >>> " + msg);
        client.target(URL + "/" + "clients").request(MediaType.APPLICATION_XML).put(Entity.entity(cm, MediaType.APPLICATION_XML));
    }

    /**
     * Создание записи о новом клиенте
     */
    public void createClient(ClientModel cm){
        System.out.println("----------------- CREATE-CLIENT -----------------");
        String msg = cm.toString();
        System.out.println("MSG >>> " + msg);
        client.target(URL + "/" + "clients").request(MediaType.APPLICATION_XML).post(Entity.entity(cm, MediaType.APPLICATION_XML));
    }
    /**
     * Создание записи о новом адресе
     * 
     */
    public void createAddress(AddressModel am){
        System.out.println("----------------- CREATE-ADDRESS -----------------");
        String msg = am.toString();
        System.out.println("MSG >>> " + msg);
        client.target(URL + "/" + "addresses").request(MediaType.APPLICATION_XML).post(Entity.entity(am, MediaType.APPLICATION_XML));
    }

    /**
     * Удаление клиента по id
     * @param id
     * @return
     */
    public void deleteClientById(Integer id){
        System.out.println("----------------- DELETE-CLIENT -----------------");
        client.target(URL + "/" + "clients" + "/" + id).request(MediaType.APPLICATION_XML).delete();
    }

    /**
     * Удаление адреса по id
     * @param id
     * @return
     */
    public void deleteAddressById(Integer id){
        System.out.println("----------------- DELETE-ADDRESS -----------------");
        client.target(URL + "/" + "addresses" + "/" + id).request(MediaType.APPLICATION_XML).delete();
    }

}
