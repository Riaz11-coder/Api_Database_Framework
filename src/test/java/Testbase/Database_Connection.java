package Testbase;

import Utility.ConfigurationReader;
import Utility.DB_Utility;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.*;

public class Database_Connection {

    @BeforeAll
    public static void setUpDatabase(){

        baseURI = ConfigurationReader.getProperty("");
        basePath = ConfigurationReader.getProperty("");
//      create DB Connection here
        DB_Utility.createConnection(ConfigurationReader.getProperty("example.url"),
                ConfigurationReader.getProperty("example.username"),
                ConfigurationReader.getProperty("example.password")
        );
        DB_Utility.createDatabaseConnection();
    }

    @AfterAll
    public static void tearDown(){
        reset();
        // destroy DB Connection here
//        DB_Utility.destroy();
    }
}
