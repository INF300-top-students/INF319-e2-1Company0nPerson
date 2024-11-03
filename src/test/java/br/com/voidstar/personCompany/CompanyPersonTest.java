package br.com.voidstar.personCompany;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class CompanyPersonTest {
    private static Company ca, cb, cc;

    private static Person pa, pb,pc, pd;

    @Before
    public void setUp() throws Exception {

        ca = new Company();
        cb = new Company("CB");
        cc = new Company("CC");

        pa = new Person("A", "AA");
        pb = new Person("B", "BB");
        pc = new Person("C", "CC");
        pd = new Person("D", "DD");

    }

    @After
    public void tearDown() throws Exception {
        // No action necessary here.
    }

    @Test
    public void test() {
        // Test the state of ca after its construction.
        assertEquals(ca.getName(), "");
        assertEquals(ca.getNumberOfEmployees(), 0);
        assertEquals(ca.payroll(), 0.0, 0.0);

        // Test the state of cb after its construction.
        assertEquals(cb.getName(), "CB");
        assertEquals(cb.getNumberOfEmployees(), 0);
        assertEquals(cb.payroll(), 0.0, 0.0);

        // Test construction of cc
        assertEquals(cc.getName(), "CC");
        assertEquals(cc.getNumberOfEmployees(), 0);

        cc.setName("Sucupira");
        assertEquals(cc.getName(), "Sucupira");
        assertEquals(cc.payroll(), 0.0, 0.0);

        // CC hires PA, PB, and PC
        cc.hire(pa, 1000.0);
        assertEquals(cc.getNumberOfEmployees(), 1);
        assertEquals(cc.payroll(), 1000.0, 0.0);
        cc.hire(pb, 1100.0);
        assertEquals(cc.payroll(), 2100.00, 0.0);
        cc.hire(pc, 1200.0);
        assertEquals(cc.payroll(), 3300.0, 0.0);
        assertEquals(cc.getNumberOfEmployees(), 3);
        assertEquals(pa.getSalary(), 1000.00, 0.0);
        // CC dismisses PA
        cc.dismiss(pa);
        assertEquals(pa.getSalary(), 0.0, 0.0);
        assertEquals(cc.getNumberOfEmployees(), 2);
        assertEquals(cc.payroll(), 2300.00, 0.0);
        // At this point, CC employs PB and PC

        // CA hires PA
        ca.hire(pa, 1300.0);
        assertEquals(ca.payroll(), 1300.0, 0.0);
        assertEquals(pa.getSalary(), 1300.00, 0.0);
        // PA tries to change its own salary to no avail
        pa.setSalary(1500.00);
        assertEquals(ca.payroll(), 1300.00, 0.0);
        // CA hires PD
        ca.hire(pd, 2500.00);
        assertEquals(ca.payroll(), 3800.00, 0.0);
        // CB tries to hire PD as well
        // but that fails because PD is already an employee of CA
        assertEquals(cb.getNumberOfEmployees(), 0);
        assertEquals(cb.payroll(), 0.0, 0.0);
        cb.hire(pd, 3000.00);
        // After the attempt all continues as before
        // PD still makes 2500.00 a month
        // CB still has no employees
        assertEquals(pd.getSalary(), 2500.00, 0.0);
        assertEquals(cb.getNumberOfEmployees(), 0);

    }
}
