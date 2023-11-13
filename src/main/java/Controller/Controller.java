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
	User user;
	List<OrderItem> items;

	public Controller() {
		user = new User();
		items = new ArrayList<>();

	}

	public void run() {
		start();
		MenuInput();
		OutputView.eventBenefit();
		OutputView.orderMenu();

		PrintItem();

	}

	public void start() {
		OutputView.openingtMent();
		day = InputView.readDate();

	}

	public void PrintItem() {
		for (OrderItem orderItem : items) {
			System.out.println(orderItem);
		}
	}

	public void MenuInput() {
		items = user.orderMenu();
	}

}
