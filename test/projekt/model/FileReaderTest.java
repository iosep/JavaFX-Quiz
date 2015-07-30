package projekt.model;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FileReaderTest {

    @Test
    public void testGetFileList() throws Exception {
        List<String> fileNames = FileReader.getFileList("test/projekt/data/img/player");

        assertNotNull(fileNames);

        fileNames.sort(null);

        assertEquals("Avengers-Agent-Coulson-icon.png", fileNames.get(0));
        assertEquals("Avengers-Black-Widow-icon.png", fileNames.get(1));
        assertEquals("Avengers-Captain-America-icon.png", fileNames.get(2));
        assertEquals("Avengers-Giant-Man-icon.png", fileNames.get(3));
    }
}