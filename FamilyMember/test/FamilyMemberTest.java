import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FamilyMemberTest {

    @Test
    void isAncestorOf() {
        FamilyMember mf = new FamilyMember("mf", null, null);
        FamilyMember mm= new FamilyMember("mm", null, null);
        FamilyMember ff= new FamilyMember("ff", null, null);
        FamilyMember fm= new FamilyMember("fm", null, null);
        FamilyMember father= new FamilyMember("father", fm, ff);
        FamilyMember mother= new FamilyMember("mother", mm, mf);
        FamilyMember child= new FamilyMember("child", mother, father);

        assertTrue(mother.isAncestorOf(child));
        assertTrue(father.isAncestorOf(child));

        assertTrue(mm.isAncestorOf(mother));
        assertTrue(mf.isAncestorOf(mother));

        assertTrue(fm.isAncestorOf(father));
        assertTrue(ff.isAncestorOf(father));

        assertTrue(mm.isAncestorOf(child));
        assertTrue(mf.isAncestorOf(child));
        assertTrue(fm.isAncestorOf(child));
        assertTrue(ff.isAncestorOf(child));

        assertFalse(child.isAncestorOf(child));
        assertFalse(mother.isAncestorOf(mother));
        assertFalse(father.isAncestorOf(father));

        assertFalse(child.isAncestorOf(mother));
        assertFalse(child.isAncestorOf(father));
        assertFalse(child.isAncestorOf(mm));
        assertFalse(child.isAncestorOf(mf));
        assertFalse(child.isAncestorOf(fm));
        assertFalse(child.isAncestorOf(ff));

    }
}