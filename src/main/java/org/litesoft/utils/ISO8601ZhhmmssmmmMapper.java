package org.litesoft.utils;

/**
 * Mapper that bidirectionally converts a ISO-8601(ish) timestamp String to/from an Instant with timestamp resolution of: Hour:Minute:Second.Millis
 * <p>
 * Note: All String outputs are in Zulu/UTC and conforms with the rules defined in <code>ISO8601ZtimeStamp</code>!
 */
public class ISO8601ZhhmmssmmmMapper extends AbstractISO8601Zmapper {
    public static final ISO8601ZhhmmssmmmMapper INSTANCE = new ISO8601ZhhmmssmmmMapper();

    private ISO8601ZhhmmssmmmMapper() {
        super( ISO8601ZtimeStamp::toMillis );
    }
}
