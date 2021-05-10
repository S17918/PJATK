package Events;

public abstract class Event {
    protected final String content;

    public Event(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
