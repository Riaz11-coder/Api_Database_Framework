package Testbase.API_Connections;

import Utility.ConfigurationReader;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

public class ZippopotamusConnection {

    @BeforeAll
    public static void setUpAPI(){

        baseURI = ConfigurationReader.getProperty("baseURI_ZIP");
        basePath = ConfigurationReader.getProperty("basePath_ZIP");
    }
}
