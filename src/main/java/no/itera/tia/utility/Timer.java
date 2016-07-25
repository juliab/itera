package no.itera.tia.utility;

public final class Timer {
    
    private long time;
    
    private Timer() {
        time = System.currentTimeMillis();
    }
    
    public static Timer get() {
        return new Timer();
    }
    
    public void stopAndPrint(String message) {
        System.out.println(message + ": " + (System.currentTimeMillis() - time));
        time = System.currentTimeMillis();
    }
    
    public void stopAndPrint() {
        System.out.println(System.currentTimeMillis() - time);
        time = System.currentTimeMillis();
    }
}
