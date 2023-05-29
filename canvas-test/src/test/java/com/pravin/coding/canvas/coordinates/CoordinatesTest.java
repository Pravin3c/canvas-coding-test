package com.pravin.coding.canvas.coordinates;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class CoordinatesTest {

	@Test
    public void forEachShouldGoRowByRow() {
        List<String> recorded = new ArrayList<>();

        new Coordinates(3, 3).forEachDot((i, j) -> {
            recorded.add(i + "-" + j);
        });

        assertEquals(Arrays.asList(
                "0-0", "1-0", "2-0",
                "0-1", "1-1", "2-1",
                "0-2", "1-2", "2-2"
        ), recorded);
    }
}
