package mk.ukim.finki.wp.model;

import org.hibernate.search.annotations.*;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Trajche on 8/15/2015.
 */

@Entity
@Table(name = "payment_types")
@Indexed
public class PaymentType extends BaseEntity {
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
