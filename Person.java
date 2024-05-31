package P3;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;//名字
    private List<Person> friendList;//朋友列表

    private static ArrayList<String> personlist = new ArrayList<String>();

    public Person(String nameString) {
        if(personlist.contains(nameString))
        {
            System.out.println("The name has been used.");
            System.exit(0);
        }
        else {
            this.name = nameString;
            friendList = new ArrayList<>();
            personlist.add(nameString);
        }

    }
    //新增朋友
    public void addFriend(Person pb) {
        friendList.add(pb);
    }
    // 获取名字
    public String getName() {
        return name;
    }
    // 获取朋友列表
    public List<Person> getFriendList() {
        return this.friendList;
    }
}
