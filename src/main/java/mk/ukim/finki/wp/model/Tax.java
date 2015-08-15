package mk.ukim.finki.wp.model;

import org.hibernate.search.annotations.*;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Trajche on 8/15/2015.
 */

@Entity
@Table(name = "taxes")
@Indexed
public class Tax extends BaseEntity {

    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String name;

    private double value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
