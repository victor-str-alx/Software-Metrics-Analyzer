package ro.paoo.exam.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MetricReport {
    private final String strategyName;
    private final Map<String, Integer> aggregatedMetrics;

    public MetricReport(String strategyName, Map<String, Integer> aggregatedMetrics) {
        this.strategyName = strategyName;
        this.aggregatedMetrics = new HashMap<>(aggregatedMetrics);
    }

    public String getStrategyName() {
        return strategyName;
    }

    public Map<String, Integer> getAggregatedMetrics() {
        return Collections.unmodifiableMap(aggregatedMetrics);
    }
}
