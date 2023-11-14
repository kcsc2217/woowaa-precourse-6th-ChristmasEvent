package Controller;

import Model.User;
import View.InputView;
import View.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Model.Menu;
import Model.OrderItem;

public class Controller {

	int day;
	int expense;
	User user;
	List<OrderItem> items;
	OrderItem oder;

	public Controller() {
		user = new User();
		items = new ArrayList<>();
		

	}

	public void run() {
		start();
		MenuInput();
		OutputView.eventBenefit(day);
		OutputView.orderMenu();

		PrintItem();
		OutputView.PrintNoSale();
		PrintPrice();
		

	}

	public void start() {
		OutputView.openingtMent();
		day = InputView.readDate();
		validateDate(day);

	}
	
	public void PrintPrice() {
		expense = user.calculateTotalPrice(items);
		System.out.println(expense + "원");
	}
	
	
	

	public void PrintItem() {
		for (OrderItem orderItem : items) {
			System.out.println(orderItem);
		}
		System.out.println();
	}

	public void MenuInput() {
		items = user.orderMenu();
	}
	
	private void validateDate(int day) {
		if(day < 1 || day > 31) {
			throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
		}
	}

}
