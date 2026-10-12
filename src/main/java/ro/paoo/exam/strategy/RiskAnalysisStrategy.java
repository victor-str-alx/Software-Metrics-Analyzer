package ro.paoo.exam.strategy;

import ro.paoo.exam.domain.MetricReport;
import ro.paoo.exam.domain.SourceData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RiskAnalysisStrategy implements AnalysisStrategy {
    @Override
    public MetricReport analyze(List<SourceData> sourceDataList) {
        Map<String, Integer> raw = new HashMap<>();
        for (SourceData sourceData : sourceDataList) {
            for (Map.Entry<String, Integer> entry : sourceData.getMetrics().entrySet()) {
                raw.merge(entry.getKey(), entry.getValue(), Integer::sum);
            }
        }

        int riskScore = raw.getOrDefault("bugsOpened", 0) * 4
                + raw.getOrDefault("criticalIssues", 0) * 8
                + raw.getOrDefault("codeSmells", 0) / 2;

        Map<String, Integer> result = new HashMap<>(raw);
        result.put("riskScore", riskScore);
        return new MetricReport("RiskAnalysis", result);
    }
}
