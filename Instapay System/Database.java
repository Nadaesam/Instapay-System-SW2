
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private static List<User> users = new ArrayList<>();

    Database() {
        loadUsersFromDatabase();
    }

    public void addUser(User user) {
        user.setUserId(String.valueOf(users.size() + 1));
        users.add(user);
        saveUsersToFile();
    }

    public List<User> getUsers() {
        return users;
    }

    public boolean authenticateUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                user.setVerificationStatus(true);
                return true;
            }
        }
        return false;
    }

    public User getUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }

        return null;
    }
    
    public User getUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }

        return null;
    }

    public ArrayList<Bill> getUserBills(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {

                return user.getBills();
            }
        }
        return null;
    }

    public boolean doesUserExist(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    private void saveUsersToFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("usersdb.txt"))) {
            outputStream.writeObject(users);
        } catch (IOException e) {
            System.out.println("error save.");
            e.printStackTrace();
        }
    }

    public void loadUsersFromDatabase() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("usersdb.txt"))) {
            Object object = inputStream.readObject();

            if (object instanceof List<?>) {
                users = (List<User>) object;
            } else {
                System.out.println("Invalid data in the file. Expected a List<User>.");
            }
        } catch (EOFException e) {
            // Handle EOFException separately
//            System.out.println("End of file reached unexpectedly. Possible empty file or corruption.");
        } catch (FileNotFoundException e) {
            System.out.println("User data file not found. Initializing an empty user list.");
        } catch (IOException | ClassNotFoundException e) {
          
            System.out.println("Error reading user data. Initializing an empty user list.");
        }
    }
}
