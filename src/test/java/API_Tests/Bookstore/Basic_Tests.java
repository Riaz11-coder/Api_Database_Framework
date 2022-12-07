package API_Tests.Bookstore;

import Testbase.API_Connections.BookstoreConnection;
import Utility.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

public class Basic_Tests extends BookstoreConnection {

    @Test
    public void GetBookDetails(){

        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "");

        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response=>" + response.prettyPrint());

    }



}
