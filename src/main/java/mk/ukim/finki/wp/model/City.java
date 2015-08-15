package mk.ukim.finki.wp.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Trajche on 8/15/2015.
 */


@Entity
@Table(name = "cities")
public class City extends BaseEntity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}