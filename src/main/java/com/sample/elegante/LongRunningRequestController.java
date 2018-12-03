package com.sample.elegante;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
class LongRunningRequestController {
    @RequestMapping(value="/runlong", method=RequestMethod.GET)

	String testGraceness() throws InterruptedException {
		for(int counter=1; counter<=60; counter++) {
            Thread.sleep(100);
            System.out.println("Control Thread Running for thread [" + Thread.currentThread().getName() + "]. . ." + (counter) + "-Times");
		}
		return "We need to See This";
	}
}