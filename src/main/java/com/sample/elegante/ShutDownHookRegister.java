package com.sample.elegante;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class ShutDownHookRegister {

    @Autowired
    private CustomHealthIndicator customHealthIndicator;

    @PostConstruct
    void init() {
        registerShutDownHook(Thread.currentThread());
    }

    private void registerShutDownHook(Thread controlThread) {
        System.out.println("Registering the shutdown Hook for Thread-["+controlThread.getName()+"]");
		Thread monitorThread = new Thread(() -> {
			//customHealthIndicator.setIsShutDownTriggered(true);
            System.out.println("Shutdown Sequence INITIATED -->");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
			controlThread.interrupt();
			System.out.println("Controll Thread - ["+controlThread.getName()+"] Stopped before program exit. . .");
		});
		Runtime.getRuntime().addShutdownHook(monitorThread);
	 }
}