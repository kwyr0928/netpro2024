public class NoHolidayException extends Exception {

    @Override
    public void printStackTrace() {
        super.printStackTrace();
        System.err.println("これは自分でつくったエラーメッセージです。");
    }
}
