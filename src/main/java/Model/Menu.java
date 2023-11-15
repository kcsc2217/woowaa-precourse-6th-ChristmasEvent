package Model;

public enum Menu {
	
	//애피타이저
	YENGSONGSOUP("양송이 수프", 6000),
	TAPAS("타파스", 5500),
	 CAESARSALAD("시저샐러드", 8000),
	 
	 // 메인
	    T_BONE_STEAK("티본스테이크", 55000),
	    BBQ_RIB("바비큐립", 54000),
	    SEAFOOD_PASTA("해산물파스타", 35000),
	    CHRISTMAS_PASTA("크리스마스파스타", 25000),

	    // 디저트
	    CHOCO_CAKE("초코케이크", 15000),
	    ICE_CREAM("아이스크림", 5000),

	    // 음료
	    ZERO_COLA("제로콜라", 3000),
	    RED_WINE("레드와인", 60000),
	    CHAMPAGNE("샴페인", 25000);
	
	private final String name;
	private final int price;
	
	Menu(String name, int price){
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isDrink() {
		return this == ZERO_COLA || this == RED_WINE || this == CHAMPAGNE;
	}
	
	public boolean isDessert() {
		return this == CHOCO_CAKE || this == ICE_CREAM;
	}
	
	
	public boolean idMaindish() {
		return this == T_BONE_STEAK || this == BBQ_RIB || this == SEAFOOD_PASTA || this == CHRISTMAS_PASTA;
	}
	public int getPrice() {
		return price;
	}
	 
	

}
