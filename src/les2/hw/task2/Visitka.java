package les2.hw.task2;

import java.util.Arrays;

/**
 * Created by User on 06.12.2016.
 */
public class Visitka {
    private String name;
    private String surname;
    private String[] phones;
    private String[] sites;
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String[] getPhones() {
        return phones;
    }

    public void setPhones(String[] phones) {
        this.phones = phones;
    }

    public String[] getSites() {
        return sites;
    }

    public void setSites(String[] sites) {
        this.sites = sites;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Visitka{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phones=" + Arrays.toString(phones) +
                ", sites=" + Arrays.toString(sites) +
                ", address=" + address +
                '}';
    }
}
