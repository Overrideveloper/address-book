/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Overrideveloper
 */

public class AddressBook{
    //Declaring variables
    private String ContactName;
    private String ContactAddress;
    private String ContactTel;
    private String ContactEmail;
    
        public AddressBook(){
            ContactName = "";
            ContactAddress = "";
            ContactTel = "";
            ContactEmail = "";
        }
        
        public AddressBook(String ContactName, String ContactAddress, String ContactTel, String ContactEmail){
            this.ContactName = ContactName;
            this.ContactAddress = ContactAddress;
            this.ContactTel = ContactTel;
            this.ContactEmail = ContactEmail;
        }
        
            //Setter Methods
            public void SetContactName(String ContactName){
                this.ContactName = ContactName;
            }
        
            public void SetContactAddress(String ContactAddress){
                this.ContactAddress = ContactAddress;
            }
            public void SetContactTel(String ContactTel){
                this.ContactTel = ContactTel;
            }
            public void SetContactEmail(String ContactEmail){
                this.ContactEmail = ContactEmail;
            }
            
            //Getter Methods
            public String GetContactName(){
                return ContactName;
            }
            
            public String GetContactAddress(){
                return ContactAddress;
            }
            
            public String GetContactTel(){
                return ContactTel;
            }
            
            public String GetContactNameEmail(){
                return ContactEmail;
            }
            
        
}

