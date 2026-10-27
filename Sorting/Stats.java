
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class Stats {

public static void main(String[] args) throws  IOException{
    long statTime = System.nanoTime();
    int arr[] = {
            893,
            999,
            231,
            1,
            0,
            11,
            929929,
            22222222,
            33333,
            21,
            1221,
            22,
    };
    // Call your sorting algorithm here
    CountSort.countsort(arr);
//     System.out.println(new File("stats.json").getAbsolutePath());
    String name = "";
    long endTime = System.nanoTime();
    long elapsed = endTime - statTime;
    String stats = """
            {
            "algorithm" : "%s",
            "elapsedNs": %d,
            "elapsedUs": %.3f,
            "elapsedMs": %.6f,
            "elapsedSeconds": %.9f

    }
            """.formatted(
                name,
                elapsed,
                elapsed/1_000.0,
                elapsed /1_000_000.0,
                elapsed /1_000_000_000.0
            );
        File file = new File("stats.json");
        try(FileWriter writer = new FileWriter(file)){
            writer.write(stats);
        }

    System.out.println();
    System.out.println("╔══════════════════════════════════════════╗");
    System.out.printf("║ %-42s ║%n", "          SORTING COMPLETE");
    System.out.println("╠══════════════════════════════════════════╣");
    System.out.printf("║ %-20s : %17d ║%n", "Time (nanoseconds)", elapsed);
    System.out.printf(
            "║ %-20s : %17.3f ║%n",
            "Time (microseconds)",
            elapsed / 1_000.0);
    System.out.printf(
            "║ %-20s : %17.6f ║%n",
            "Time (milliseconds)",
            elapsed / 1_000_000.0);
    System.out.printf(
            "║ %-20s : %17.9f ║%n",
            "Time (seconds)",
            elapsed / 1_000_000_000.0);
    System.out.println("╠══════════════════════════════════════════╣");
    System.out.printf("║ %-20s : %17s ║%n", "Timer", "System.nanoTime()");
    System.out.printf("║ %-20s : %17s ║%n", "Measurement", "Single run");
    System.out.println("╚══════════════════════════════════════════╝");
}
}
