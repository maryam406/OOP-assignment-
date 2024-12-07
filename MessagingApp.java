public interface MessagingApp {
    void addContact(String name, String phoneNumber) throws Exception;
    void displayContacts();
    void sendMessage(String contactName, String message) throws Exception;
    void deleteContact(String name) throws Exception;
    void deleteMessage(int messageId) throws Exception;
    void displayAllMessages();
    void displaySpecificMessages(String contactName);
    void displayMessagesInArrangedWay();
    void unsendMessage(int messageId) throws Exception;
    void displayUnseenMessages();
    void displaySeenMessages();
    void displayUnsentMessages();
}