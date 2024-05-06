import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyExceptionHoliday {

	public static void main(String[] args) {

		MyExceptionHoliday myE = new MyExceptionHoliday();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.print("5月の日付を入力してください：");
			String line = reader.readLine();
			int theday = Integer.parseInt(line);
			System.out.println("入力した日付：" + theday + "日");
			myE.test(theday);
		} catch (IOException e) {
			System.out.println(e);
		} catch (NoHolidayException e) {
			e.printStackTrace();
		}
	}

	void test(int theday) throws NoHolidayException {
		int[] holidays = { 3, 4, 5, 6, 11, 12, 18, 19, 25, 26 };
		for (int holiday : holidays) {
			if (theday == holiday) {
				System.out.println(theday + "日は休日・土日です。");
				return;
			}
		}
		throw new NoHolidayException();
	}
}
