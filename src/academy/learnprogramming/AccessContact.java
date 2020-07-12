package academy.learnprogramming;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class AccessContact {
    //Function: show contact list,add new contact,overwrite and add the new one,remove contact,search contact,show menu,quit
    private ArrayList<Contact> contactList;
    private String nameContact;

    public AccessContact(String nameContact) {
        this.nameContact = nameContact;
        this.contactList = new ArrayList<Contact>();
    }

//METHOD BASE
    public Contact checkExist(String name){ //check the existence of the contact within the contact list
        for(int i=0; i<contactList.size();i++){
            Contact exist = contactList.get(i);
            if(exist.getName().equals(name)){
                return contactList.get(i);
            }
        }
        return null;
    }

    public int checkIndex(String name){ //check indext by searching from contact name
        return contactList.indexOf(checkExist(name));
    }

    public void showContactList(){ //show contact list
        System.out.println("Contact List: ");
        if(contactList.size() > 0){
            for(int i=0;i<contactList.size();i++){
                System.out.println("#" + (i+1) + ". " + contactList.get(i).toString());
            }
        }
        else{
            System.out.println("You dont have any list in your contact");
        }
    }

//MAIN METHOD
    public boolean addContact(String name, int number){ //add contact to the arraylist
        if(checkExist(name) == null){
            contactList.add(new Contact(name,number));
            return true;
        }
        else{
            System.out.println("Your contact already exist.");
            return false;
        }
    }

    public boolean overwrite(String existingName, String newName, int newNumber){ //overwrite existing contact with new name and new number
        if(checkExist(existingName) != null ){
            Contact name = checkExist(existingName);
            int index = contactList.indexOf(name);
            contactList.set(index,new Contact(newName,newNumber));
            return true;
        }
        else{
            System.out.println("You dont have this contact");
            return false;
        }
    }

    public void remove(String existingName){ //remove existing contact using the name
        contactList.remove(contactList.get(checkIndex(existingName)));
    }

    public void searchContactName (String name){ //search contact by its name
        if(checkExist(name) != null){
            for(int i=0;i<contactList.size();i++){
                Contact searchName = contactList.get(i);
                if(searchName.getName().equals(name)){
                    System.out.println("The phone number for " + name + " is - " + searchName.getNumber());
                }
            }
        }
        else{
            System.out.println("There is no name " + name + " in the contact list");
        }
    }

    public void showMenu(){
        System.out.println("Choose menu below:\n" +
                "#1. Show Contact List\n" +
                "#2. Add Contact\n" +
                "#3. Overwrite Existing Contact\n" +
                "#4. Remove Contact\n" +
                "#5. Search Contact\n" +
                "#6. Quit" );
    }

//METHOD FOR ACCESS CONTACT IN MAIN CLASS
    public void contacting(AccessContact contact){
        Scanner scanner = new Scanner(System.in);

        System.out.println("===========\n");
        System.out.println("You just accessing contact");

        boolean quit = false;
        while(!quit){
            System.out.println("\n===========");
            showMenu();
            int option = scanner.nextInt();
            scanner.nextLine();
            switch(option){
                case 1: //show contact from array list
                    showContactList();
                    break;
                case 2: //add contact by put its name and number
                    System.out.println("Put the name you want to add:");
                    String name = scanner.nextLine();
                    System.out.println("Put the number you want to add:");
                    int number = scanner.nextInt();
                    scanner.nextLine();

                    addContact(name,number);
                    System.out.println("You just added " + checkExist(name).toString());
                    break;
                case 3: //overwrite the contact by using its name
                    System.out.println("Put the name you want to overwrite in the contact: ");
                    String nameOverwrite = scanner.nextLine();
                    System.out.println("Put the name you want add: ");
                    String newNameOverwrite = scanner.nextLine();
                    System.out.println("Put the number: ");
                    int newNumberOverwrite = scanner.nextInt();

                    overwrite(nameOverwrite,newNameOverwrite,newNumberOverwrite);
                    System.out.println("You just overwrite: " + nameOverwrite + " with " + newNameOverwrite);
                    break;
                case 4: //removing contact
                    System.out.println("Put the name you want to remove: ");
                    String nameRemove = scanner.nextLine();
                    remove(nameRemove);
                    System.out.println("You just removed " + nameRemove + " from the contact list");
                    break;
                case 5: //searching contact
                    System.out.println("Put the name you want to search: ");
                    String nameSearch = scanner.nextLine();
                    searchContactName(nameSearch);
                    break;

                case 6:
                    System.out.println("===========");
                    quit = true;
            }

        }
    }











}
