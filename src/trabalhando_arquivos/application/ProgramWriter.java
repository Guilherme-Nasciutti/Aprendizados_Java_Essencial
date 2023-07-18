package trabalhando_arquivos.application;

import java.io.*;

public class ProgramWriter {
    public static void main(String[] args) {

        String[] lines = new String[]{"Good morning", "Good afternoon", "Good night"};

        String path = "C:\\temp\\out.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (
                IOException error) {
            error.printStackTrace();
        }
    }
}

