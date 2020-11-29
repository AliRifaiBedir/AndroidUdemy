package com.example.retrofit_ornek_3.RestApi;

public class BaseManager {
    //Bu sınıf bize RestApi döndürüyor
    protected RestApi getRestApiClient(){
        //Protected yaparak altsınıf erişmesi sağlandı
        RestApiClient restApiClient=new RestApiClient(BaseUrl.url);
        return restApiClient.getRestApi();

    }

}
