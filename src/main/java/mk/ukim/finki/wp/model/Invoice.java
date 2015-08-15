package mk.ukim.finki.wp.model;

import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Trajche on 8/14/2015.
 */

@Entity
@Table(name = "invoices")
public class Invoice extends BaseEntity{
    private DateTime issueDate;
    private DateTime maturityDate;

    @ManyToOne
    private Partner partner;

    @ManyToOne
    private PaymentType paymentType;

    @ManyToOne
    private Currency currency;

    @ManyToMany(mappedBy = "invoices")
    private List<Item> items;

}
