package Book.Borrow;

import Book.BookAPL.BookCenter;
import Book.BookAPL.Books;
import Book.Login.LoginCenter;
import Book.Login.LoginInfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 대여관련 메소드 집합체
 */
public class BorrowCenter {
    BookCenter bc;
    LoginCenter lc;
    LoginInfo loginInfo;
    private List<Borrows> borrowList;

    public BorrowCenter(BookCenter bc,LoginCenter lc){
        this.bc=bc;
        this.lc=lc;
        loginInfo=new LoginInfo();
        borrowList=new ArrayList<>();
    }
    /**
     * id로 찾아서 대여장부에 추가
     * @param id
     * @return
     */
    public boolean borrow(String id)
    {
        for(Books borrowBook:bc.getBooks())
        {
            if(id.equals(borrowBook.getId())) {
                if(!borrowBook.isRented()) {
                    Borrows borrows=new Borrows();

                    borrows.setTitle(borrowBook.getTitle());
                    borrows.setWriter(borrowBook.getWriter());
                    borrows.setPublisher(borrowBook.getPublisher());
                    borrows.setPrice(borrowBook.getPrice());
                    borrows.setClassification(borrowBook.getClassification());
                    borrows.setId(borrowBook.getId());
                    borrows.setRented(true);
                    borrows.setRentDate(new Date());
                    borrows.setBorrwer(loginInfo.getLoginId());

                    borrowList.add(borrows);
                    bc.borrowBook(id);
                    return true;
                }
                else
                    return false;
            }
        }
        return false;
    }

    /**
     * 빌린전체리스트를 표출
     * 관리자용
     * @return
     */
    public List<Borrows>getBorrowList(){
        List<Borrows> borrowBookList=new ArrayList<>(borrowList);
        return borrowBookList;
    }

    /**
     * 로그인된 회원정보를 찾아서 대여목록과 비교하여 보여준다
     * 일반 유저용
     * @return
     */
    public List<Borrows>getUserBorrowList(){
        List<Borrows> borrowBookList = new ArrayList<>();
        for(Borrows borrows : borrowList) {
            if (borrows.getBorrwer().equals(loginInfo.getLoginId())) {
                borrowBookList.add(borrows);
            }
        }
        return borrowBookList;
    }

    /**
     * 아이디로 찾아서 반납한다
     * @param id
     * @return 대여중 상태를 대여가능 상태로 바꾼다
     */
    public boolean Return(String id){
        for(Borrows returnBook:borrowList){
            if(id.equals(returnBook.getId()) && returnBook.getBorrwer().equals(loginInfo.getLoginId())){
                bc.ReturnBook(id);
                returnBook.setRented(false);
                return true;
            }
        }
        return false;
    }


}
