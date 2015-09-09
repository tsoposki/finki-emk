package mk.ukim.finki.wp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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

    @ManyToOne
    private Company company;

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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
