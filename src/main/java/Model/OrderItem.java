package Model;

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
	 
	 public void incrementQuantity() {
		 this.quantity++;
	 }
	 
	 @Override
	    public String toString() {
	        return menu.getName() + " " + quantity + "개";
	    }

}
