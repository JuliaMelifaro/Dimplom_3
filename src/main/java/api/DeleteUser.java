package api;

import api.pojo.LoginData;
import api.pojo.UserData;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class DeleteUser {
    public static void deletingUser(String email, String password){
        RestAssured.baseURI="https://stellarburgers.nomoreparties.site";
        UserData testUser = new UserData(email, password, "some");
        String token ="";
        if (password.length() >= 6) {token = given().header("Content-Type","application/json").body(testUser)
                .post("/api/auth/login").body().as(LoginData.class).getAccessToken().substring(7);}
        if (token != "") given().header("Content-Type","application/json").auth()
                .oauth2(token).delete("/api/auth/user");
    }
}
