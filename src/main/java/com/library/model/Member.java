// Member.java
public class Member {
    // The member's unique ID and name. These are kept private.
    private String memberId;
    private String name;

    // The constructor for creating a new Member object.
    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    // Getter methods to access the member's ID and name.
    public String getMemberId() { return memberId; }
    public String getName() { return name; }

    // Provides a formatted string representation of the Member object.
    @Override
    public String toString() {
        return "Member: " + name + " (ID: " + memberId + ")";
    }
}
