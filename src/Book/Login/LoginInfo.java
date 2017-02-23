package Book.Login;

/**
 * Created by ttinfo on 2017-02-23.
 */
public class LoginInfo {
    private boolean login;

    private String loginId;
    private boolean admin;

    public LoginInfo(){
        login=false;
        loginId="";
        admin=false;
    }

    public boolean isLogin() {
        return login;
    }

    void setLogin(boolean login) {
        this.login = login;
    }

    public String getLoginId() {
        return loginId;
    }

    void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public boolean isAdmin() {
        return admin;
    }

    void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
