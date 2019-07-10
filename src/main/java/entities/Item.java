package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Item {

    /*
        Item:
        -itemId
        -price
        -customizeableOptions

        The assumption for now is that regardless of set options, an item has one price
     */

    private @Id @GeneratedValue int itemId;
    private double price;
    // private List<String> customizationOptions;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // public List<String> getCustomizationOptions() { return customizationOptions; }

    // public void setCustomizationOptions(List<String> customizationOptions) { this.customizationOptions = customizationOptions; }
}
