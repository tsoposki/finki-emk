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

    public DateTime getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(DateTime issueDate) {
        this.issueDate = issueDate;
    }

    public DateTime getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(DateTime maturityDate) {
        this.maturityDate = maturityDate;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
