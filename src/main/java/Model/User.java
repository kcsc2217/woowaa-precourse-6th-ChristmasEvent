package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import View.InputView;
import camp.nextstep.edu.missionutils.Console;

public class User {

	public Map<Menu, Integer> orderMenu() {
		Map<Menu, Integer> menu = new HashMap<>();
		try {
			String input = InputView.inputMenuNumber();

			List<Menu> tempMenu = processUserInput(input);

			menu.putAll(convertToMenuMap(tempMenu));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());

			return orderMenu();
		}
		return menu;

	}

	private List<Menu> processUserInput(String input) {
		String[] orderItems = input.split(",");
		List<Menu> tempMenu = new ArrayList<>();

		for (String orderItem : orderItems) {
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
				validateOverLapItem(menuObject, tempMenu);
				tempMenu.add(menuObject);
				

			} else {
				throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
			}

		}
		return tempMenu;

	}

	private Map<Menu, Integer> convertToMenuMap(List<Menu> tempMenu) {
		Map<Menu, Integer> menuMap = new HashMap<>();
		for (Menu menu : tempMenu) {
			menuMap.put(menu, menuMap.getOrDefault(menu, 0) + 1);
		}
		return menuMap;
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

	private void validateOverLapItem(Menu menuObject, List<Menu> menu) {

		if (menu.contains(menuObject)) {
			throw new IllegalArgumentException("[ERROR] 중복된 메뉴를 입력하셨습니다. 다시 입력해 주세요.");
		}
	}

}
