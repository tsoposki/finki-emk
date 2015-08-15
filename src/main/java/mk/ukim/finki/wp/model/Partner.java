package mk.ukim.finki.wp.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Trajche on 8/15/2015.
 */

@Entity
@Table(name = "partners")
public class Partner extends BaseCompany {
    private String contactPerson;

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }
}
