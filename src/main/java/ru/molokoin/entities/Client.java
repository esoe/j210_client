package ru.molokoin.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "client")
public class Client{
    private Integer id;
    private String name;
    private String client_type;
    private String added;
    private Collection<Address> addresses = new ArrayList<>();

    public Client(){}
    public Client(String name, String client_type, String added){
        setName(name);
        setClient_type(client_type);
        setAdded(added);
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setClient_type(String client_type) {
        this.client_type = client_type;
    }
    public String getClient_type() {
        return client_type;
    }
    public void setAdded(String added) {
        this.added = added;
    }
    public String getAdded() {
        return added;
    }
    @XmlTransient
    public Collection<Address> getAddresses() {
        return addresses;
    }
    public void setAddresses(Collection<Address> addresses) {
        this.addresses = addresses;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Client other = (Client) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Client [id=" + id + ", name=" + name + ", client_type=" + client_type + ", added=" + added
                //+ ", addresses=" + addresses
                + "]";
    }
    

}
