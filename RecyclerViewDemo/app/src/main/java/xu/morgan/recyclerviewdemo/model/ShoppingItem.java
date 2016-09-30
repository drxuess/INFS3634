package xu.morgan.recyclerviewdemo.model;

import java.text.DecimalFormat;

/**
 * Created by morganxu on 29/09/2016.
 */
public class ShoppingItem {

    private String name;
    private double price;

    public ShoppingItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        return "$" + decimalFormat.format(price);
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
