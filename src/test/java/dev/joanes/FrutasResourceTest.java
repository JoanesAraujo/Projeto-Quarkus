package dev.joanes;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import javax.inject.Inject;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@TestHTTPEndpoint(FrutasResource.class)
public class FrutasResourceTest {

    @Inject
    FrutasService frutasService;

    @Test
    public void testeListFrutas() {
        given()
                .when().get()
                .then()
                .statusCode(200)
                .body(is("[{\"id\":1,\"nome\":\"Maçã\",\"qtd\":6},{\"id\":2,\"nome\":\"Pêra\",\"qtd\":4},{\"id\":3,\"nome\":\"Laranja\",\"qtd\":8}]"));
    }

    @Test
    public void testeListFrutas2() {
        List<Fruta> list = frutasService.list();
        assertFalse(list.isEmpty());
    }
}