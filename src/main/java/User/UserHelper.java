package User;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserHelper {

    public static Response loginUser(User user) {
        return given()
                .header("Content-type", "application/json")
                .body(user)
                .when()
                .post(Constants.LOGIN_ENDPOINT);
    }

    public static Response createUser(User user) {
        return given()
                .header("Content-type", "application/json")
                .body(user)
                .when()
                .post(Constants.REGISTER_ENDPOINT);
    }


    public static Response deleteUser(String accessToken) {
        return given()
                .header("Authorization", accessToken)
                .when()
                .delete(Constants.USER_ENDPOINT);
    }
}
