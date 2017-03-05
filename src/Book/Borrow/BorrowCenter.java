package Book.Borrow;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import Book.BookAPL.BookCenter;
import Book.BookAPL.Books;
import Book.Login.LoginCenter;
import Book.Login.LoginInfo;

/**
 * 대여관련 메소드 집합체
 */
public class BorrowCenter {
    BookCenter bc;
    LoginCenter lc;
    LoginInfo loginInfo;
    private List<Borrows> borrowList;

    private MoneyCenter moneyCenter;

    public BorrowCenter(BookCenter bc,LoginCenter lc){
        this.bc=bc;
        this.lc=lc;
        loginInfo=lc.getLoginInfo();
        borrowList=new ArrayList<>();
        moneyCenter = new MoneyCenter();
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

                    Calendar instance = Calendar.getInstance();

                    instance.add(Calendar.DATE,-30);

                    //borrows.setRentDate(new Date());
                    borrows.setRentDate(instance.getTime());
                    borrows.setBorrwer(lc.getLoginMemberId());

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
    public List<Borrows> getBorrowList(){
        List<Borrows> borrowBookList=new ArrayList<>(borrowList);
        return borrowBookList;
    }

    /**
     * 로그인된 회원정보를 찾아서 대여목록과 비교하여 보여준다
     * 일반 유저용
     * @return
     */
    public List<Borrows> getUserBorrowList(){
        List<Borrows> borrowUserBookList = new ArrayList<>();
        for(Borrows borrows : borrowList){
            if (borrows.getBorrwer().equals(loginInfo.getLoginId())) {
                borrowUserBookList.add(borrows);
            }
        }
        return borrowUserBookList;
    }

    /**
     * 연체료를 받는다.
     * @param borrows 대여
     * @return 성공 여부
     */
    public boolean recvOverduePrice (Borrows borrows)
    {
        if (!borrows.getBorrwer().equals(lc.getLoginInfo().getLoginId()))
            return false;

        // 연체가 아니기 때문에 처리 하지 않는다., 이미 연체료를 받았기 때문에 처리 하지 않는다.
        if(!borrows.isOverDue() || borrows.isRecvOverDue ())
            return false;

        // 연체료 반납 로직 처리 Start

        // 대여료를 받았음
        borrows.setRecvOverDue (true);

        moneyCenter.addMoney (new Moneys(borrows));

        // 연체료 반납 로직 처리 End


        return true;
    }

    /**
     * 아이디로 찾아서 반납한다
     * @return 대여중 상태를 대여가능 상태로 바꾼다
     */
    public boolean returnWork(Borrows borrows) throws ReturnBorrowException {

        if (!borrows.getBorrwer().equals(lc.getLoginInfo().getLoginId()))
            return false;

        calcOverdue(borrows);

        if(borrows.isOverDue()){
            if(!borrows.isRecvOverDue()){
                //연체료가 발생했는데 못받음
                throw new ReturnBorrowException("연체료가 발생하였습니다.",borrows);
            }
        }

        bc.ReturnBook(borrows.getId());
        borrows.setRented(false);
        return true;
    }

    public boolean returnWork(String id) throws ReturnBorrowException {
        for (Borrows b : getUserBorrowList())
        {
            if (id.equals(b.getId()))
                return returnWork(b);
        }
        return false;
    }

    /**
     * 대여가능 책의 갯수를 5개로 제한
     * @return
     */
    public boolean limitBorrow(){
            if(getUserBorrowList().size()>=5){
                return false;
            }
            else
                return true;
    }

    /**
     * 연체 인지 정상 반납인지 판단
     * 대여일부터 3일 지체면 연체
     * 일수로 계산(Day단위)
     */
    private void calcOverdue(Borrows borrows){
        Date borrowDate = borrows.getRentDate();
        Date returnDate = new Date();
        double diff = Math.floor((returnDate.getTime() - borrowDate.getTime()) / (24 * 60 * 60 * 1000));
        if(diff<=3){
            //정상 반납
            borrows.setOverDue(false);
        }
        else {
            //연체
            int LateFee=((int)diff-3)*1000;
            borrows.setOverDue(true);
            borrows.setOverDuePrice(LateFee);
        }
    }
}