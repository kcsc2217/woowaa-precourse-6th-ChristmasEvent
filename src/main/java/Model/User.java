package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import View.InputView;
import camp.nextstep.edu.missionutils.Console;

public class User {

	public List<OrderItem> orderMenu() {
		List<OrderItem> orderItems = new ArrayList<>();
		try {
			String input = InputView.inputMenuNumber();

			processUserInput(input, orderItems);
			

		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());

			return orderMenu();
		}
		return orderItems;

	}

	private void processUserInput(String input, List<OrderItem> orderItems) {
		String[] orderItemsStrings = input.split(",");
		List<Menu> tempMenu = new ArrayList<>();

		for (String orderItem : orderItemsStrings) {
			String[] item = orderItem.trim().split("-");
			validateOrderItemFormat(item);

			String menuName = item[0];
			int quantity;

			try {
				quantity = Integer.parseInt(item[1]);
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
			}
			validateItemquantity(quantity);

			Menu menuObject = findMenuByName(menuName);

			if (menuObject != null) {
				validateOverLapItem(menuObject, orderItems);
				orderItems.add(new OrderItem(menuObject, quantity));
				

			} else {
				throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
			}

		}
		
	}
	
	public int calculateTotalPrice(List<OrderItem> orderItems) {
		int totalPrice = 0;
		
		for(OrderItem orderItem : orderItems) {
			totalPrice += orderItem.getTotalPrice();
		}
		
		return totalPrice;
	}


	private Menu findMenuByName(String menuName) {
		for (Menu menu : Menu.values()) {
			if (menu.getName().equalsIgnoreCase(menuName)) {
				return menu;
			}
		}
		return null;
	}

	private void validateOrderItemFormat(String[] item) {
		if (item.length != 2) {
			throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
		}
	}

	private void validateItemquantity(int quantity) {
		if (quantity <= 0) {
			throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
		}
	}

	private void validateOverLapItem(Menu menuObject, List<OrderItem> orderItems) {

		if (orderItems.contains(menuObject)) {
			throw new IllegalArgumentException("[ERROR] 중복된 메뉴를 입력하셨습니다. 다시 입력해 주세요.");
		}
	}

}
