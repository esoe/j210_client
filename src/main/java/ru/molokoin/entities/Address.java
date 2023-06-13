package ru.molokoin.entities;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "addresses")
public class Address{
    private Integer id;
    private String ip;
    private String mac;
    private String model;
    private String address;
    /**
     * В базе поле есть, но в xml файле не приходит
     */
    // private Integer client_id;

    public Address(){}

    // public Integer getClient_id() {
    //     return client_id;
    // }
    // public void setClient_id(Integer client_id) {
    //     this.client_id = client_id;
    // }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    public String getIp() {
        return ip;
    }
    public void setMac(String mac) {
        this.mac = mac;
    }
    public String getMac() {
        return mac;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getModel() {
        return model;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return address;
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
        Address other = (Address) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Address [id=" + id + ", ip=" + ip + ", mac=" + mac + ", model=" + model + ", address=" + address + "]";
    }
    
}
