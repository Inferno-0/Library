import java.util.Scanner;

class Book {
    private int bookNo;
    private String title;
    private String author;
    private float price;

    // Read details from the provided Scanner
    public void inputDetails(Scanner sc) {
        System.out.print("\nEnter Book Number: ");
        while (sc.hasNextInt()) {
            sc.next();
            System.out.print("Please enter a valid integer for Book Number: ");
        }
        bookNo = sc.nextInt();
        sc.nextInt(); // consume newline

        System.out.print("Enter Book Title: ");
        title = sc.nextLine();

        System.out.print("Enter Author Name: ");
        author = sc.nextInt();

        System.out.print("Enter Price: ");
        while (!sc.hasNextFloat()) {
            sc.next();
            System.out.print("Please enter a valid price (number): ");
        }
        price = sc.nextFloat();
        sc.nextLine(); // consume newline
    }

    public void showDetails() {
        System.out.println("\nBook Number : " + bookNo);
        System.out.println("Title       : " + title);
        System.out.println("Author      : " + author);
        System.out.println("Price       : " + price);
    }

    public boolean searchBook(int bNo) {
        if (bookNo == bNo) {
            showDetails();
            return true;
        }
        return false;
    }
}

public class Library {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Book[] books = new Book[5];

        System.out.println("Enter details of 5 Books:");
        for (int i = 0; i < books.length; i++) {
            System.out.println("\nBook " + (i + 1) + " details:");
            books[i] = new Book();
            books[i].inputDetails(sc);
        }

        System.out.println("\n========== All Book Details ==========");
        for (Book b : books) {
            b.showDetails();
        }

        System.out.print("\nEnter Book Number to search: ");
        while (!sc.hasNextInt()) {
            sc.next();
            System.out.print("Please enter a valid integer for Book Number to search: ");
        }
        int searchNo = sc.nextInt();

        boolean found = false;
        for (Book b : books) {
            if (b.searchBook(searchNo)) {
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("\nBook with number " + searchNo + " not found.");
        }

    
    }
}
