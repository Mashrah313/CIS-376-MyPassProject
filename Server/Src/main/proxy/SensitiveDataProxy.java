package proxy;

public class SensitiveDataProxy {

    private RealSensitiveData realData;
    private boolean masked = true;

    public SensitiveDataProxy(String value) {
        this.realData = new RealSensitiveData(value);
    }

    public String view() {
        if (masked) {
            return mask(realData.read());
        }
        return realData.read();
    }

    public void unmask() {
        masked = false;
    }

    public void maskAgain() {
        masked = true;
    }

    private String mask(String val) {
        if (val.length() <= 4)
            return "****";

        int visible = 4;
        int maskedCount = val.length() - visible;

        return "*".repeat(maskedCount) + val.substring(maskedCount);
    }
}
