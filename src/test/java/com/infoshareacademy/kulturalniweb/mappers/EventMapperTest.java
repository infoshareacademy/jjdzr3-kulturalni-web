package com.infoshareacademy.kulturalniweb.mappers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventMapperTest {

    @Test
    public void testIfEndDateConvertedToDateTimeAndLastTime() {
        String[] result = EventMapper.divideTimeIntoPieces("2021-03-22T06:40:00-05:00");

        assertEquals("2021-03-22", result[0]);
        assertEquals("06:40:00", result[1]);
        assertEquals("05:00", result[2]);
    }
}
