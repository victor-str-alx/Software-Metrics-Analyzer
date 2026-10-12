package ro.paoo.exam;

import ro.paoo.exam.domain.MetricReport;
import ro.paoo.exam.factory.MetricsSourceFactory;
import ro.paoo.exam.observer.ConsoleReportObserver;
import ro.paoo.exam.service.MetricsAnalysisService;
import ro.paoo.exam.service.ReportPublisher;
import ro.paoo.exam.source.MetricsSource;
import ro.paoo.exam.strategy.AnalysisStrategy;
import ro.paoo.exam.strategy.RiskAnalysisStrategy;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MetricsSourceFactory sourceFactory = new MetricsSourceFactory();

        List<MetricsSource> sources = List.of(
                sourceFactory.create("git"),
                sourceFactory.create("jira"),
                sourceFactory.create("sonar")
        );

        AnalysisStrategy strategy = new RiskAnalysisStrategy();
        ReportPublisher publisher = new ReportPublisher();
        publisher.subscribe(new ConsoleReportObserver());

        MetricsAnalysisService service = new MetricsAnalysisService(strategy, publisher);
        MetricReport report = service.generateReport(sources);

        System.out.println("=== Generated Report ===");
        System.out.println("Strategy: " + report.getStrategyName());
        report.getAggregatedMetrics().forEach((key, value) ->
                System.out.println(key + ": " + value));
    }
}
