package org.litesoft.utils;

import java.time.Instant;
import java.util.function.Function;

/**
 * Mapper that bidirectionally converts a ISO-8601(ish) timestamp String to/from an Instant with timestamp resolution of: Hour
 * <p>
 * Note: All String outputs are in Zulu/UTC and conforms with the rules defined in <code>ISO8601ZtimeStamp</code>!
 */
class AbstractISO8601Zmapper implements ISO8601ZMapper {
    private final Function<ISO8601ZtimeStamp, ISO8601ZtimeStamp> sizer;

    protected AbstractISO8601Zmapper( Function<ISO8601ZtimeStamp, ISO8601ZtimeStamp> sizer ) {
        this.sizer = sizer;
    }

    @Override
    public String from( Instant instant ) {
        if ( instant == null ) {
            return null;
        }
        return sizer.apply( ISO8601ZtimeStamp.fromEpochMillis( instant.toEpochMilli() ) ).toString();
    }

    @Override
    public Instant from( String iso8601ish ) {
        if ( iso8601ish != null ) {
            iso8601ish = iso8601ish.trim();
            if ( !iso8601ish.isEmpty() ) {
                ISO8601ZtimeStamp ts = ISO8601ZtimeStamp.fromString( iso8601ish );
                ts = sizer.apply( ts ); // drop extra digits
                ts = ts.toMillis(); // pad out zeros for Instant parsing
                return Instant.parse( ts.toString() );
            }
        }
        return null;
    }
}
