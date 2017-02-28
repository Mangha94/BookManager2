package Book.Borrow;

import java.util.Date;

/**
 * Created by ttinfo on 2017-02-28.
 */
public class Borrows {
    private String title;
    private String writer;
    private String publisher;
    private String price;
    private String classification;
    private String id;
    private boolean rented;
    private String borrwer;
    private Date rentDate;

    public Date getRentDate() {
        return rentDate;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    public Borrows(){}

    public String getBorrwer() {
        return borrwer;
    }

    public void setBorrwer(String borrwer) {
        this.borrwer = borrwer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public String toString()
    {
        return "[id='"+id+'\''+
                "대여자='"+borrwer+'\''+
                "대여일='"+rentDate+'\''+
                "책제목='"+title+'\''+
                "저자='"+writer+'\''+
                ",출판사='"+publisher+'\''+
                ",가격='"+price+'\''+
                ",분류='"+classification+'\''+
                ",대여여부="+isRented()+'\''+
                ']'+"\n";
    }
}
