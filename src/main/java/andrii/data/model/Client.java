package andrii.data.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Client implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String telephoneNumber;

    @Column
    private String contactPerson;

    public Client() {
    }

    public Client(String name, String address, String telephoneNumber, String contactPerson) {
        this.name = name;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.contactPerson = contactPerson;
    }

    public Client(Integer id, String name, String address, String telephoneNumber, String contactPerson) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.contactPerson = contactPerson;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }
}
