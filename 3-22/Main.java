package app;

import model.Item;
import model.Book;
import constants.Constants;

public class Main {
    
    private String firstName;
    private String lastName;

    public static void main(String[] args) {

        Main m = new Main();
        m.firstName = "桑畑";
        m.lastName = "萌花";

        m.printName(m.firstName, m.lastName);

        Item item = new Item(Constants.ITEM_NAME, Constants.ITEM_PRICE);
        Book book = new Book(Constants.BOOK_NAME, Constants.BOOK_PRICE, Constants.BOOK_AUTHOR);

        item.showInfo();
        book.showInfo();
    }

    private void printName(String firstName, String lastName) {
        System.out.println("氏名：" + firstName + lastName);
    }
}
