import Book.BookAPL.BookCenter;
import Book.BookManagerLogin;
import Book.BookMenuForUser;
import Book.Bookapp;
import Book.Member.MemberCenter;
import Book.Member.Members;

import java.io.IOException;

public class Main {

    public static void main(String[] args)throws IOException {
        BookManagerLogin Login=new BookManagerLogin();
        Login.bookMangerLogin();
    }
}
