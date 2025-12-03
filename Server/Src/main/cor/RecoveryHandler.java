package cor;

public abstract class RecoveryHandler {

    protected RecoveryHandler next;

    public RecoveryHandler setNext(RecoveryHandler next) {
        this.next = next;
        return next;
    }

    public abstract boolean handle(String answer);
}
