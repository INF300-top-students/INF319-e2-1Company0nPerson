package br.com.voidstar.personCompany;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertFalse;

public class PersonTest {
    private static Person pa, pb, pc;

    @Before
    public void setUp() throws Exception {

        pa = new Person();
        pb = new Person("Ana", "Karenina");
        pc = new Person("Janus", "Kamasarov");

    }

    @After
    public void tearDown() throws Exception {
        // No action necessary.
    }

    @Test
    public void test() {
        // Test construction.
        assertEquals(pa.getName(), "");
        assertEquals(pa.getSurname(), "");
        assertEquals(pa.getSalary(), 0.0, 0.0);

        assertEquals(pb.getName(), "Ana");
        assertEquals(pb.getSurname(), "Karenina");
        assertEquals(pb.getSalary(), 0.0, 0.0);

        assertEquals(pc.getName(), "Janus");
        assertEquals(pc.getSurname(), "Kamasarov");

        pb.setName("Anna");
        pb.setSurname("Koslov");

        pb.setSalary(12000.00);
        assertEquals(pb.getName(), "Anna");
        assertEquals(pb.getSurname(), "Koslov");
        assertEquals(pb.getSalary(), 12000.0, 0.0);

        // In the current design a salary of value 0.0 is used
        // by the company (hire and dismiss) to verify whether a person
        // is already employed.
        // To guarantee this behavior the method setSalary must only allow
        // changes 0.0 to a value greater than 0.0
        // OR from a value greater than 0.0 to 0.0
        // all other transitions are forbidden.
        // This is illustrated by the following test
        // pb's salary is 12000.0
        assertEquals(pb.getSalary(), 12000.0, 0.0);
        // So, trying to change the value directly from 12000.0 to 1000.00
        // fails
        pb.setSalary(1000.00);
        assertEquals(pb.getSalary(), 12000.00, 0.0);
        // but it is possible to change it from 12000.0 to 0.0
        // A salary transition from a value greater than 0.0 to 0.0
        // indicates a dismissal from a company
        pb.setSalary(0.0);
        assertEquals(pb.getSalary(), 0.0, 0.0);
        // Symmetrically, a transition from 0.0 to a value greater than 0.0
        // indicates a person's hiring by a company
        pb.setSalary(5000.00);
    }

}
