import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ContactManagerTest {

    ContactManager contactManager;

    @BeforeEach
    public void setupContactManager(){
        contactManager = new ContactManager();
    }

    @Test
    @DisplayName("Should Create a Contact and verify list size")
    public void shouldCreateContact() {
        //Instantiate the contact

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
        contactManager.addContact("Maycon", "Santos", "5515987654321");
        // Verify if the list is not empty
        Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
        //Verify if there is only one contact on the list.
        Assertions.assertEquals(1, contactManager.getAllContacts().size());

        Assertions.assertTrue(contactManager.getAllContacts().stream()
                .anyMatch(contact -> contact.getFirstName().equals("Maycon") &&
                        contact.getLastName().equals("Santos") &&
                        contact.getPhoneNumber().equals("5515987654321")));
    }

    @Test
    @DisplayName("Should not Create a Contact when First Name is null")
    public void shouldThrowRuntimeExceptionWhenFirstNameIsNULL() {
        //Instantiate the contact
        Assertions.assertThrows(RuntimeException.class, () -> contactManager.addContact(null, "Santos", "5515987654321"));
    }

    @Test
    @DisplayName("Should not Create a Contact when Last Name is null")
    public void shouldThrowRuntimeExceptionWhenSecondNameIsNULL() {
        //Instantiate the contact
        Assertions.assertThrows(RuntimeException.class, () -> contactManager.addContact("Maycon", null, "5515987654321"));
    }

    @Test
    @DisplayName("Should not Create a Contact when Phone Number is null")
    public void shouldThrowRuntimeExceptionWhenPhoneNumberIsNULL() {
        //Instantiate the contact
        Assertions.assertThrows(RuntimeException.class, () -> contactManager.addContact("Maycon", "Santos", null));
    }

    @Test
    @DisplayName("Should Create a Contact and search for it using Java Stream Only on Windows")
    @EnabledOnOs(value = OS.WINDOWS, disabledReason = "Enabled only on Windows")
    public void shouldCreateContactOnlyOnWindows() {
        //Instantiate the contact
        contactManager.addContact("Maycon", "Santos", "5515987654321");
        // Verify if the list is not empty
        Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
        //Verify if there is only one contact on the list.
        Assertions.assertEquals(1, contactManager.getAllContacts().size());

        Assertions.assertTrue(contactManager.getAllContacts().stream()
                .anyMatch(contact ->
                        contact.getFirstName().equals("Maycon") &&
                        contact.getLastName().equals("Santos") &&
                        contact.getPhoneNumber().equals("5515987654321")));
    }

    @Test
    @DisplayName("Should Create a Contact and search for it using Java Stream Only on macOs")
    @EnabledOnOs(value = OS.MAC, disabledReason = "Enabled only on MacOs")
    public void shouldCreateContactOnlyOnMacOs() {
        //Instantiate the contact
        contactManager.addContact("Maycon", "Santos", "5515987654321");
        // Verify if the list is not empty
        Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
        //Verify if there is only one contact on the list.
        Assertions.assertEquals(1, contactManager.getAllContacts().size());

        Assertions.assertTrue(contactManager.getAllContacts().stream()
                .anyMatch(contact -> contact.getFirstName().equals("Maycon") &&
                        contact.getLastName().equals("Santos") &&
                        contact.getPhoneNumber().equals("5515987654321")));
    }

    @Test
    @DisplayName("Test contact creation on Developer machine")
    public void shouldTestCreateContactOnDev() {
        //It will verify if the environment is the correct one.
        //IT will not fail a test, only abort it.
        Assumptions.assumeTrue("TEST".equals(System.getProperty("ENV")));

        //Instantiate the contact
        contactManager.addContact("Maycon", "Santos", "5515987654321");
        // Verify if the list is not empty
        Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
        //Verify if there is only one contact on the list.
        Assertions.assertEquals(1, contactManager.getAllContacts().size());

    }

    @RepeatedTest(value = 5)
    @DisplayName("Should Create a Contact Repeatedly")
    public void shouldCreateContactRepeatedly() {
        //It is a good practice when we are verifying random values.
        //Instantiate the contact
        contactManager.addContact("Maycon", "Santos", "5515987654321");
        // Verify if the list is not empty
        Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
        //Verify if there is only one contact on the list.
        Assertions.assertEquals(1, contactManager.getAllContacts().size());
    }

    @ParameterizedTest
    @ValueSource(strings={"5512987654321", "5512987654322", "5512987654323"})
    @DisplayName("Should Create a Contact Repeatedly with parameters for phone number")
    public void shouldCreateContactParametrized(String phoneNumber) {
        //It is a good practice when we are verifying random values.
        //Instantiate the contact
        contactManager.addContact("Maycon", "Santos", phoneNumber);
        // Verify if the list is not empty
        Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
        //Verify if there is only one contact on the list.
        Assertions.assertEquals(1, contactManager.getAllContacts().size());
    }


    @ParameterizedTest
    @MethodSource("phoneNumberList")
    @DisplayName("Should Create a Contact Repeatedly with parameters with Method Source for phone number")
    public void shouldCreateContactParametrizedWithMethodSource(String phoneNumber) {
        //It is a good practice when we are verifying random values.
        //Instantiate the contact
        contactManager.addContact("Maycon", "Santos", phoneNumber);
        // Verify if the list is not empty
        Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
        //Verify if there is only one contact on the list.
        Assertions.assertEquals(1, contactManager.getAllContacts().size());
    }

private static List<String> phoneNumberList(){
        return Arrays.asList("5512987654321", "5512987654322", "5512987654323");
}


}