package demo.pages;

public class LoginPage extends BasePage {

    public void enterUsername(String username) {
        findById("user-name").sendKeys(username);
    }

    public void enterPassword(String password) {
        findById("password").sendKeys(password);
    }
}
