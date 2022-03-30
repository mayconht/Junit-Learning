import java.util.Objects;

public class Contact {

    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Contact(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return Objects.equals(firstName, contact.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName);
    }

    public void validateFirstName() {
        if(this.firstName.isBlank())
            throw new RuntimeException("First Name cannot be null or empty");
    }

    public void validateLastName() {
        if(this.lastName.isBlank())
            throw new RuntimeException("Last Name cannot be null or empty");
    }

    public void validatePhoneNumber() {
        if(this.phoneNumber.length() != 13){
            throw new RuntimeException("Phone number should be 13 digits long");
        }
        if(this.phoneNumber.matches("\\d")){
            throw new RuntimeException("Phone Number contain only numbers");
        }
        if(!this.phoneNumber.startsWith("55")){
            throw new RuntimeException("PhoneNumber should start with 55 that is a country code");
        }
    }
}
