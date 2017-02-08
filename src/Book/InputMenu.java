package Book;

/**
 * 사용자가 입력된 메뉴
 *
 * Created by purre on 2017-01-22.
 */
public class InputMenu
{
    /**
     * 뒤로가기 상황인지 체크
     */
    private boolean back;

    /**
     * 뒤로가기가 아니면 입력된 메뉴 코드
     */
    private String menuCode;

    public InputMenu (boolean back)
    {
        this.back = back;
    }

    public InputMenu (boolean back, String menuCode)
    {
        this.back = back;
        this.menuCode = menuCode;
    }

    public boolean isBack ()
    {
        return back;
    }

    public String getMenuCode ()
    {
        return menuCode;
    }
}