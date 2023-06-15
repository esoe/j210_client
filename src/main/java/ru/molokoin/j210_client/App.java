package ru.molokoin.j210_client;

import java.util.ArrayList;
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

        /**
         * Обновление данных Клиента
         * PUT>>>molokoin.ru:8080/j210_rs/api/clients
         * 
         */
        cm.setName("Васильева");
        rest.updateClient(cm);
        System.out.println(rest.getClientById(4).toString());

        /**
         * Удаление клиента
         * DELETE>>>molokoin.ru:8080/j210_rs/api/clients/33
         */
        rest.deleteClientById(33);
        // rest.deleteClientById(35);

        /**
         * Удаление адреса
         * DELETE>>>molokoin.ru:8080/j210_rs/api/addresses/19
         */
        //rest.deleteAddressById(19);

        /**
         * Добавление данных нового Клиента
         * POST>>>molokoin.ru:8080/j210_rs/api/clients
         * 
         */
        cm = new ClientModel();
        cm.setClient_type("Юридическое лицо");
        cm.setName("МО-ЛО-КО-ИН");
        cm.setAdded("2023-06-15");
        cm.setAddresses(new ArrayList<AddressModel>());
        rest.createClient(cm);

        /**
         * Добавление адреса
         * - привязать адрес к клиенту (в сущность адреса передать сущность клиента)
         */
        // cm = rest.getClientById(33);
        // am = new AddressModel();
        // am.setAddress("СПб");
        // am.setIp("192.168.0.1");
        // am.setMac("aa:bb:cc:dd:ee:ff");
        // am.setModel("PC");
        // am.setClient_id(33);
        // rest.createAddress(am);
        /**
         * persist()
         * Подключит модель/сущность к базе
         */


        /**
         * Клиенты списком (просмотр обновлений)
         * GET>>>molokoin.ru:8080/j210_rs/api/clients
         */
        clients = rest.getClients();
        for (ClientModel client : clients) {
            System.out.println(client.toString());
        }

    }
}
