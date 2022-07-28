package Day13;

import java.util.HashSet;
import java.util.Set;

public class User {

    private final String username;
    private final Set<User> subscriptions = new HashSet<>();

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public Set<User> getSubscriptions() {
        return subscriptions;
    }

    public void subscribe(User user) {
        subscriptions.add(user);
    }

    public boolean isSubscribed(User user) {
        return subscriptions.contains(user);
    }

    public boolean isFriend(User user) {
        return (this.isSubscribed(user) && user.isSubscribed(this));
    }

    public void sendMessage(User user, String text) {
        MessageDatabase.sendMessage(this, user, text);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' + '}';
    }
}
