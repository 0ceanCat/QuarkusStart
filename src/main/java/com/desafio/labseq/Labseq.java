package com.desafio.labseq;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class Labseq {
    private final List<Integer> cached = new ArrayList<>();

    {
        cached.add(0);
        cached.add(1);
        cached.add(0);
        cached.add(1);
    }

    public int getLabsqeValue(int n){
        int result;

        if (hasCache(n)){
            result = cached.get(n);
        }else {
            result = computeAndCache(n);
        }

        return result;
    }

    private int computeAndCache(int n){
        int result = 0;
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

    private void cache(int v){
        cached.add(v);
    }

    private int compute(int n) {
        return cached.get(n - 4) + cached.get(n - 3);
    }

    private boolean hasCache(int n){
        // e.g: if n is zero, and it has already been cached,
        // the size of the list has to be at least `0 + 1` = 1
        return cached.size() >= n + 1;
    }
}
