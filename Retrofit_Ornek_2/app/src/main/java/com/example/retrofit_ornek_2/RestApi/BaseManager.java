package com.example.retrofit_ornek_2.RestApi;

public class BaseManager {
    //Protected yaptık çünkü kalıtım alınca onu da alacağız

    protected RestApi getRestpiClient(){
        RestApiClient restApiClient=new RestApiClient(BaseUrl.url_bilgi);
        return restApiClient.getRestApi();

    }
}
