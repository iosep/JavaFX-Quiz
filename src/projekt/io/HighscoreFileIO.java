package projekt.io;

import projekt.MainApplication;
import projekt.model.Player;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Klasse zum Einlesen des Highscores aus einer Datei.
 */
public class HighscoreFileIO {
    private static final String SEPARATOR = "|";

    public static LinkedList<Player> parseScores(String path) throws IOException {
        LinkedList<Player> highscore = new LinkedList<>();

        File highscoreFile = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(highscoreFile));

        String line;
        Player player;
        int i = MainApplication.MAX_HIGHSCORE_SLOTS;
        int firstSeparatorIdx, lastSeperatorIdx, playerImgNum, playerScore;
        String playerName;

        while (i-- > 0 && (line = br.readLine()) != null) {
            // Sucht den Index des ersten und des letzten Trennzeichens, damit kein Fehler auftritt, sobald
            // ein Name das Trennzeichen enthält
            firstSeparatorIdx = line.indexOf(SEPARATOR);
            lastSeperatorIdx = line.lastIndexOf(SEPARATOR);

            playerImgNum = Integer.parseInt(line.substring(0, firstSeparatorIdx));
            playerName = line.substring(firstSeparatorIdx + 1, lastSeperatorIdx);
            playerScore = Integer.parseInt(line.substring(lastSeperatorIdx + 1));
            player = new Player(playerImgNum, playerName, playerScore);
            highscore.add(player);
        }

        br.close();

        return highscore;
    }

    public static void writeScores(String path, LinkedList<Player> players) throws IOException {
        File highscoreFile = new File(path);
        BufferedWriter bw = new BufferedWriter(new FileWriter(highscoreFile, false));

        int i = 0;
        Iterator<Player> playerIterator = players.iterator();
        Player player;
        while (i < MainApplication.MAX_HIGHSCORE_SLOTS && playerIterator.hasNext()) {
            player = playerIterator.next();
            bw.write(player.getImageNum() + "|" + player.getName() + "|" + player.getScore());
            bw.newLine();
            i++;
        }

        bw.close();
    }

}
