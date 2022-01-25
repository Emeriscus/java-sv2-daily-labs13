package day05;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TransferAggregator {


    public List<TransferPerClient> readTransfers(Path path) {
        return summarize(readLines(path));
    }

    private List<String> readLines(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("File not found");
        }
    }

    private List<TransferPerClient> summarize(List<String> lines) {
        Map<String, TransferPerClient> transfers = new TreeMap<>();
        for (String actual : lines) {
            linesToTransfers(actual, transfers);
        }
        return new ArrayList<>(transfers.values());
    }

    private Map<String, TransferPerClient> linesToTransfers(String line, Map<String, TransferPerClient> transfers) {

        String[] parts = line.split(",");
        if (!transfers.containsKey(parts[0])) {
            transfers.put(parts[0], new TransferPerClient(parts[0]));
        }
        return null;
    }

}
