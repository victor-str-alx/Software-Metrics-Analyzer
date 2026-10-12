package ro.paoo.exam.factory;

import ro.paoo.exam.source.GitMetricsSource;
import ro.paoo.exam.source.JiraMetricsSource;
import ro.paoo.exam.source.MetricsSource;
import ro.paoo.exam.source.SonarMetricsSource;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class MetricsSourceFactory {
    private final Map<String, Supplier<MetricsSource>> registry = new HashMap<>();

    public MetricsSourceFactory() {
        register("git", GitMetricsSource::new);
        register("jira", JiraMetricsSource::new);
        register("sonar", SonarMetricsSource::new);
    }

    public void register(String key, Supplier<MetricsSource> creator) {
        registry.put(key.toLowerCase(), creator);
    }

    public MetricsSource create(String key) {
        Supplier<MetricsSource> creator = registry.get(key.toLowerCase());
        if (creator == null) {
            throw new IllegalArgumentException("Unknown metrics source: " + key);
        }
        return creator.get();
    }
}
