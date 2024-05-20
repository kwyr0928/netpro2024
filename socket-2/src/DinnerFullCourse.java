public class DinnerFullCourse {
	private Dish[] list = new Dish[5];// [0]-[4]の計5個

	public DinnerFullCourse() {
		for(int i=0; i<list.length; i++){
			list[i] = new Dish();
		}
		list[0].setName("ハンバーグ");
		list[0].setValune(500);
		list[1].setName("オムライス");
		list[1].setValune(400);
		list[2].setName("うどん");
		list[2].setValune(350);
		list[3].setName("焼肉");
		list[3].setValune(1200);
		list[4].setName("牛丼");
		list[4].setValune(550);
	}

	public static void main(String[] args) {
		DinnerFullCourse fullcourse = new DinnerFullCourse();
		fullcourse.eatAll();
	}

	public void eatAll() {
		for (Dish dish : list) {
			System.out.println("名前:" + dish.getName() + "  値段:" + dish.getValune() + "円");
		}
	}
}
