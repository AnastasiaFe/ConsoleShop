package ua.epam.fedorenko.ConsoleShop;

import ua.epam.fedorenko.ConsoleShop.entity.AndroidTelephone;
import ua.epam.fedorenko.ConsoleShop.entity.Gadget;
import ua.epam.fedorenko.ConsoleShop.entity.Telephone;
import ua.epam.fedorenko.ConsoleShop.logic.GadgetList;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class Demo {

    public static void main(String[] args) {
        GadgetList<Gadget> gadgets = new GadgetList<>(10);
        gadgets.add(new AndroidTelephone(21343245,  232, 200, 234, "keyboard", "1.0", true));
        gadgets.add(new AndroidTelephone(21343245,  232, 70, 234, "ghhjgj", "1.0", true));
        gadgets.add(new AndroidTelephone(21343245,  232, 345, 234, "keyboard", "1.0", true));
        gadgets.add(new AndroidTelephone(21343245,  232, 756, 234, "keyboard", "1.0", true));
        gadgets.add(new AndroidTelephone(21343245,  232, 98, 234, "ghhjgj", "1.0", true));
        gadgets.add(new AndroidTelephone(21343245,  232, 1233, 234, "keyboard", "1.0", true));
        gadgets.add(new AndroidTelephone(21343245,  232, 5, 234, "ghhjgj", "1.0", true));
        Telephone tp=new AndroidTelephone(21343245,  232, 2323, 234, "keyboard", "1.0", true);
        Telephone t=new AndroidTelephone(21343245,  232, 2323, 234, "keyboard", "1.0", true);
        gadgets.add(5,t);
      Predicate<Gadget> predicate = new Predicate<Gadget>() {
            @Override
            public boolean test(Gadget gadget) {
                return gadget.getHeight() > 300;
            }
        };
        FilterIterator<Gadget> iterator= new FilterIterator<>(gadgets.iterator(), predicate);
       /** while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }*/
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.hasNext());



    }

    public static void print(List<Gadget> gadgets) {
        Iterator<Gadget> iterator = gadgets.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
