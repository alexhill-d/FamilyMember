import java.util.Objects;

public class FamilyMember {

    private String name;

    // These mother and father fields will be null if unknown.
    private FamilyMember mother, father;

    public FamilyMember(String name, FamilyMember mother, FamilyMember father) {
        this.name = Objects.requireNonNull(name);
        this.mother = mother;
        this.father = father;
    }

    public boolean isAncestorOf(FamilyMember person) {
        boolean result = isAncestorOfImpl(person);
        System.out.println(name + ".isAncestorOf(" + person.name + ") = " + result);
        return result;
    }

    // mother.isAncestorOf(child)
    // grandmother.isAncestorOf(child)
    // ! child.isAncestorOf(child)
    // ! child.isAncestorOf(nother)
    public boolean isAncestorOfImpl(FamilyMember person) {
        if (person == null) {
            return false;
        }
        if (this == person) {
            return false;
        }
        if (this == person.mother) {
            return true;
        }
        if (this == person.father) {
            return true;
        }
        if (isAncestorOfImpl(person.mother)) {
            return true;
        }
        if (isAncestorOfImpl(person.father)) {
            return true;
        }
        return false;
    }
}