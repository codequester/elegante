package com.sample.elegante;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

@Component
class CustomHealthIndicator extends AbstractHealthIndicator {
    private boolean isShutDownTriggered=false;

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        if(isShutDownTriggered) {
            System.out.println("CustomHealthIndicator -> Shutdown Triggered, marking the app as unhealthy");
            builder.down();
        } else {
            builder.up();
        }
    }

    public void setIsShutDownTriggered(boolean isShutDownTriggered) {
        this.isShutDownTriggered = isShutDownTriggered;
    }

    public boolean getIsShutDownTriggered() {
        return isShutDownTriggered;
    }
}