package Controller;

import Model.User;
import View.InputView;
import View.OutputView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Model.ChristmasEvent;
import Model.Menu;
import Model.OrderItem;

public class Controller {

	private final int YEAR_2023 = 2023;
	private final int MONTH_DECEMBER = 12;
	private final int ONE_DAY = 1;
	private final int LAST_DAY = 25;

	private int day;
	private int expense;
	private int totalSale;
	private User user;
	private List<OrderItem> items;
	private OrderItem oder;
	private ChristmasEvent event;

	private LocalDate startDate;
	private LocalDate endDate;
	private LocalDate userDate;

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

		eventCreate();
		presentationMenu();
		salePrint();

	}

	public void salePrint() {
		OutputView.salePrint();

		if (!event.nonEventDate() && expense > 10000) {
			ddaySale();
			dateSale();
			specialDiscount();
			printPresentation();

		} else {
			nonsalePrint();
		}

	}
	
	public void eventAmount() {
		OutputView.printEventAmount();
		String formattedExpense = String.format("-%,d원", totalSale);
		System.out.println(formattedExpense);
		System.out.println();
	}

	public void presentationMenu() {
		OutputView.printPresentation();
		if (!event.nonEventDate() && expense > 120000) {
			System.out.println("샴페인 1개");
			System.out.println();

		} else {
			System.out.println("없음");
			System.out.println();
		}
	}

	public void printPresentation() {
		int discount = event.presentation(expense);
		System.out.println("증정 이벤트: -" + discount + "원");
		totalSale += discount;
	}

	public void eventCreate() {
		startDate = LocalDate.of(YEAR_2023, MONTH_DECEMBER, ONE_DAY);
		endDate = LocalDate.of(YEAR_2023, MONTH_DECEMBER, LAST_DAY);
		userDate = LocalDate.of(YEAR_2023, MONTH_DECEMBER, day);

		event = new ChristmasEvent(startDate, endDate, userDate);
	}

	public void nonsalePrint() {

		System.out.println("없음");

	}

	public void ddaySale() {
		int daySale;

		daySale = event.calculateChristMasDiscount();

		totalSale += daySale;
		System.out.println("크리스마스 디데이 할인:" + " -" + daySale + "원");
	}

	public void dateSale() {
		for (OrderItem orderItem : items) {
			int itemDiscount = event.calculateDiscount(orderItem);

			if (itemDiscount > 0) {
				System.out.println(printWeek() + " -" + itemDiscount + "원");
				totalSale += itemDiscount;

			}
		}
	}

	public String printWeek() {
		if (event.isWeekend(userDate.getDayOfWeek())) {
			return "주말 할인:";
		} else {
			return "평일 할인:";
		}
	}

	public void specialDiscount() {
		int discount = event.calculateDiscountStar();

		totalSale += discount;

		System.out.println("특별 할인: -" + discount + "원");
	}

	public void start() {
		OutputView.openingtMent();
		day = InputView.readDate();
		validateDate(day);

	}

	public void PrintPrice() {
		expense = user.calculateTotalPrice(items);
		String formattedExpense = String.format("%,d원", expense);
		System.out.println(formattedExpense);
		System.out.println();
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
		if (day < 1 || day > 31) {
			throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
		}
	}

}
