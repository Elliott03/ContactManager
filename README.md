ContactManager

# What is ContactManager?
	ContactManager is a contact management java program that takes fields: Name, Street, Phone, City, Email, State, Zip, ContactType, and Relationship. You can add contacts, delete contacts, delete all contacts, save them as a file, or load them from a file. Contacts are displayed in a JSwing ListBox.


# How does ContactManager work?
	It takes Name, Street, Phone, City, Email, State, Zip, ContactType, and relationship as inputs. 

	When you press the "Add" button, it checks the combo box to determine contact type and depending on that it will either create a business contact, a family contact, or a friend contact. It uses an abstract class, "Contact", which is extended by the business contact, family contact, and friend contact,  so the contact type is determined first to give time for specific instantiation. This also increments the counter.

	When you press the "Delete" button, it takes the selected contact, and stores it in a string. It then loops through the list of contacts and checks if the current contact is the selected contact. If it is, it removes it from the list, and decrements the counter.

	When you press the "Clear" button, it clears the list, and sets the counter to 0;

	When you press the "Save" button, it uses JFileChooser to save a file, and a foreach loop to save the contents of the contact list to the file.

	When you press the "Load" button, it clears the list and sets the Count to 0. Then it uses JFileChooser to allow the user to pick the desired file to load. It is looped through to save all of the contacts from the list in the file, and then displayed. The counter is updated accordingly.


# How to use ContactManager?

	1. Fork the project to your local machine.
	
	2. cd ContactManager
	
	4. "javac *.java" to compiler all .java files in the repository.
	
	5. "java ContactFrame" to start the program