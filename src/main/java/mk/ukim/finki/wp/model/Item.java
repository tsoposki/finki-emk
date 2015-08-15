package mk.ukim.finki.wp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.lucene.analysis.charfilter.HTMLStripCharFilterFactory;
import org.apache.lucene.analysis.core.LowerCaseFilterFactory;
import org.apache.lucene.analysis.standard.StandardTokenizerFactory;
import org.hibernate.search.annotations.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "items")
@Indexed
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item extends BaseEntity {

    private String name;

    private double price;

    @ManyToOne
    private Currency currency;

    @ManyToOne
    private Tax tax;

    @ManyToOne
    private Category category;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Invoice> invoices;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }
}
