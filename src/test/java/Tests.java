import models.requestModels.UserRequest;
import steps.BaseTest;

import models.responseModels.*;
import models.requestModels.*;
import org.testng.annotations.Test;

public class Tests extends BaseTest {
    @Test(description = "Получение списка пользователей")
    public void getUserList() {
        UserListResponse user = USER_STEPS.getUserList(200);
        System.out.println(user);
    }
    @Test(description = "Получение пользователя по id")
    public void getUserById() {
        UserResponse user = USER_STEPS.getUserById(2, 200);
        System.out.println(user);
    }
    @Test(description = "Проверка несуществующего пользователя")
    public void getUserDoesNotExist() {
        UserResponse user = USER_STEPS.getUserDoesNotExist(404);
        System.out.println(user);
    }
    @Test(description = "Получение списка неизвестных пользователя")
    public void getResourceListResponse() {
        ResourceListResponse user = USER_STEPS.getResourceListResponse(200);
        System.out.println(user);
    }
    @Test(description = "Получение неизвестного пользователя по id")
    public void getResourceResponse() {
        ResourceResponse user = USER_STEPS.getResourceResponse(2, 200);
        System.out.println(user);
    }
    @Test(description = "Проверка несуществующего, неизвестного пользователя")
    public void getResourceDoesNotExist() {
        ResourceResponse user = USER_STEPS.getResourceDoesNotExist(404);
        System.out.println(user);
    }
    @Test(description = "Создание пользователя")
    public void postCreateUser() {
        UserRequest login = new UserRequest("morpheus", "leader");
        CreatedUserResponse user = USER_STEPS.postCreateUser(login, 201);
        System.out.println(user);
    }
    @Test(description = "Изменение пользователя")
    public void putСhangeUser() {
        UserRequest login = new UserRequest("morpheus", "zion resident");
        СhangedUserResponse user = USER_STEPS.putСhangeUser(login, 200);
        System.out.println(user);
    }
    @Test(description = "Изменение пользователя 2.0")
    public void patchСhangeUser() {
        UserRequest login = new UserRequest("morpheus", "zion resident");
        СhangedUserResponse user = USER_STEPS.patchСhangeUser(login, 200);
        System.out.println(user);
    }
    @Test(description = "Удаление пользователя")
    public void deleteUser() {
        USER_STEPS.deleteUser(204);
    }
    @Test(description = "Успешная регистрация")
    public void postSuccessfulRegister() {
        AuthorizationRequest login = new AuthorizationRequest("eve.holt@reqres.in", "pistol");
        SuccessfulAuthorizationResponse user = USER_STEPS.postSuccessfulRegister(login, 200);
        System.out.println(user);
    }
    @Test(description = "Не успешная регистрация")
    public void postUnsuccessfulRegister() {
        AuthorizationRequest login = new AuthorizationRequest("sydney@fife", null);
        UnSuccessfulRegisterResponse user = USER_STEPS.postUnsuccessfulRegister(login, 400);
        System.out.println(user);
    }
    @Test(description = "Успешная авторизация")
    public void postSuccessfulLogin() {
        AuthorizationRequest login = new AuthorizationRequest("eve.holt@reqres.in", "cityslicka");
        SuccessfulAuthorizationResponse user = USER_STEPS.postSuccessfulLogin(login, 200);
        System.out.println(user);
    }
    @Test(description = "Не успешная авторизация")
    public void postUnsuccessfulLogin() {
        AuthorizationRequest login = new AuthorizationRequest("peter@klaven", null);
        UnSuccessfulLoginResponse user = USER_STEPS.postUnsuccessfulLogin(login, 400);
        System.out.println(user);
    }
    @Test(description = "Замедленная реакция")
    public void getDelayedResponse() {
        UserListResponse user = USER_STEPS.getDelayedResponse(200);
        System.out.println(user);
    }
}