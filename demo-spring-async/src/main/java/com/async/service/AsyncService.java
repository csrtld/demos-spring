package com.async.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Service
@Slf4j
public class AsyncService {

    @Autowired
    private RestTemplate restTemplate;

    /*
    @Autowired
    Executor asyncExecutor;*/

    @Async
    public CompletableFuture<String> runAsync() throws InterruptedException {
        log.info("Metodo runAsync =>");



        Thread.sleep(1000L);
        return CompletableFuture.completedFuture("results");
    }

    public void runAsync2() throws InterruptedException  {
        /*CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                // restTemplate.postForEntity();

                Thread.sleep(1000L);

            } catch (InterruptedException e) {
                // Rest responde fallido
                e.printStackTrace();
            }
            return "future_1";
        });*/
           /*     .exceptionally(ex -> new Result(Status.FAILED))
                .thenAccept(this::notify);*/

        /*
        * 1. Se invoca a Rest
        * 2. Rest responde ok
        * 3. Rest responde fallido
        *
        * */

        // 1. Run
        CompletableFuture<Void> futureRunAsync = CompletableFuture.runAsync(() -> {
            // 1. Se invoca a Rest
        });

        futureRunAsync.thenRun(() -> {
            // función lambda en el mismo thread
        });

        futureRunAsync.thenRunAsync(() -> {
            // ejecutara en un thread nuevo
        });

        // 2. Supply
        CompletableFuture<String> futureSupplyAsync = CompletableFuture.supplyAsync(() -> {
            return "futureSupplyAsync";
        });

        futureSupplyAsync.thenAcceptAsync((s)-> {
            // Success
        });

        futureSupplyAsync.exceptionally((e) -> {
            // Fail
            return "salida por defecto";
        });

        // Debe retornar algo
        CompletableFuture<String> handleFuture = futureSupplyAsync.handleAsync((s, e) -> {
            if (e != null) {
                return "Fallo";
            } else {
                return "Exito";
            }
        });

        // Listener => thenAcceptAsync() + exceptionally()
        futureSupplyAsync.whenCompleteAsync((s, e) -> {
            if (e != null) {
                // Se obtiene un Error
            }
        });

        // Espera hasta que se complete => futureSupplyAsync.get();
        // Retorna inmediatamente sino valor por defecto => futureSupplyAsync.getNow("default");

        /* Transforma el anterior supply
        CompletableFuture<String> futureThenApplyAsync = futureSupplyAsync.thenApplyAsync((s) -> {
            return s.toUpperCase();
        });
        */
    }
}
