package lesson5_hw;

public class AppData2 {

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

    public AppData2(String[] header) {
        this.header = header;
    }

    public void info() {
        System.out.println(header);
    }
}