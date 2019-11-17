/*
* 17/nov/2019
*
* */
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {
        // init all vars here

        Boolean sameNetwork = true; // calling within network ?
        Double dayTimeRate = 4.0; // 6am to 6pm
        Integer dayTime = 6; // 06.00 hours
        Double nightTimeRate = 3.0; // 6pm to 6am
        Integer nightTime = 18; // 18.00 hours
        Double otherNetwork = 5.0; // to other Networks
        Double vat = 0.16; // vat for all calls more than 2 minutes
        Integer duration = 5; // call duration in minutes;
        Double charges = 1.0;
        String currency = "KES ";
        LocalTime currentTime = LocalTime.now();
        // currentTime = currentTime.minusHours(8);// minus 8 hours, testing day time call
        LocalTime endTime = currentTime.plusMinutes(duration); // minutes that the call lasted
        // logic
        Integer currHr = currentTime.getHour();
        Integer endHr = endTime.getHour();
        // System.out.println("Start Hr "+currentTime.getHour()+" / End Hr "+endTime.getHour()+" / Day start "+dayTime+" / Night start "+nightTime);
        System.out.println("Start call..");
        if(sameNetwork) {
            System.out.println("Same network call.");
            if(currHr>=nightTime) {
                System.out.println("Night time call ; Start Hr "+currentTime.getHour()+" / End Hr "+endTime.getHour()+" in the evening.");
                charges = duration*nightTimeRate;
            } else {
            // if(currHr>=dayTime) {
                System.out.println("Day time call ; Start Hr "+currentTime.getHour()+" / End Hr "+endTime.getHour()+" in the day.");
                charges = duration*dayTimeRate;
            }
        } else {
            System.out.println("Other network call..");
            charges = duration*otherNetwork;
        }
        charges = charges+(charges*vat);

        System.out.println("Current start time "+currentTime+" | Call end time "+endTime+" | Duration "+duration+" | Total call charges "+currency+charges);
        System.out.println("Call ended.");
    }
}
