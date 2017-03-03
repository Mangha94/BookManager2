package Book.Borrow;

/**
 * Created by ttinfo on 2017-03-03.
 */
public class ReturnBorrowException extends Exception {

    public ReturnBorrowException(String message, Borrows borrows) {
        super(message);
        this.borrows = borrows;
    }

    public Borrows getBorrows() {
        return borrows;
    }

    public void setBorrows(Borrows borrows) {
        this.borrows = borrows;
    }

    private Borrows borrows;

}
