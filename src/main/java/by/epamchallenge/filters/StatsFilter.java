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
    private VisitCountServiceImpl visitCountService;

    public void init(FilterConfig fConfig) throws ServletException {
        visitCountService = new VisitCountServiceImpl();
        Timer timer = new Timer();
        timer.schedule(new HourlyTask(), 60 * 60000, 60 * 60000);
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        visitCountService.registerVisit();

        request.setAttribute("dailyVisits", visitCountService.getDailyVisits());
        chain.doFilter(request, response);
    }

    public void destroy() {
    }
}