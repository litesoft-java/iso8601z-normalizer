package org.litesoft.utils;

/**
 * Mapper that bidirectionally converts a ISO-8601(ish) timestamp String to/from an Instant with timestamp resolution of: Hour:Minute:Second
 * <p>
 * Note: All String outputs are in Zulu/UTC and conforms with the rules defined in <code>ISO8601ZtimeStamp</code>!
 */
public class ISO8601ZhhmmssMapper extends AbstractISO8601Zmapper {
    public static final ISO8601ZhhmmssMapper INSTANCE = new ISO8601ZhhmmssMapper();

    private ISO8601ZhhmmssMapper() {
        super( ISO8601ZtimeStamp::toSecond );
    }
}
