package org.litesoft.utils;

import java.time.Instant;

/**
 * Mapper that bidirectionally converts a ISO-8601(ish) timestamp String to/from an Instant with a specific timestamp resolution
 * <p>
 * Note: All String outputs are in Zulu/UTC and conforms with the rules defined in <code>ISO8601ZtimeStamp</code>!
 */
public interface ISO8601ZMapper {
    String from( Instant instant );

    Instant from( String iso8601ish );

    default String normalize( String iso8601ish ) {
        return from( from( iso8601ish ) );
    }

    default Instant normalize( Instant instant ) {
        return from( from( instant ) );
    }
}
