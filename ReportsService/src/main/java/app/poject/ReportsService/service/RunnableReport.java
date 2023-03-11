package app.poject.ReportsService.service;

import app.poject.ReportsService.controller.ReportsController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;

public class RunnableReport implements Runnable{

    private Instant fecha1;
    private Instant fecha2;

    private ReportsService reportsService;

    public final static Logger LOGGER = LoggerFactory.getLogger(ReportsController.class);

    public RunnableReport(Instant fecha1, Instant fecha2, ReportsService reportsService) {
        this.fecha1 = fecha1;
        this.fecha2 = fecha2;
        this.reportsService = reportsService;
    }

    @Override
    public void run() {
        LOGGER.debug("recurrent report: " + reportsService.get_history_report(fecha1,fecha2));
        reportsService.get_history_report(fecha1, fecha2);
    }
}
