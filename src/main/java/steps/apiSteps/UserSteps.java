package steps.apiSteps;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import models.responseModels.*;
import models.requestModels.*;

import static io.restassured.RestAssured.given;

public class UserSteps {
    @Step ("Получить список пользователей")
    public UserListResponse getUserList (Integer statusCode) {
        return given()
                .baseUri("https://reqres.in")
                .get("/api/users?page=2")
                .then()
                .assertThat()
                .statusCode(statusCode)
                .extract()
                .response().as(UserListResponse.class);
    }
    @Step ("Получить пользователя по id")
    public UserResponse getUserById (Integer id, Integer statusCode) {
        return given()
                .baseUri("https://reqres.in")
                .get("/api/users/" + id)
                .then()
                .assertThat()
                .statusCode(statusCode)
                .extract()
                .response().as(UserResponse.class);
    }
    @Step ("Получить несуществующего пользователя")
    public UserResponse getUserDoesNotExist (Integer statusCode) {
        return given()
                .baseUri("https://reqres.in")
                .get("/api/users/23")
                .then()
                .assertThat()
                .statusCode(statusCode)
                .extract()
                .response().as(UserResponse.class);
    }
    @Step ("Получить список неизвестных пользователей")
    public ResourceListResponse getResourceListResponse (Integer statusCode) {
        return given()
                .baseUri("https://reqres.in")
                .get("/api/unknown")
                .then()
                .assertThat()
                .statusCode(statusCode)
                .extract()
                .response().as(ResourceListResponse.class);
    }
    @Step ("Получить список неизвестных пользователей")
    public ResourceResponse getResourceResponse (Integer id, Integer statusCode) {
        return given()
                .baseUri("https://reqres.in")
                .get("/api/unknown/" + id)
                .then()
                .assertThat()
                .statusCode(statusCode)
                .extract()
                .response().as(ResourceResponse.class);
    }
    @Step ("Получить несуществующего пользователя")
    public ResourceResponse getResourceDoesNotExist (Integer statusCode) {
        return given()
                .baseUri("https://reqres.in")
                .get("/api/users/23")
                .then()
                .assertThat()
                .statusCode(statusCode)
                .extract()
                .response().as(ResourceResponse.class);
    }
    @Step ("Создать нового пользователя")
    public CreatedUserResponse postCreateUser (UserRequest UR, Integer statusCode) {
        return given()
                .baseUri("https://reqres.in")
                .body(UR)
                .contentType(ContentType.JSON)
                .post("/api/users")
                .then()
                .assertThat()
                .statusCode(statusCode)
                .extract()
                .response().as(CreatedUserResponse.class);
    }
    @Step ("Изменить существующего пользователя")
    public СhangedUserResponse putСhangeUser (UserRequest UR, Integer statusCode) {
        return given()
                .baseUri("https://reqres.in")
                .body(UR)
                .contentType(ContentType.JSON)
                .put("/api/users/2")
                .then()
                .assertThat()
                .statusCode(statusCode)
                .extract()
                .response().as(СhangedUserResponse.class);
    }
    @Step ("Изменить существующего пользователя 2.0")
    public СhangedUserResponse patchСhangeUser (UserRequest UR, Integer statusCode) {
        return given()
                .baseUri("https://reqres.in")
                .body(UR)
                .contentType(ContentType.JSON)
                .patch("/api/users/2")
                .then()
                .assertThat()
                .statusCode(statusCode)
                .extract()
                .response().as(СhangedUserResponse.class);
    }
    @Step ("Удалить существующего пользователя")
    public void deleteUser (Integer statusCode) {
        given()
                .baseUri("https://reqres.in")
                .delete("/api/users/2")
                .then()
                .assertThat()
                .statusCode(statusCode)
                .extract()
                .response();
    }
    @Step ("Успешно зарегистрироваться")
    public SuccessfulAuthorizationResponse postSuccessfulRegister (AuthorizationRequest SRR, Integer statusCode) {
        return given()
                .baseUri("https://reqres.in")
                .body(SRR)
                .contentType(ContentType.JSON)
                .post("/api/register")
                .then()
                .assertThat()
                .statusCode(statusCode)
                .extract()
                .response().as(SuccessfulAuthorizationResponse.class);
    }
    @Step ("Не зарегистрироваться")
    public UnSuccessfulRegisterResponse postUnsuccessfulRegister (AuthorizationRequest USRR, Integer statusCode){
        return given()
                .baseUri("https://reqres.in")
                .body(USRR)
                .contentType(ContentType.JSON)
                .post("/api/register")
                .then()
                .assertThat()
                .statusCode(statusCode)
                .extract()
                .response().as(UnSuccessfulRegisterResponse.class);
    }
    @Step ("Авторизоваться")
    public SuccessfulAuthorizationResponse postSuccessfulLogin (AuthorizationRequest SLR, Integer statusCode) {
        return given()
                .baseUri("https://reqres.in")
                .body(SLR)
                .contentType(ContentType.JSON)
                .post("/api/login")
                .then()
                .assertThat()
                .statusCode(statusCode)
                .extract()
                .response().as(SuccessfulAuthorizationResponse.class);
    }
    @Step ("Не авторизоваться")
    public UnSuccessfulLoginResponse postUnsuccessfulLogin (AuthorizationRequest USLR, Integer statusCode) {
        return given()
                .baseUri("https://reqres.in")
                .body(USLR)
                .contentType(ContentType.JSON)
                .post("/api/login")
                .then()
                .assertThat()
                .statusCode(statusCode)
                .extract()
                .response().as(UnSuccessfulLoginResponse.class);
    }
    @Step ("Получить список пользователей с замедленной реакцией")
    public UserListResponse getDelayedResponse (Integer statusCode) {
        return given()
                .baseUri("https://reqres.in")
                .get("/api/users?delay=3")
                .then()
                .assertThat()
                .statusCode(statusCode)
                .extract()
                .response().as(UserListResponse.class);
    }
}