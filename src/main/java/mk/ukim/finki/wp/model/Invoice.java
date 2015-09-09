package mk.ukim.finki.wp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.metamodel.binding.CascadeType;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "invoices")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Invoice extends BaseEntity{
    private Long issueDate;
    private Long maturityDate;

    @ManyToOne
    private Partner partner;

    @ManyToOne
    private PaymentType paymentType;

    @ManyToOne
    private Currency currency;

    @ManyToOne
    private Company company;

    @OneToMany
    private List<InvoiceItem> invoiceItems;

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

    public Long getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Long issueDate) {
        this.issueDate = issueDate;
    }

    public Long getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(Long maturityDate) {
        this.maturityDate = maturityDate;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("IssueDate: ").append(issueDate).append("\n");
        sb.append("MaturityDate: ").append(maturityDate).append("\n");
        sb.append("PartnerId: ").append(partner.getId()).append("\n");

        return sb.toString();
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
