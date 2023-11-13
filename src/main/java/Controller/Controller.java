package Controller;

import Model.User;
import View.InputView;
import View.OutputView;

import java.util.HashMap;
import java.util.Map;

import Model.Menu;

public class Controller {

	int day;
	User user;
	Map<Menu,Integer> menuItem;
	
	
	public Controller() {
		user = new User();
		menuItem = new HashMap<>();
	}

	public void run() {
		start();
		MenuInput();
	}

	public void start() {
		OutputView.openingtMent();
		day = InputView.readDate();
	}
	
	public void MenuInput() {
		menuItem = user.orderMenu();
	}

}
