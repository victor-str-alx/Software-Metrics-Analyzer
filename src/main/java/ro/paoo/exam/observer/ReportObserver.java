package ro.paoo.exam.observer;

import ro.paoo.exam.domain.MetricReport;

public interface ReportObserver {
    void onReportGenerated(MetricReport report);
}
