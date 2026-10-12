package ro.paoo.exam.strategy;

import ro.paoo.exam.domain.MetricReport;
import ro.paoo.exam.domain.SourceData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SumAnalysisStrategy implements AnalysisStrategy {
    @Override
    public MetricReport analyze(List<SourceData> sourceDataList) {
        Map<String, Integer> aggregated = new HashMap<>();
        for (SourceData sourceData : sourceDataList) {
            for (Map.Entry<String, Integer> entry : sourceData.getMetrics().entrySet()) {
                aggregated.merge(entry.getKey(), entry.getValue(), Integer::sum);
            }
        }
        return new MetricReport("SumAnalysis", aggregated);
    }
}
