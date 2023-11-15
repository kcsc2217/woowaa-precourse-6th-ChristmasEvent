package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import View.InputView;
import camp.nextstep.edu.missionutils.Console;

public class User {
	int sum;
	int drinkCount = 0;
	int totalItemCount = 0;

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

		for (String orderItem : orderItemsStrings) {
			String[] item = orderItem.trim().split("-"); // 주문시 메뉴와 갯수를 분리
			validateOrderItemFormat(item); // 제로 콜라 -2 : item[0] : 제로 콜라 item[1] : 2 2개가 나와야함

			String menuName = item[0];
			int quantity;

			try {
				quantity = Integer.parseInt(item[1]);
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
			}
			validateItemquantity(quantity); // 수량이 음수일떄 예외처리
			validateOrderLengthLimit(quantity); // 수량이 20을 넘어갔을시 예외처리

			Menu menuObject = findMenuByName(menuName);

			if (menuObject != null) {

				validateOverLapItem(menuObject, orderItems); //
				orderItems.add(new OrderItem(menuObject, quantity));

				// 음료 카운트
				if (menuObject.isDrink()) {
					drinkCount += quantity;
				}
				totalItemCount += quantity;

			} else {
				throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
			}

		}
		validateDrinkLimit(drinkCount, totalItemCount);

	}

	public int calculateTotalPrice(List<OrderItem> orderItems) {
		int totalPrice = 0;

		for (OrderItem orderItem : orderItems) {
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

	private void validateOrderLengthLimit(int quantity) {
		sum += quantity;
		if (sum > 20) {
			throw new IllegalArgumentException("[ERROR] 20개를 넘어갔습니다. 다시 입력해 주세요.");
		}
	}

	private void validateDrinkLimit(int drinkCount, int totalItemCounts) {
		if (drinkCount > 0 && drinkCount == totalItemCount) {
			throw new IllegalArgumentException("[ERROR] 음료만 주문 시, 주문할 수 없습니다. 다시 입력해 주세요.");
		}
	}

	private void validateItemquantity(int quantity) {
		if (quantity <= 0) {
			throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
		}
	}

	private void validateOverLapItem(Menu menuObject, List<OrderItem> orderItems) {
		OrderItem newItem = new OrderItem(menuObject, 1);

		if (orderItems.contains(newItem)) {
			throw new IllegalArgumentException("[ERROR] 중복된 메뉴를 입력하셨습니다. 다시 입력해 주세요.");
		}
	}

}
