package ro.paoo.exam.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SourceData {
    private final String sourceName;
    private final Map<String, Integer> metrics;

    public SourceData(String sourceName, Map<String, Integer> metrics) {
        this.sourceName = sourceName;
        this.metrics = new HashMap<>(metrics);
    }

    public String getSourceName() {
        return sourceName;
    }

    public Map<String, Integer> getMetrics() {
        return Collections.unmodifiableMap(metrics);
    }
}
