package API_Tests.Bookstore;
import Testbase.API_Connections.BookstoreConnection;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class Basic_Tests extends BookstoreConnection {

    @Test
    public void GetBookDetails(){
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "");

        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response=>" + response.prettyPrint());
    }

    @Test
    public void GetStatusCode(){
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get();
        int statusCode = response.getStatusCode();

        Assert.assertEquals(200, statusCode);
        System.out.println("Status code: " + statusCode);
    }

    @Test
    public void GetHeaders(){
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get();
        Headers allHeaders = response.headers();

        for(Header header : allHeaders){
            System.out.println("Key: " + header.getName() + " --- Value: " + header.getValue());
        }
    }

    @Test
    public void GetSpecificHeaderValues(){
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get();
        String contentType = response.header("Content-Type");
        String connection = response.header("Connection");

        System.out.println("Content Type Value: " + contentType);
        Assert.assertEquals("application/json; charset=utf-8", contentType);
        System.out.println("Connection Value: " + connection);
        Assert.assertEquals("keep-alive",connection);
    }

    @Test
    public void ResponseBodyValidation(){
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get();
        ResponseBody body = response.getBody();
        String bodyAsString = body.asString();

        System.out.println(bodyAsString);
        Assert.assertTrue(bodyAsString.contains("Git Pocket Guide"));
    }




}
