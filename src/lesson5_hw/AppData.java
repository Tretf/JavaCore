package lesson5_hw;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;

public class AppData implements Serializable {

    private String[] header;
    private String[][] data;


    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public String[][] getData() {
        return data;
    }

    public void setData(String[][] data) {
        this.data = data;
    }

    public AppData(String[] header) {
        this.header = header;
    }

    public void info() {
        System.out.println(header);
    }

}