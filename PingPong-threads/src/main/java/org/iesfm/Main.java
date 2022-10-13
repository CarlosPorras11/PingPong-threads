package org.iesfm;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {

        Semaphore pingSemaphore = new Semaphore(1);
        Semaphore pongSemaphore = new Semaphore(1);
        try {
            pongSemaphore.acquire();
            Thread pingThread= new Thread(new Ping(pingSemaphore, pongSemaphore));
            Thread pongThread= new Thread(new Pong(pingSemaphore, pongSemaphore));

            pingThread.start();
            pongThread.start();


        } catch (InterruptedException e) {

        }

    }
}