package by.epamchallenge.filters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import by.epamchallenge.filters.interfaces.VisitCountService;

public enum VisitCountServiceImpl implements VisitCountService {
    INSTANCE;

    private int[] dailyVisits = new int[24];

    public synchronized void registerVisit() {
        dailyVisits[0]++;
    }

    public synchronized void startNewVisitHour() {
        System.arraycopy(dailyVisits, 0, dailyVisits, 1, 23);
        dailyVisits[0] = 0;
    }

    public synchronized List<Integer> getDailyVisits() {
        List<Integer> unmodDailyVisits = new ArrayList<Integer>(24);
        for (int i : dailyVisits) {
            unmodDailyVisits.add(i);
        }
        return Collections.unmodifiableList(unmodDailyVisits);
    }
}