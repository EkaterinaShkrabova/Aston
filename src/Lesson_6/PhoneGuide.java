package Lesson_6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PhoneGuide {
    private Map<String, List<String>> guide = new HashMap<>();

    public void add(String surname, String number) {
        List<String> numbers = guide.getOrDefault(surname, new ArrayList<>());
        numbers.add(number);
        guide.put(surname, numbers);
    }

    public List<String> get(String surname) {
        return guide.get(surname);
    }
}

