package Model;

import java.util.HashMap;
import java.util.Map;

import View.InputView;
import camp.nextstep.edu.missionutils.Console;

public class User {
	
	public Map<Menu, Integer> orderMenu() {
		Map<Menu, Integer> menu = new HashMap<>();
		try {
			String input = InputView.inputMenuNumber();

			processUserInput(input, menu);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());

			return orderMenu();
		}
		return menu;

	}
	
	
	private void processUserInput(String input, Map<Menu, Integer> menu) {
		String [] orderItems = input.split(",");
		
	}

}
