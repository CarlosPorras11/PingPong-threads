package org.iesfm;

import java.util.concurrent.Semaphore;

public class Pong implements Runnable {

    private Semaphore pingSemaphore;
    private Semaphore pongSemaphore;

    public Pong(Semaphore pingSemaphore, Semaphore pongSemaphore) {
        this.pingSemaphore = pingSemaphore;
        this.pongSemaphore = pongSemaphore;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            try {
                pongSemaphore.acquire(1);
                System.out.println("Pong");
            } catch (InterruptedException e) {

            }
            pingSemaphore.release(1);
        }
    }
}
