package Model;

import java.util.List;
import java.util.Objects;

public class OrderItem {

	private final Menu menu;
	private int quantity;

	public OrderItem(Menu menu, int quantity) {
		this.menu = menu;
		this.quantity = quantity;
	}

	public Menu getMenu() {
		return menu;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getTotalPrice() {
		return menu.getPrice() * quantity;
	}
	
	@Override
	
	public boolean equals (Object ob) {
		if(this == ob) return true;
		if(ob == null || getClass() != ob.getClass()) return false;
		OrderItem orderItem = (OrderItem) ob;
		return Objects.equals(menu, orderItem.menu);
	}
	
	@Override
    public int hashCode() {
        return Objects.hash(menu);
    }
	

	@Override
	public String toString() {
		return menu.getName() + " " + quantity + "개";
	}

}
