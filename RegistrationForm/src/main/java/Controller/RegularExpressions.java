package Controller;

public interface RegularExpressions {

    String NAME_UKRAINIAN = "^[А-ЩЬЮЯҐІЇЄ][а-щьюяґіїє']{1,20}$";
    String NAME_ENGLISH = "^[A-Z][a-z]{1,20}$";
    String LOGIN = "^[A-Za-z0-9_-]{8,20}$";


}
