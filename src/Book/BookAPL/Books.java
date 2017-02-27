package Book.BookAPL;

import java.util.Date;

/**
 * 책 관련 프로퍼티 관리
 */
public class Books {
    private String title;
    private String writer;
    private String publisher;
    private String price;
    private String classification;
    private String id;
    private Date regDate;
    private boolean rented;

    //북 초기화
    public Books(){}

    public void books(){
        Books book1=new Books();
        setId("0001");
        setPublisher("디즈니");
        setClassification("동화");
        setPrice("1000");
        setTitle("백설공주");
        setWriter("월트 디즈니");

        Books book2=new Books();
        setId("0002");
        setPublisher("디즈니");
        setClassification("동화");
        setPrice("2000");
        setTitle("신데렐라");
        setWriter("월트 디즈니");

    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    //책 관련 인자들을 받고 내보낸다.
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

    public String getId(){return id;}

    public void setId(String id){
        this.id=id;
    }
    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String toString()
    {
        return "[id='"+id+'\''+
                "책제목='"+title+'\''+
                "저자='"+writer+'\''+
                ",출판사='"+publisher+'\''+
                ",가격='"+price+'\''+
                ",분류='"+classification+'\''+
                ",대여여부="+isRented()+'\''+
                ']'+"\n";
    }


}
