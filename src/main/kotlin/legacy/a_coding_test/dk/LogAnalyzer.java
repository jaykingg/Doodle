package legacy.a_coding_test.dk;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LogAnalyzer {
    public static void main(String[] args) {
        LogAnalyzer analyzer = new LogAnalyzer();
        String inputFileName = "input.log";
        String outputFileName = "output.log";

        try {
            LogData logData = analyzer.readLogData(inputFileName);
            AnalysisResult analysisResult = analyzer.analyzeLogData(logData);
            analyzer.writeAnalysisResult(outputFileName, analysisResult);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private LogData readLogData(String fileName) throws IOException {
        LogData logData = new LogData();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(line -> {
                String[] fields = line.substring(1, line.length() - 1).split("\\]\\[");
                if (fields.length == 4) {
                    LogInformation logInformation = getLogInformation(fields);
                    if (logInformation.statusCode == 200) {
                        logData.incrementApiKeyCount(logInformation.apiKey);
                        logData.incrementServiceIdCount(logInformation.serviceId);
                        logData.incrementBrowserCount(logInformation.browser);
                        logData.incrementTotalRequests();
                    }
                }
            });
        }
        return logData;
    }

    private LogInformation getLogInformation(String[] fields) {
        return new LogInformation(
                Integer.parseInt(fields[0]),
                fields[1].split("=")[1],
                fields[1].split("\\?")[0].split("/")[4],
                fields[2]
        );
    }

    private AnalysisResult analyzeLogData(LogData logData) {
        AnalysisResult result = new AnalysisResult();
        result.setMostCalledApiKey(calculateMostCalledApiKey(logData.getApiKeyCount()));
        result.setTopServiceIds(calculateTopServiceIds(logData.getServiceIdCount()));
        result.setBrowserUsage(calculateBrowserUsage(logData.getBrowserCount(), logData.getTotalRequests()));
        return result;
    }

    private String calculateMostCalledApiKey(Map<String, Integer> apiKeyCount) {
        AtomicReference<String> mostCalledApiKey = new AtomicReference<>("");
        apiKeyCount.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(entry -> mostCalledApiKey.set(entry.getKey()));
        return mostCalledApiKey.get();
    }

    private Map<String, Integer> calculateTopServiceIds(Map<String, Integer> serviceIdCount) {
        return serviceIdCount.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private Map<String, Integer> calculateBrowserUsage(Map<String, Integer> browserCount, int totalRequests) {
        Map<String, Integer> browserUsage = new HashMap<>();
        browserCount.forEach((browser, count) -> {
            int percentage = (int) ((double) count / totalRequests * 100);
            browserUsage.put(browser, percentage);
        });
        return browserUsage;
    }

    private void writeAnalysisResult(String outputFileName, AnalysisResult result) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            writer.write("최다 호출 API KEY\n");
            writer.write(result.getMostCalledApiKey() + "\n");

            writer.write("\n상위 3개의 API Service ID와 각각의 요청 수\n");
            result.getTopServiceIds().forEach((serviceId, count) -> {
                try {
                    writer.write(serviceId + ": " + count + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            writer.write("\n웹브라우저별 사용 비율\n");
            result.getBrowserUsage().forEach((browser, percentage) -> {
                try {
                    writer.write(browser + ": " + percentage + "%\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    static class LogInformation {
        int statusCode;
        String apiKey;
        String serviceId;
        String browser;

        public LogInformation(int statusCode, String apiKey, String serviceId, String browser) {
            this.statusCode = statusCode;
            this.apiKey = apiKey;
            this.serviceId = serviceId;
            this.browser = browser;
        }
    }

    static class LogData {
        private final Map<String, Integer> apiKeyCount = new HashMap<>();
        private final Map<String, Integer> serviceIdCount = new HashMap<>();
        private final Map<String, Integer> browserCount = new HashMap<>();
        private final AtomicInteger totalRequests = new AtomicInteger();

        public void incrementApiKeyCount(String apiKey) {
            apiKeyCount.put(apiKey, apiKeyCount.getOrDefault(apiKey, 0) + 1);
        }

        public void incrementServiceIdCount(String serviceId) {
            serviceIdCount.put(serviceId, serviceIdCount.getOrDefault(serviceId, 0) + 1);
        }

        public void incrementBrowserCount(String browser) {
            browserCount.put(browser, browserCount.getOrDefault(browser, 0) + 1);
        }

        public void incrementTotalRequests() {
            totalRequests.incrementAndGet();
        }

        public Map<String, Integer> getApiKeyCount() {
            return apiKeyCount;
        }

        public Map<String, Integer> getServiceIdCount() {
            return serviceIdCount;
        }

        public Map<String, Integer> getBrowserCount() {
            return browserCount;
        }

        public int getTotalRequests() {
            return totalRequests.get();
        }
    }

    static class AnalysisResult {
        private String mostCalledApiKey;
        private Map<String, Integer> topServiceIds;
        private Map<String, Integer> browserUsage;

        public String getMostCalledApiKey() {
            return mostCalledApiKey;
        }

        public void setMostCalledApiKey(String mostCalledApiKey) {
            this.mostCalledApiKey = mostCalledApiKey;
        }

        public Map<String, Integer> getTopServiceIds() {
            return topServiceIds;
        }

        public void setTopServiceIds(Map<String, Integer> topServiceIds) {
            this.topServiceIds = topServiceIds;
        }

        public Map<String, Integer> getBrowserUsage() {
            return browserUsage;
        }

        public void setBrowserUsage(Map<String, Integer> browserUsage) {
            this.browserUsage = browserUsage;
        }
    }
}
