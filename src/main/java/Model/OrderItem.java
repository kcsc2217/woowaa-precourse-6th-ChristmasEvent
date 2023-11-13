package Model;

import java.util.List;

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
	public String toString() {
		return menu.getName() + " " + quantity + "개";
	}

}
