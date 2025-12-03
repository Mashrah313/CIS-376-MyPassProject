package mediator;

public abstract class UIComponent {
    protected UIMediator mediator;

    public UIComponent(UIMediator mediator) {
        this.mediator = mediator;
    }

    public abstract void send(String event);
    public abstract void receive(String message);
}
