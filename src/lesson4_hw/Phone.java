package lesson4_hw;

import java.util.ArrayList;

public class Phone {

    private String subscriber;
    private String number;

    public String getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(String subscriber) {
        this.subscriber = subscriber;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Phone(String subscriber, String number) {
        this.subscriber = subscriber;
        this.number = number;
    }
}
