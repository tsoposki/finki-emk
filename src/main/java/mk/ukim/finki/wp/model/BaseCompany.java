package mk.ukim.finki.wp.model;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * Created by Trajche on 8/15/2015.
 */

@MappedSuperclass
public class BaseCompany extends BaseEntity {
    private String name;
    private String email;
    private String phone;

    @ManyToOne
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
