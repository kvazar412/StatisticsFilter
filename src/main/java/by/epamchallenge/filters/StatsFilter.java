package by.epamchallenge.filters;

import java.io.IOException;
import java.util.Timer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class StatsFilter implements Filter {

    public void init(FilterConfig fConfig) throws ServletException {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new HourlyTask(), VisitCountServiceHelper.getFirstTimeDate(), 60 * 60000);
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        VisitCountServiceImpl.INSTANCE.registerVisit();

        request.setAttribute("dailyVisits", VisitCountServiceImpl.INSTANCE.getDailyVisits());
        chain.doFilter(request, response);
    }

    public void destroy() {
    }
}