package com.teachmeskills.lesson_11.task_1.numberdocument;

public class NumberDocument {

    public static String checkNumDoc(String numDoc) {
        if (numDoc.length() != 15) {
            numDoc = "Валидный номер документа должен иметь длину 15 символов.";

        } else if (!numDoc.startsWith("docnum") && !numDoc.startsWith("contract")) {
            numDoc = "Номер документа должен начинаться с docnum или сontract.";

        } else {
            numDoc = "";
        }

        return numDoc;
    }

}
