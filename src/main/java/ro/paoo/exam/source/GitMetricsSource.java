package ro.paoo.exam.source;

import ro.paoo.exam.domain.SourceData;

import java.util.Map;

public class GitMetricsSource implements MetricsSource {
    @Override
    public SourceData fetchData() {
        return new SourceData(
                "Git",
                Map.of(
                        "commits", 124,
                        "activeContributors", 7
                )
        );
    }
}
