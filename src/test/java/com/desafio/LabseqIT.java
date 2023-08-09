package com.desafio;


import com.desafio.labseq.Labseq;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

@QuarkusTest
public class LabseqIT {

    @Inject
    Labseq labseq;

    private final List<BigInteger> initialValues
            = List.of(BigInteger.ZERO, BigInteger.ONE, BigInteger.ZERO, BigInteger.ONE);

    @Test
    void givenUncachedIndex_afterCompute_returnSolution() {
        int unCached = 4; // out of initialValues
        BigInteger solution = labseq.getLabsqeValue(unCached);

        BigInteger realSolution = initialValues.get(unCached - 4)
                                .add(initialValues.get(unCached - 3));

        Assertions.assertEquals(realSolution, solution);
    }

    @Test
    void givenUncachedBigIndex_afterCompute_returnSolution() {
        int unCached = 1000;
        BigInteger solution = labseq.getLabsqeValue(unCached);

        BigInteger realSolution = labseq.getLabsqeValue(unCached - 4)
                                .add(labseq.getLabsqeValue(unCached - 3));

        Assertions.assertEquals(realSolution, solution);
    }

    @Test
    void givenCachedIndex_returnCachedSolution() {
        int cached = 3; // Labseq initially contains 4 cached elements

        BigInteger solution = labseq.getLabsqeValue(cached);

        BigInteger realSolution = initialValues.get(cached);

        Assertions.assertEquals(realSolution, solution);
    }

}
