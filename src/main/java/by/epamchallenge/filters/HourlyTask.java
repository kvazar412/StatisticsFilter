package by.epamchallenge.filters;

import java.util.TimerTask;

public class HourlyTask extends TimerTask {

    @Override
    public void run() {
        VisitCountServiceImpl.INSTANCE.startNewVisitHour();
    }
}