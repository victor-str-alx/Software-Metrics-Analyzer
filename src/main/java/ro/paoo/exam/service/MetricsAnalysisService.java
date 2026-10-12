package ro.paoo.exam.service;

import ro.paoo.exam.domain.MetricReport;
import ro.paoo.exam.domain.SourceData;
import ro.paoo.exam.source.MetricsSource;
import ro.paoo.exam.strategy.AnalysisStrategy;

import java.util.ArrayList;
import java.util.List;

public class MetricsAnalysisService {
    private final AnalysisStrategy analysisStrategy;
    private final ReportPublisher reportPublisher;

    public MetricsAnalysisService(AnalysisStrategy analysisStrategy, ReportPublisher reportPublisher) {
        this.analysisStrategy = analysisStrategy;
        this.reportPublisher = reportPublisher;
    }

    public MetricReport generateReport(List<MetricsSource> sources) {
        List<SourceData> dataList = new ArrayList<>();
        for (MetricsSource source : sources) {
            dataList.add(source.fetchData());
        }
        MetricReport report = analysisStrategy.analyze(dataList);
        reportPublisher.notifyAllObservers(report);
        return report;
    }
}
