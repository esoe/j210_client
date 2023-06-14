package ru.molokoin.j210_client;

import java.util.Collection;

import ru.molokoin.j210_client.transport.AddressModel;
import ru.molokoin.j210_client.transport.ClientModel;

public class App 
{
    public static void main( String[] args )
    {
        Rest rest = new Rest();

        /**
         * Клиенты списком
         * GET>>>molokoin.ru:8080/j210_rs/api/clients
         */
        Collection<ClientModel> clients = rest.getClients();
        for (ClientModel client : clients) {
            System.out.println(client.toString());
        }
        /**
         * Клиент id = 4
         * GET>>>molokoin.ru:8080/j210_rs/api/clients/4
         */
        ClientModel cm = rest.getClientById(4);
        System.out.println(cm.toString());

        /**
         * Адреса списком
         * GET>>>molokoin.ru:8080/j210_rs/api/addresses
         */
        Collection<AddressModel> addresses = rest.getAddresses();
        for (AddressModel address : addresses) {
            System.out.println(address.toString());
        }

        /**
         * Адрес id = 4
         * GET>>>molokoin.ru:8080/j210_rs/api/addresses/4
         */
        AddressModel am = rest.getAddressById(4);
        System.out.println(am.toString());
    }
}
