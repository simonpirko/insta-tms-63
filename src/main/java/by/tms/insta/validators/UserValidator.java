package by.tms.insta.validators;

import by.tms.insta.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserValidator {
    List<String>errorMessages=new ArrayList<>();

    public static final String USERNAME = "^[A-Za-z][A-Za-z0-9_]{2,16}$";
    public static final String PASSWORD = "^(?=\\d*)(?=[a-z]*)(?=[A-Z]*)(?=[\\W]*).{2,16}$";

    public static final String EMAIL = "^[\\w-]{2,16}@([\\w-]{2,5}\\.)+[\\w-]{2,4}$";

    public boolean isValid(User user) {
        return
                isUserNameValid(user.getUsername()) &&
                        isPasswordValid(user.getPassword()) &&
                        isEmailValid(user.getEmail());

    }

    private boolean isUserNameValid(String username) {
        if (!username.matches(USERNAME)) {
            errorMessages.add("Incorrect username");
            return false;
        }
        return true;

    }

    private boolean isPasswordValid(String password) {
        if (!password.matches(PASSWORD)) {
            errorMessages.add("Incorrect password");
            return false;
        }
        return true;

    }

    private boolean isEmailValid(String email) {
        if (!email.matches(EMAIL)) {
            errorMessages.add("Incorrect email");
            return false;
        }
        return true;
    }
}
