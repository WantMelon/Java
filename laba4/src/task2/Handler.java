package task2;

import java.util.List;
import java.util.Scanner;

public class Handler {
    private final List<BooksInfo> library;

    public Handler(List<BooksInfo> library) {
        this.library = library;
    }

    public void helpInfo() {
        System.out.println("Выберете одну из опций: ");
        System.out.println("1 - Просмотреть данные");
        System.out.println("2 - Добавить данные");
        System.out.println("3 - Редактировать данные");
        System.out.println("4 - Удалить данные");
        System.out.println("5 - Обработать дынные");
        System.out.println("6 - Help message");
        System.out.println();
    }

    public void showData() {
        for (BooksInfo book : library) {
            System.out.println(book);
        }
    }

    public void addData() {
        Scanner sc = new Scanner(System.in);
        BooksInfo book = new BooksInfo();
        System.out.println("Введите данные ->");
        System.out.println("ФИО читателя: ");
        book.setName(sc.next());
        System.out.println("Название книги: ");
        book.setBook(sc.next());
        System.out.println("Автор книги: ");
        book.setAuthor(sc.next());
        System.out.println("Дата выдачи в формате yy:mm:dd");
        book.setStartDate(new Date(sc.next()));
        System.out.println("Дата возврата в формате yy:mm:dd, либо '-'");
        String finishDate = sc.next();
        if (finishDate.equals("-")) {
            book.setStartDate(null);
        } else {
            book.setStartDate(new Date(finishDate));
        }

    }

    public void updateData() {
    }

    public void deleteData() {
    }

    public void processData() {
    }
}
