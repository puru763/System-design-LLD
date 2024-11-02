import java.util.ArrayList;
import java.util.List;

public class MaintenanceLog {
    private final List<String> logs;

    public MaintenanceLog() {
        this.logs = new ArrayList<>();
    }

    public void addLog(String log) {
        logs.add(log);
        System.out.println(log);
    }

    public List<String> getLogs() {
        return logs;
    }
}
