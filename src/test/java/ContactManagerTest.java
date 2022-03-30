import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ContactManagerTest {

    @Test
    @DisplayName("Should Create a Contact and verify list")
    public void shouldCreateContact() {
        //Instantiate the contact
        ContactManager contactManager = new ContactManager();
        contactManager.addContact("Maycon", "Santos", "5515987654321");

        // Verify if the list is not empty
        Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
        //Verify if there is only one contact on the list.
        Assertions.assertEquals(1, contactManager.getAllContacts().size());

    }

    @Test
    @DisplayName("Should Create a Contact and search for it using Java Stream")
    public void shouldCreateContactWithSearch() {
        //Instantiate the contact
        ContactManager contactManager = new ContactManager();
        contactManager.addContact("Maycon", "Santos", "5515987654321");

        // Verify if the list is not empty
        Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
        //Verify if there is only one contact on the list.
        Assertions.assertEquals(1, contactManager.getAllContacts().size());


        Assertions.assertTrue(contactManager.getAllContacts().stream()
                .filter(contact -> contact.getFirstName().equals("Maycon") &&
                        contact.getLastName().equals("Santos") &&
                        contact.getPhoneNumber().equals("5515987654321"))
                .findAny()
                .isPresent());
    }

    @Test
    @DisplayName("Should not Create a Contact when First Name is null")
    public void shouldThrowRuntimeExceptionWhenFirstNameIsNULL() {
        //Instantiate the contact
        ContactManager contactManager = new ContactManager();

        Assertions.assertThrows(RuntimeException.class, () -> {
            contactManager.addContact(null, "Santos", "5515987654321");
        });
    }

    @Test
    @DisplayName("Should not Create a Contact when Last Name is null")
    public void shouldThrowRuntimeExceptionWhenSecondNameIsNULL() {
        //Instantiate the contact
        ContactManager contactManager = new ContactManager();
        Assertions.assertThrows(RuntimeException.class, () -> {
            contactManager.addContact("Maycon", null, "5515987654321");
        });
    }

    @Test
    @DisplayName("Should not Create a Contact when Phone Number is null")
    public void shouldThrowRuntimeExceptionWhenPhoneNumberIsNULL() {
        //Instantiate the contact
        ContactManager contactManager = new ContactManager();
        Assertions.assertThrows(RuntimeException.class, () -> {
            contactManager.addContact("Maycon", "Santos", null);
        });
    }

}