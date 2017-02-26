package Book;

import Book.BookAPL.BookCenter;
import Book.Login.LoginCenter;
import Book.Member.MemberCenter;

/**
 * 메뉴 표출 및 연결
 */
public class Bookapp
{
	BookCenter bc = new BookCenter ();
	MemberCenter mc = new MemberCenter ();
	LoginCenter lc = new LoginCenter (mc);
	BookManagerLogin bm = new BookManagerLogin (lc, mc, bc);

	public void start ()
	{

		if (!lc.isLogin ())
		{
			bm.bookMangerLogin ();
			if (!lc.isLogin ())
			{
				return;
			}
		}
	}
}
