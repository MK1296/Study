package app;

import model.Item;
import model.Book;
import constants.Constants;

public class Main {

    private String firstName = "桑畑"; // ←自分の名字
    private String lastName = "萌花";  // ←自分の名前

    public static void main(String[] args) {
        Main main = new Main();

        main.printName(main.firstName, main.lastName);

        Item item = new Item(Constants.ITEM_NAME, Constants.ITEM_PRICE);
        item.showInfo();

        Book book = new Book(Constants.BOOK_NAME, Constants.BOOK_PRICE, Constants.BOOK_AUTHOR);
        book.showInfo();

        int discountedPrice = Constants.BOOK_PRICE - 200;
        System.out.println("割引後の書籍価格：" + discountedPrice + "円");
    }

    private void printName(String firstName, String lastName) {
    System.out.println("氏名：" + firstName + lastName);
    }

}