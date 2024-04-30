import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyExceptionHoliday {

	public static void main(String[] args) {

		MyExceptionHoliday myE=new MyExceptionHoliday();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		try {
            System.out.println("何日ですか?");
			String line = reader.readLine();
			int theday = Integer.parseInt(line);
			System.out.println("日付" + theday + "日ですね。");
            myE.test(theday);
		} 	catch(IOException e) {
			System.out.println(e);
		} catch (NoHolidayException e) {
			e.printStackTrace();
		}
	}

    void test(int theday) throws NoHolidayException{
		if(theday==6){
			throw new NoHolidayException();
		}
	}
}
