package org.litesoft.utils;

/**
 * Mapper that bidirectionally converts a ISO-8601(ish) timestamp String to/from an Instant with timestamp resolution of: Hour
 * <p>
 * Note: All String outputs are in Zulu/UTC and conforms with the rules defined in <code>ISO8601ZtimeStamp</code>!
 */
public class ISO8601ZhhMapper extends AbstractISO8601Zmapper {
    public static final ISO8601ZhhMapper INSTANCE = new ISO8601ZhhMapper();

    private ISO8601ZhhMapper() {
        super( ISO8601ZtimeStamp::toHour );
    }
}
