package proxy;

public class RealSensitiveData {

    private String value;

    public RealSensitiveData(String value) {
        this.value = value;
    }

    public String read() {
        return value;
    }
}
