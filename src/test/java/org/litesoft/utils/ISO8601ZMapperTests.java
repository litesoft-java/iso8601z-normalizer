package org.litesoft.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ISO8601ZMapperTests {
    static String ISO8601_ISH = "2011-01-16T11:12:13.456789-1";

    @Test
    void normalize() {
        check( "2011-01-16T10:00:00Z", "2011-01-16T10Z", ISO8601ZhhMapper.INSTANCE );
        check( "2011-01-16T10:12:00Z", "2011-01-16T10:12Z", ISO8601ZhhmmMapper.INSTANCE );
        check( "2011-01-16T10:12:13Z", "2011-01-16T10:12:13Z", ISO8601ZhhmmssMapper.INSTANCE );
        check( "2011-01-16T10:12:13.456Z", "2011-01-16T10:12:13.456Z", ISO8601ZhhmmssmmmMapper.INSTANCE );
    }

    void check( String expectedInstantForm, String expectedForm, ISO8601ZMapper mapper ) {
        assertNull( mapper.normalize( (String)null ) );
        assertNull( mapper.normalize( " " ) );
        assertEquals( expectedForm, mapper.normalize( ISO8601_ISH ) );
        assertEquals( expectedInstantForm, mapper.normalize( mapper.from( ISO8601_ISH ) ).toString() );
    }
}