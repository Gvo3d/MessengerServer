package persons;

import java.util.HashSet;

public class PersonHelper {
    private static PersonHelper instance = new PersonHelper();
    private HashSet<Person> personsdata = new HashSet<Person>();

    public static PersonHelper getInstance(){
        return instance;
    }

    public boolean getNewPerson(){
        return personsdata.add(Person.nullPerson());
    }

    public boolean addPerson(int user_id, String user_login, int user_type){
        return personsdata.add(new Person(user_id, user_login, user_type));
    }

    public boolean removePerson(String login){
        boolean isRemoved = false;
        for (Person tempPerson:personsdata){
            if (tempPerson.getUser_login().equals(login)){
                personsdata.remove(tempPerson);
                isRemoved = true;
            }
        }
        return isRemoved;
    }

    public boolean contains(String login){
        boolean isContains=false;
        for (Person tempPerson:personsdata){
            if (tempPerson.getUser_login().equals(login)){
                isContains = true;
            }
        }
        return isContains;
    }

    public Person getPerson(String login){
        Person returnable=null;
        for (Person tempPerson:personsdata){
            if (tempPerson.getUser_login().equals(login)){
                return tempPerson;
            }
        }
        return new Person(-1, null, 0);
    }

    public boolean sendPersonToDatabase(String login){
        if (contains(login)) {
            util.DBHelper.sendPerson(getPerson(login));
            return true;
        }
        return false;
    }
}
