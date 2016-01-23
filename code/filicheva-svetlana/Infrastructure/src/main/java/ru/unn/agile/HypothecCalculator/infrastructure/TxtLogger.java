package ru.unn.agile.HypothecCalculator.infrastructure;

import ru.unn.agile.HypothecCalculator.viewmodel.ILogger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class TxtLogger implements ILogger {
    private final FileWriter writer;
    private final String filename;
    private static final String DATE_FORMAT_NOW = "dd-MM-yyyy HH:mm:ss";

    public TxtLogger(final String filename) {
        this.filename = filename;

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filename);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        writer = fileWriter;
    }

    @Override
    public List<String> getLog() {
        ArrayList<String> log = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String logLine = reader.readLine();

            while (logLine != null) {
                log.add(logLine);
                logLine = reader.readLine();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return log;
    }

    @Override
    public void addMessage(final String message) {
        try {
            writer.write(currentTime() + " > " + message);
            writer.write("\n");
            writer.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static String currentTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT_NOW, Locale.ENGLISH);
        return simpleDateFormat.format(calendar.getTime());
    }
}
