package ua.epam.fedorenko.ConsoleShop.logic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.epam.fedorenko.ConsoleShop.entity.AndroidTelephone;
import ua.epam.fedorenko.ConsoleShop.entity.Gadget;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;


public class GadgetListTest {
    private GadgetList<Gadget> gadgets;

    @Before
    public void initialize() {
        gadgets = new GadgetList<>(3);
        gadgets.add(new AndroidTelephone(21343245, 232, 2323, 234, "keyboard", "1.0", true));
        gadgets.add(new AndroidTelephone(24343245, 232, 223, 244, "keyboard", "1.0", true));
    }

    @Test
    public void testAddToEnd1() {

        AndroidTelephone telephone = new AndroidTelephone(21343245, 232, 2323, 234, "keyboard", "1.0", true);
        gadgets.add(telephone);
        Assert.assertEquals(gadgets.size(), 3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddToPositionNegative() {
        AndroidTelephone telephone = new AndroidTelephone(21343245, 232, 2323, 234, "keyboard", "1.0", true);
        gadgets.add(15, telephone);
    }

    @Test
    public void testAddToPosition1() {
        AndroidTelephone telephone = new AndroidTelephone(21343245, 232, 2323, 234, "keyboard", "1.0", true);
        gadgets.add(0, telephone);
        Assert.assertEquals(gadgets.get(0), telephone);
    }


    @Test
    public void testRemoveElement() {
        AndroidTelephone telephone = new AndroidTelephone(21343245, 232, 2323, 234, "keyboard", "1.0", true);
        gadgets.add(0, telephone);
        gadgets.remove(telephone);
        Assert.assertEquals(gadgets.size(), 2);
    }

    @Test
    public void removeNullElement() {
        gadgets.add(null);
        gadgets.remove(null);
        Assert.assertEquals(gadgets.size(), 2);
    }

    @Test
    public void removeNonExistingElement() {
        AndroidTelephone telephone = new AndroidTelephone(21343245, 282, 2323, 234, "keyboard", "1.0", true);
        AndroidTelephone tel2 = new AndroidTelephone(21343245, 232, 2323, 234, "keyboard", "1.0", true);
        gadgets.add(0, tel2);
        Assert.assertEquals(gadgets.remove(telephone), false);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveAtIndexNegative() {

        gadgets.remove(15);

    }

    @Test
    public void testRemoveAtIndex1() {
        gadgets.remove(0);
        Assert.assertEquals(gadgets.size(), 1);
    }

    @Test
    public void testIterator1() {
        gadgets.clear();
        AndroidTelephone telephone = new AndroidTelephone(21343245, 282, 2323, 234, "keyboard", "1.0", true);
        AndroidTelephone tel2 = new AndroidTelephone(21343245, 232, 2323, 234, "keyboard", "1.0", true);
        gadgets.add(0, tel2);
        gadgets.add(1, telephone);
        Iterator<Gadget> simpleIterator = gadgets.iterator();
        while (simpleIterator.hasNext()) {
            simpleIterator.next();
            simpleIterator.remove();
        }
        Assert.assertEquals(gadgets.size(),0);

    }

    @Test(expected = NoSuchElementException.class)
    public void testNextNegative() {
        Iterator<Gadget> iterator = gadgets.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
    }

    @Test
    public void testPredicateIterator() {

    }


}