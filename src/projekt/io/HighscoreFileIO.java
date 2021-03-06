package projekt.io;

import projekt.MainApplication;
import projekt.model.Player;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Klasse zum Lesen und Schreiben des Highscores aus/in eine/r Datei.
 */
public class HighscoreFileIO {
    private static final String SEPARATOR = "|";

    /**
     * Liest alle Highscores aus der highscore-Datei und gibt dementsprechend eine Liste mit Spielerobjekten zurück.
     *
     * @return Highscoreliste mit Spieler-Objeken.
     * @throws IOException wenn die highscore-Datei nicht geladen werden kann.
     */
    public static LinkedList<Player> parseScores() throws IOException {
        LinkedList<Player> highscore = new LinkedList<>();

        File highscoreFile = new File(MainApplication.PATH_HIGHSCORE);
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

    /**
     * Schreibt alle Highscores in die highscore-Datei.
     *
     * @param players Liste mit Spielern, die in einen Highscore haben.
     * @throws IOException wenn die highscore-Datei nicht geladen werden kann.
     */
    public static void writeScores(LinkedList<Player> players) throws IOException {
        File highscoreFile = new File(MainApplication.PATH_HIGHSCORE);
        BufferedWriter bw = new BufferedWriter(new FileWriter(highscoreFile, false));

        if (players != null) {
            int i = 0;
            Iterator<Player> playerIterator = players.iterator();
            Player player;
            while (i < MainApplication.MAX_HIGHSCORE_SLOTS && playerIterator.hasNext()) {
                player = playerIterator.next();
                bw.write(player.getImageNum() + "|" + player.getName() + "|" + player.getScore());
                bw.newLine();
                i++;
            }
        }

        bw.close();
    }

}
