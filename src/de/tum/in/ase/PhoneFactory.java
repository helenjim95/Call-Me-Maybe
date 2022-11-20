package de.tum.in.ase;

import java.util.LinkedList;
import java.util.List;

public class PhoneFactory {

    //Done: Initialize the phoneList attribute (as an ArrayList or a LinkedList) in the constructor and add a getter, setter for this attribute
    private List<Phone> phoneList;
    public PhoneFactory() {
        this.phoneList = new LinkedList<>();
    }

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }
    //Done: Implement the producePhones method which adds the parameter phone to the phoneList
    public void producePhone(Phone phone) {
        phoneList.add(phone);
    }
    //Done: Implement the findPhones method which searches through the entire phoneList and returns the phone with the matching id. If no such phone exists, return a new phone with the brand "", price -1 and without touchscreen feature
    public Phone findPhone(int id) {
        if (id < 0) {
            return new Phone("", -1, false);
        }
        for (Phone phone : phoneList) {
            if (phone.getId() == id) {
                return phone;
            }
        }
        return new Phone("", -1, false);
    }
    //Done: Implement the removePhone method which removes the phone with the given id from the phoneList and returns the removed phone. If no phone with the given id exists, then follow the same rule in the findPhones method.
    public Phone removePhone(int id) {
        if (id < 0) {
            return new Phone("", -1, false);
        } else {
            for (Phone phone : phoneList) {
                if (phone.getId() == id & phone.getPrice() >= 0) {
                    phoneList.remove(phone);
                    return phone;
                }
            }
            return new Phone("", -1, false);
        }
    }
    //Done: Implement findTouchPhones method that iterates over the phoneList and store all touchscreen phones in a new list and return this list.
    public List<Phone> findTouchPhones() {
        List<Phone> touchPhones = new LinkedList<>();
        for (Phone phone : phoneList) {
            if (phone.isTouchscreen()) {
                touchPhones.add(phone);
            }
        }
        return touchPhones;
    }
    //Done: Implement containsPhone that checks if the given phoneList contains the given phone. Return true if it does and false if it doesn't.
    public boolean containsPhone(List<Phone> phoneList, Phone phone) {
        return phoneList.contains(phone);
    }
    //Done: Implement removeByBrand that removes all the phones with the brand from the list phones and returns a list that doesn't contain phones of this brand. If brand or phones is null, return an empty list.
    public List<Phone> removeByBrand(List<Phone> phoneList, String brand) {
        if (brand == null || phoneList == null) {
            return List.of();
        }
        for (Phone phone : phoneList) {
            if (phone.getBrand().equals(brand)) {
                phoneList.remove(phone);
            }
        }
        return phoneList;
    }
    
    //Done: Implement findSmallestByLex method that returns the phone with the lexicographically smallest brand
    public Phone findSmallestByLex(List<Phone> phoneList) {
        return sortByBrand(phoneList).get(0);
    }

    //Done: Implement sortByTouch that stores all the phones with a touchscreen in the beginning of a list, the rest of the phones at the end and return this list of phones.
    public List<Phone> sortByTouch() {
        LinkedList<Phone> copyPhoneList = new LinkedList<>(phoneList);
        for (int i = 0; i < copyPhoneList.size(); i++) {
            for (int j = i + 1; j < copyPhoneList.size(); j++) {
                Phone phoneCurrent = copyPhoneList.get(i);
                Phone phoneNext = copyPhoneList.get(j);
                boolean isTouchscreenCurrent = phoneCurrent.isTouchscreen();
                boolean isTouchscreenNext = phoneNext.isTouchscreen();
//                Boolean.compare:
                //0 if ‘a’ is equal to ‘b’,
                //a negative value if ‘a’is false and ‘b’ is true,
                //a positive value if ‘a’ is true and ‘b’ is false.
                if (Boolean.compare(isTouchscreenCurrent, isTouchscreenNext)
                        > 0) {
                    copyPhoneList.add(phoneCurrent);
                    Phone temp = phoneCurrent;
                    copyPhoneList.set(i, phoneNext);
                    copyPhoneList.set(j, phoneCurrent);
                }
            }
        }
        return copyPhoneList;
    }
    //Done: Implement sortByBrand that sorts the phones lexicographically according to their brand and return a list of sorted phones.
    public List<Phone> sortByBrand(List<Phone> phones) {
        for (int i = 0; i < phones.size(); i++) {
            for (int j = i + 1; j < phones.size(); j++) {
                Phone phoneCurrent = phones.get(i);
                Phone phoneNext = phones.get(j);
                String brandCurrent = phoneCurrent.getBrand();
                String brandNext = phoneNext.getBrand();
                if (brandCurrent.compareToIgnoreCase(brandNext)
                        > 0) {
                    Phone temp = phoneCurrent;
                    phoneList.set(i, phoneNext);
                    phoneList.set(j, phoneCurrent);
                }
            }
        }
        return phones;
    }

    //Done: Implement sortByPrice that sorts the list of phones according to their price in increasing order and return the sorted list
    public List<Phone> sortByPrice() {
        LinkedList<Phone> copyPhoneList = new LinkedList<>(phoneList);
        for (int i = 0; i < copyPhoneList.size(); i++) {
            for (int j = i + 1; j < copyPhoneList.size(); j++) {
                Phone phoneCurrent = copyPhoneList.get(i);
                Phone phoneNext = copyPhoneList.get(j);
                double priceCurrent = phoneCurrent.getPrice();
                double priceNext = phoneNext.getPrice();
                if (Double.compare(priceCurrent, priceNext)
                        > 0) {
                    Phone temp = phoneCurrent;
                    copyPhoneList.set(i, phoneNext);
                    copyPhoneList.set(j, phoneCurrent);
                }
            }
        }
        return copyPhoneList;
    }
}
