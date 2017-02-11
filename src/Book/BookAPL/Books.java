package Book.BookAPL;

/**
 * 책 관련 프로퍼티 관리
 */
public class Books {

    /**
     * 책의 고유값이 된다.
     */
    private String id;

    private String title;
    private String writer;
    private String publisher;
    private String price;
    private String classification;

    //북 초기화
    public Books(){}

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
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

    public String toString()
    {
        return "[책제목="+title+'\''+
                "저자='"+writer+'\''+
                ",출판사='"+publisher+'\''+
                ",가격='"+price+'\''+
                ",분류='"+classification+'\''+
                ']';
    }


}
