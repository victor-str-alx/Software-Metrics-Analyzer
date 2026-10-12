package ro.paoo.exam.source;

import ro.paoo.exam.domain.SourceData;

import java.util.Map;

public class SonarMetricsSource implements MetricsSource {
    @Override
    public SourceData fetchData() {
        return new SourceData(
                "SonarQube",
                Map.of(
                        "codeSmells", 18,
                        "criticalIssues", 2
                )
        );
    }
}
