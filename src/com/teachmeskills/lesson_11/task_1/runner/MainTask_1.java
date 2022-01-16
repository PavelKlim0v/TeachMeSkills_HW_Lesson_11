package com.teachmeskills.lesson_11.task_1.runner;

import com.teachmeskills.lesson_11.task_1.numberdocument.NumberDocument;
import java.io.*;
import java.util.Scanner;

/**
 *  Задание 1. (Основное задание)
 *    Допустим есть файл с номерами документов.
 *    Номером документа является строка, состоящая из букв и цифр(без служебных символов).
 *    Пусть этот файл содержит каждый номер документа с новой строки и в строке никакой другой информации,
 *       только номер документа.
 *    Валидный номер документа должен иметь длину 15 символов и начинаться с последовательности
 *       docnum(далее любая последовательность букв/цифр) или сontract(далее любая последовательность букв/цифр).
 *    Написать программу для чтения информации из входного файла - путь к входному файлу должен задаваться через консоль.
 *    Программа должна проверять номера документов на валидность.
 *    Валидные номера документов следует записать в один файл-отчет.
 *    Невалидные номера документов следует записать в другой файл-отчет, но после номеров документов следует добавить
 *       ифнформацию о том, почему этот документ невалиден.
 */

public class MainTask_1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Укажите путь к файлу: ");    // C:\Users\admin\Desktop\Lesson_11.txt
        String path = scan.nextLine();

        String numDoc;                                 // записываем вводимый номер документа
        String information;                            // информация о номере документа(если пусто,значит ошибок нет)
        String pathValidOutFile = "C:\\Users\\admin\\Desktop\\ValidOut.txt";
        String pathNotValidOutFile = "C:\\Users\\admin\\Desktop\\NotValidOut.txt";

             // из(C:\Users\admin\Desktop\Lesson_11.txt) будет считан номер документа
        try (FileInputStream fis = new FileInputStream(path);
             FileOutputStream validFos = new FileOutputStream(pathValidOutFile);// и сюда "номер док." будет записан
             FileOutputStream notValidFos = new FileOutputStream(pathNotValidOutFile);

             // (в данном случаее я подумал, что это будет улучшенная версия) потому, что читаем "номер док." целиком
             BufferedReader buffInFile = new BufferedReader(new InputStreamReader(fis));
             BufferedWriter buffOutFile1 = new BufferedWriter(new OutputStreamWriter(validFos));// записываем "номер док." целиком
             BufferedWriter buffOutFile2 = new BufferedWriter(new OutputStreamWriter(notValidFos))) {

            while ((numDoc = buffInFile.readLine()) != null) {
                information = NumberDocument.checkNumDoc(numDoc);
                if (information.isEmpty()) {
                    buffOutFile1.write(numDoc);
                    buffOutFile1.newLine();
                    buffOutFile1.flush();
                } else {
                    buffOutFile2.write(numDoc +" - "+ information);
                    buffOutFile2.newLine();
                    buffOutFile2.flush();
                }

                System.out.println(numDoc);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
