package ru.yandex.javacannprocessorbug;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.pattern.ConverterKeys;
import org.apache.logging.log4j.core.pattern.LogEventPatternConverter;
import org.apache.logging.log4j.core.pattern.PatternConverter;

/**
 * Sample log4j 2 plugin that is processed by {@link org.apache.logging.log4j.core.config.plugins.processor.PluginProcessor}
 *
 * @author fitialovks
 */
@Plugin(name = "SomeLoggerPatternConverter", category = PatternConverter.CATEGORY)
@ConverterKeys({"yc"})
public final class SomeLoggerPatternConverter extends LogEventPatternConverter {

    private static final SomeLoggerPatternConverter INSTANCE =
            new SomeLoggerPatternConverter();

    /**
     * Private constructor.
     */
    private SomeLoggerPatternConverter() {
        super("Yandex Logger", "class name");
    }

    /**
     * Gets an instance of SomeLoggerPatternConverter.
     *
     * @param options options, may be null.
     * @return instance of pattern converter.
     */
    public static SomeLoggerPatternConverter newInstance(final String[] options) {
        return INSTANCE;
    }

    /**
     * Just append logger name
     */
    @Override
    public void format(final LogEvent event, final StringBuilder toAppendTo) {
        toAppendTo.append(event.getLoggerName());
    }
}
