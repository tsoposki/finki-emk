package mk.ukim.finki.wp.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by Trajche on 08.09.2015.
 */

@Entity
@Table(name = "invoice_items")
public class InvoiceItem extends BaseEntity {
    private Integer quantity;

    @ManyToOne
    private Item item;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
