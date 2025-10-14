package com.example.cinema.utils;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledUtil {
    private final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    // Agenda qualquer função para ser executada após um determinado tempo
    public void scheduleFunction(Runnable function, int delay, TimeUnit timeUnit) {
        executor.schedule(function, delay, timeUnit);
    }

    // Para o executor
    public void terminateExecutor() {
        executor.shutdown();
    }
}
