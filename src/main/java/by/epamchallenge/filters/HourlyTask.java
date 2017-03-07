package by.epamchallenge.filters;

import java.util.TimerTask;

public class HourlyTask extends TimerTask {
    private VisitCountServiceImpl visitCountServiceImpl = new VisitCountServiceImpl();

    @Override
    public void run() {
        visitCountServiceImpl.startNewVisitHour();
    }
}