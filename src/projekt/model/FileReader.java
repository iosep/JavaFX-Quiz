package projekt.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasse zum Lesen von Verzeichnissen und Dateien.
 */
public class FileReader {

    /**
     * Liest alle Dateien in einem Verzeichnis und gibt die Pfade der Dateien als Liste mit Strings zurück.
     *
     * @param path Verzeichnis, das nach Dateinamen durchsucht werden soll.
     * @return Liste mit Dateinamen.
     */
    public static List<String> getFileList(String path) {

        List<String> fileNames = new ArrayList<>();
        File[] files = new File(path).listFiles();

        for (File file : files) {
            if (file.isFile()) {
                fileNames.add(file.getName());
            }
        }

        return fileNames;
    }
}
