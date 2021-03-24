package com.kirillirik;

import java.io.*;

public class TextCompare{

    private BufferedReader text; // Оригинальный текст
    private BufferedReader changedText; // Измененный текст

    public TextCompare(String[] args){
        loadFiles(args);
        compareFile();
    }

    /**
     * Загрузка файлов для сравнения.
     * В случае если в имени файла нет расширения файла
     * автоматически добавляется расширени '.txt'
     * @param args названия файлов
     */
    private void loadFiles(String[] args){
        try {
            String path = args[0];
            if (!path.contains(".txt")) path += ".txt";
            FileReader reader = new FileReader(path);
            text = new BufferedReader(reader);
        } catch (FileNotFoundException e) {
            System.out.println("File " + args[0] + " not loaded");
            return;
        }
        try {
            String path = args[1];
            if (!path.contains(".txt")) path += ".txt";
            FileReader reader = new FileReader(path);
            changedText = new BufferedReader(reader);
        } catch (FileNotFoundException e) {
            System.out.println("File " + args[1] + " not loaded");
        }
    }

    /**
     * Сравнение файлов в цикле
     */
    private void compareFile(){
        try {
            String first = text.readLine(); // Оригинальный текст
            String second = changedText.readLine(); // Измененный текст
            int i = 1;
            while (first != null && second != null){
                compareString(first, second, i);
                first = text.readLine();
                second = changedText.readLine();
                i++;
            }
        } catch (IOException exception) {
            System.out.println();
        }
        System.out.println("End of compare");
    }

    /**
     *  Сравнивает две строки, если они различаются
     *  то выводит номер строки и саму измененную строку
     * @param line номер строки
     */
    private void compareString(String first, String seconds, int line){
        if (first.equals(seconds)) return;
        System.out.println(line + ": " + seconds);
    }

    public static void main(String[] args) {
        if (args.length <= 1){
            System.out.println("Insert file names into program args");
            return;
        }
        new TextCompare(args);
    }
}
