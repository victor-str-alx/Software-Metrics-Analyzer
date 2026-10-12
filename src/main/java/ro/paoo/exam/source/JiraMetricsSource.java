package ro.paoo.exam.source;

import ro.paoo.exam.domain.SourceData;

import java.util.Map;

public class JiraMetricsSource implements MetricsSource {
    @Override
    public SourceData fetchData() {
        return new SourceData(
                "Jira",
                Map.of(
                        "ticketsCompleted", 43,
                        "bugsOpened", 5
                )
        );
    }
}
