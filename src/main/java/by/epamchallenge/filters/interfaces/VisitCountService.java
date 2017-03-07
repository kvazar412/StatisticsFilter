package by.epamchallenge.filters.interfaces;

import java.util.List;

public interface VisitCountService {
    void registerVisit();

    void startNewVisitHour();

    List<Integer> getDailyVisits();
}