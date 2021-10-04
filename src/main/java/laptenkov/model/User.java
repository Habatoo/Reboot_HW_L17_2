package laptenkov.model;

import java.io.Serializable;

/**
 * Класс описывает объект {@link User} с двумя полями
 * FirstName и LastName.
 */
public class User implements Serializable {

    private String userFirstName;
    private String userLastName;

    public User() {
        userFirstName = "";
        userLastName = "";
    }

    public User(String userFirstName, String userLastName) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }
}
