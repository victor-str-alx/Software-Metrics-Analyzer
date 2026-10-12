package ro.paoo.exam.service;

import ro.paoo.exam.domain.MetricReport;
import ro.paoo.exam.observer.ReportObserver;

import java.util.ArrayList;
import java.util.List;

public class ReportPublisher {
    private final List<ReportObserver> observers = new ArrayList<>();

    public void subscribe(ReportObserver observer) {
        observers.add(observer);
    }

    public void notifyAllObservers(MetricReport report) {
        for (ReportObserver observer : observers) {
            observer.onReportGenerated(report);
        }
    }
}
