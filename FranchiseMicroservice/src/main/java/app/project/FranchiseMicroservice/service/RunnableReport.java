package app.project.FranchiseMicroservice.service;


import java.time.Instant;

public class RunnableReport implements Runnable {

    private Instant fecha1;
    private Instant fecha2;

    private ReportsService reportsService;

    public RunnableReport(Instant fecha1, Instant fecha2, ReportsService reportsService) {
        this.fecha1 = fecha1;
        this.fecha2 = fecha2;
        this.reportsService = reportsService;
    }

    @Override
    public void run() {
        reportsService.get_history_report(fecha1, fecha2);
    }
}

