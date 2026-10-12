package ro.paoo.exam.strategy;

import ro.paoo.exam.domain.MetricReport;
import ro.paoo.exam.domain.SourceData;

import java.util.List;

public interface AnalysisStrategy {
    MetricReport analyze(List<SourceData> sourceDataList);
}
