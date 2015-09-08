package mk.ukim.finki.wp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "subscriptions")
@Indexed
@JsonIgnoreProperties(ignoreUnknown = true)
public class Subscription extends BaseEntity {
    private String name;
    private String description;
    private double price;

    private int itemsLimit;
    private int partnersLimit;
    private int invoicesLimit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getItemsLimit() {
        return itemsLimit;
    }

    public void setItemsLimit(int itemsLimit) {
        this.itemsLimit = itemsLimit;
    }

    public int getPartnersLimit() {
        return partnersLimit;
    }

    public void setPartnersLimit(int partnersLimit) {
        this.partnersLimit = partnersLimit;
    }

    public int getInvoicesLimit() {
        return invoicesLimit;
    }

    public void setInvoicesLimit(int invoicesLimit) {
        this.invoicesLimit = invoicesLimit;
    }
}
