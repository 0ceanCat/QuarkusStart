package com.desafio;


import com.desafio.labseq.Labseq;
import com.desafio.labseq.dto.LabsqeDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class LabseqResourceIT {

    @Inject
    Labseq labseq;

    @Test
    void givenValidIndex_afterCompute_returnSolution() {
        int validIndex = 10;
        LabsqeDTO result = given()
                .when()
                .get(ApiPaths.BASE_PATH + ApiPaths.COMPUTE_LABSEQ, validIndex)
                .then()
                .statusCode(200)
                .extract()
                .body().as(LabsqeDTO.class);
        Assertions.assertEquals(result.getResult(), labseq.getLabsqeValue(validIndex).toString());
    }

    @Test
    void givenInValidIndex_returnBadRequest() {
        int inValidIndex = -10;
        given()
                .when()
                .get(ApiPaths.BASE_PATH + ApiPaths.COMPUTE_LABSEQ, inValidIndex)
                .then()
                .statusCode(400);
    }

}
