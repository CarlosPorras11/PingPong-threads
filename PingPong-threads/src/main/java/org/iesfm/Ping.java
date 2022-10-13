package org.iesfm;

import java.util.concurrent.Semaphore;

public class Ping implements Runnable {

    private Semaphore pingSemaphore;

    private Semaphore pongSemaphore;

    public Ping(Semaphore pingSemaphore, Semaphore pongSemaphore) {
        this.pingSemaphore = pingSemaphore;
        this.pongSemaphore = pongSemaphore;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                pingSemaphore.acquire(1);
                System.out.println("Ping");
            } catch (InterruptedException e) {

            }
            pongSemaphore.release(1);
        }
    }
}