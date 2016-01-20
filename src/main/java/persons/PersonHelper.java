package persons;

import java.util.HashSet;

public class PersonHelper {
    private static PersonHelper instance = new PersonHelper();
    private HashSet<Person> personsdata = new HashSet<Person>();

    public static PersonHelper getInstance(){
        return instance;
    }

    public boolean createNewPerson(int user_id, String user_login, String password, int user_type){
        Person tempperson = new Person();
        tempperson.setUser_id(user_id);
        tempperson.setUser_login(user_login);
        tempperson.setUser_type(user_type);
        tempperson.setPassword(password);
        tempperson.setCreated();
        return personsdata.add(new Person());
    }

    public boolean addPerson(Person pers){
        if ((pers.isNotNull())&& (!contains(pers.getUser_login()))) {
            personsdata.add(pers);
            return true;
        }
        return false;
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
        return new Person();
    }

}
