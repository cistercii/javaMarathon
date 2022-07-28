package Day13;

import java.util.Arrays;

public class Day13 {

    static public void solution() {
        User user1 = new User("bob");
        User user2 = new User("kek");
        User user3 = new User("user");

        user1.subscribe(user2);
        user2.subscribe(user1);

        user1.subscribe(user3);

        System.out.println(user1.isFriend(user2));
        System.out.println(user3.isSubscribed(user1));
        System.out.println(user1.isSubscribed(user3));
        System.out.println(user1.isFriend(user3));

        user1.sendMessage(user2, "Io!");
        user3.sendMessage(user2, "Hi");
        user2.sendMessage(user1, "Привет");
        user1.sendMessage(user2, "Как ты бро?");
        user2.sendMessage(user3, "Даров");
        user2.sendMessage(user1, "Все шикардос, как сам?");
        user1.sendMessage(user2, "Да тоже все отлично");
        user1.sendMessage(user2, "");
        user1.sendMessage(user2, "Как сработает");

        MessageDatabase.showDialog(user1, user2);
        System.out.println(Arrays.toString(MessageDatabase.getMessages().toArray()));
    }

}
