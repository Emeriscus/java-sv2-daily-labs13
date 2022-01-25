package day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TransferAggregatorByIstvan {

    public List<TransferPerClient> readTransfers(Path path) {
        List<String> lines = readLines(path);
        return summarize(lines);
    }

    private List<String> readLines(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("File not found", ioe);
        }
    }

    private List<TransferPerClient> summarize(List<String> lines) {
        Map<String, TransferPerClient> transfers = new TreeMap<>();
        for (String actual : lines) {
            String[] parts = actual.split(",");
            String sourceClientId = parts[0];
            String targetClientId = parts[1];
            int amount = Integer.parseInt(parts[2]);

//            TransferPerClient source = findOrInsert(transfers, sourceClientId);
            TransferPerClient source = transfers.computeIfAbsent(sourceClientId,
                    k -> new TransferPerClient(sourceClientId));                     // A fenti sor helyett.
            source.decrease(amount);

//            TransferPerClient target = findOrInsert(transfers, targetClientId);
            TransferPerClient target = transfers.computeIfAbsent(targetClientId,    // A fenti sor helyett.
                    k -> new TransferPerClient(sourceClientId));
            target.increase(amount);
        }
        return new ArrayList<>(transfers.values());
    }

//    private TransferPerClient findOrInsert(Map<String, TransferPerClient> transfers, String clientId) {
//        TransferPerClient result = transfers.get(clientId);
//        if (result == null) {
//            result = new TransferPerClient(clientId);
//            transfers.put(clientId, result);
//        }
//        return result;
//    }

    public static void main(String[] args) {
        TransferAggregatorByIstvan tr = new TransferAggregatorByIstvan();
        List<TransferPerClient> transfers = tr.readTransfers(Path.of("src/main/resources/transfers.csv"));

        for (TransferPerClient transfer : transfers) {
            System.out.printf("%s %,12d %5d\n", transfer.getClientId(), transfer.getSum(), transfer.getNumberOfTransaction());
        }
    }
}
