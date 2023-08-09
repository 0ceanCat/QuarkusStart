package com.desafio.labseq;

import jakarta.enterprise.context.ApplicationScoped;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class Labseq {
    private final List<BigInteger> cached = new ArrayList<>();

    {
        cached.add(BigInteger.ZERO);
        cached.add(BigInteger.ONE);
        cached.add(BigInteger.ZERO);
        cached.add(BigInteger.ONE);
    }

    public BigInteger getLabsqeValue(int n){
        BigInteger result;

        if (hasCache(n)){
            result = cached.get(n);
        }else {
            result = computeAndCache(n);
        }

        return result;
    }

    private BigInteger computeAndCache(int n){
        BigInteger result = null;
        if (hasCache(n - 4)){
            result = compute(n);
        }else {
            for (int i = cached.size(); i <= n; i++) {
                result = compute(i);
                cache(result);
            }
        }
        return result;
    }

    private void cache(BigInteger v){
        cached.add(v);
    }

    private BigInteger compute(int n) {
        return cached.get(n - 4).add(cached.get(n - 3));
    }

    private boolean hasCache(int n){
        // e.g: if n is zero, and it has already been cached,
        // the size of the list has to be at least `0 + 1` = 1
        return cached.size() >= n + 1;
    }
}
