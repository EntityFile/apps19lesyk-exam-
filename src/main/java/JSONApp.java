import domain.BasicStudent;
import domain.Student;
import json.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JSONApp {
    public static void main(String[] args) {
        Json jYear = new JsonNumber(2);
        print(jYear); // 2

        Json jMarks = new JsonArray(new JsonNumber(3), new JsonNumber(4));
        print(jMarks); // [3, 4]

        JsonPair name = new JsonPair("name", new JsonString("Andrii"));
        JsonPair surname = new JsonPair("surname", new JsonString("Rodionov"));
        JsonPair marks = new JsonPair("marks", jMarks);
        JsonPair year = new JsonPair("year", jYear);
        JsonObject jsonObj = new JsonObject(name, surname, year, marks);
        print(jsonObj); // {'name': 'Andrii', 'surname': 'Rodionov', 'year': 2, 'marks': [3, 4]}

        print(jsonObj.projection("surname", "age", "year", "marks")); // {'surname': 'Rodionov', 'year': 2, 'marks': [3, 4]}

        BasicStudent basicStudent = new BasicStudent("Andrii", "Rodionov", 2);
        print(basicStudent.toJsonObject()); // {'name': 'Andrii', 'surname': 'Rodionov', 'year': 2}

    }

    private static void print(Json json) {
        System.out.println(json.toJson());
    }


    public static JsonObject sessionResult() {
        JsonPair oopExamName = new JsonPair("course", new JsonString("OOP"));
        JsonPair oopExamMark = new JsonPair("mark", new JsonNumber(3));
        JsonPair oopExamPassed = new JsonPair("passed", new JsonBoolean(true));
        JsonObject exam1 = new JsonObject(oopExamName, oopExamMark, oopExamPassed);

        JsonPair englishExamName = new JsonPair("course", new JsonString("English"));
        JsonPair englishExamMark = new JsonPair("mark", new JsonNumber(5));
        JsonPair englishExamPassed = new JsonPair("passed", new JsonBoolean(true));
        JsonObject exam2 = new JsonObject(englishExamName, englishExamMark, englishExamPassed);

        JsonPair mathExamName = new JsonPair("course", new JsonString("Math"));
        JsonPair mathExamMark = new JsonPair("mark", new JsonNumber(2));
        JsonPair mathExamPassed = new JsonPair("passed", new JsonBoolean(false));
        JsonObject exam3 = new JsonObject(mathExamName, mathExamMark, mathExamPassed);

        JsonArray exams = new JsonArray(exam1, exam2, exam3);

        JsonObject jsonObject = new JsonObject(new JsonPair("name", new JsonString("Andrii")),
                new JsonPair("surname", new JsonString("Rodionov")),
                new JsonPair("year", new JsonNumber(2)), new JsonPair("exams", exams));
        return jsonObject;
    }
}
