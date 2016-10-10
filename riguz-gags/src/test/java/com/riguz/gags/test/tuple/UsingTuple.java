package com.riguz.gags.test.tuple;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.riguz.gags.tuple.Pair;

public class UsingTuple {

    @Test
    public void usingTuple() {
        Pair<String, String> pair = Pair.of("Hello", "World");
        assertEquals("Hello", pair.getLeft());
        assertEquals("World", pair.getRight());
    }

}
