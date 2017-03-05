package Book.BookAPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Book.DB.BookManageDB;

/**
 * 책 장부를 구성한다
 */
public class BookCenter
{

    //todo 싱글턴(인스턴스
    private List<Books> booklist;
    private HashMap bookmap;
    BookIdAdd IdAdd=new BookIdAdd();

    BookManageDB bookManageDB = new BookManageDB ();


    /**
     * 책장부를 생성
     */
    public BookCenter()
    {
        booklist = new ArrayList<>();
        bookmap=new HashMap();
    }

    /**
     * 책 고유 아이디를 생성한다
     * @param book
     */
    public void addBook(Books book)
    {
            IdAdd.bookIdAdd(book);
            booklist.add(book);

    }
    public void books(){
        /*Books book1=new Books();
        book1.setId("0001");
        book1.setPublisher("디즈니");
        book1.setClassification("동화");
        book1.setPrice("1000");
        book1.setRented(false);
        book1.setTitle("백설공주");
        book1.setWriter("월트 디즈니");
        booklist.add(book1);

        Books book2=new Books();
        book2.setId("0002");
        book2.setPublisher("디즈니");
        book2.setClassification("동화");
        book2.setPrice("2000");
        book2.setRented(false);
        book2.setTitle("신데렐라");
        book2.setWriter("월트 디즈니");
        booklist.add(book2);*/

    }

    /**
     * 책장부의 복사본을 표출 본 장부는 감출필요가 있음
     * @return
     */
    public List<Books> getBooks()
    {
        List<Books> list = new ArrayList<>();
        try
        {
            Connection conn = bookManageDB.makeConnect ();

            String sql = "select * from Books";                        // sql 쿼리
            PreparedStatement pStmt = conn.prepareStatement (sql);// prepareStatement에서 해당 sql을 미리 컴파일한다.
            // pStmt.setString (1, "test");

            ResultSet rs = pStmt.executeQuery ();// 쿼리를 실행하고 결과를 ResultSet 객체에 담는다.

            while (rs.next ())
            {                                                        // 결과를 한 행씩 돌아가면서 가져온다.
                list.add (new Books (rs));
            }

            rs.close ();

            conn.close ();

        }
         catch(Exception ex)
         {
         }



        return list;
    }

    /**
     * 책의 제목을 찾아 지운다
     * @param removetitle
     * @return 지워지면 true
     */
    public boolean bookremove(String removetitle)
    {
        for(Books removeList:booklist) {
            if(removeList.getTitle().equals(findBytitle(removetitle)))
            booklist.remove(removetitle);
        }
        return true;
    }

    /**
     * 책의 고유 id을 찾아 지운다
     * @param id
     * @return
     */
    public boolean remove(String id){
        for(Books book:booklist){
            if(id.equals(book.getId())) {
                booklist.remove(book);
                return true;
            }
        }
        return false;
    }

    /**
     * 각각 책의 제목 작자 아이디 출판사를 검색할수 있게 한다
     * @param element
     * @param keyWord
     * @return
     */
    private List<Books> search(String element,String keyWord)
    {
        List<Books>findList=new ArrayList<>();

        for(Books listBook:booklist)
        {
            String searchKey="";
            if(element.equals("title"))
                searchKey=listBook.getTitle();
            if(element.equals("writer"))
                searchKey=listBook.getWriter();
            if(element.equals("publisher"))
                searchKey=listBook.getPublisher();
            if(element.equals("id"))
                searchKey=listBook.getId();
            if(searchKey!=null&&searchKey.contains(keyWord))
                findList.add(listBook);
        }
        return findList;
    }
    //제목으로 찾기
    public List<Books> findBytitle(String title)
    {
        return search("title",title);
    }

    //작가로 찾기
    public List<Books>findBywriter(String writer)
    {
        return search("writer",writer);
    }

    //출판사로 찾기
    public List<Books>findBypublisher(String publisher)
    {
        return search("publisher",publisher);
    }
    //아이디로 찾기
    public List<Books>findById(String id){return search("id",id);}

    //책이 빌려갔다는 메소드
    public void borrowBook(String id){
        for(Books borrow :booklist){
            if(id.equals(borrow.getId())){
                borrow.setRented(true);
            }
        }
    }
    public void ReturnBook(String id){
        for(Books books :booklist){
            if(id.equals(books.getId())){
                books.setRented(false);
            }
        }
    }
    /**
     * 분류별로 보여주기(HashMap)
     * @param classification
     */
    public HashMap phoneBook=new HashMap();

    public void addClassification(String classification){
        if(!bookmap.containsKey(classification))
            bookmap.put(classification,new HashMap());
    }
    public void addBookNo(String classification,String title,String writer,String publisher,String price,String id){
        addClassification(classification);
        HashMap group=(HashMap)bookmap.get(classification);
        group.put(id,title);
    }

    public void printList(){
        Set set =phoneBook.entrySet();
        Iterator it=set.iterator();

        while(it.hasNext()){
            Map.Entry e=(Map.Entry)it.next();

            Set subSet=((HashMap)e.getValue()).entrySet();
            Iterator subIt=subSet.iterator();

            System.out.println("*"+e.getKey()+"["+subSet.size()+"]");

            while(subIt.hasNext()){
                Map.Entry subE=(Map.Entry)subIt.next();
                String telNo=(String)subE.getKey();
                String name=(String)subE.getValue();
                System.out.println(name+""+telNo);
            }
            System.out.println();
        }
    }


}

