package com.company;

public class Add{

    public void AddToList(String a, String b, LinkedList L){
        LinkedList list = new LinkedList();
        list = L;
        int n = Integer.parseInt(a);
        int q = Integer.parseInt(b);
        switch(n){
            case 1: list.insert("Onion",75,q);break;
            case 2: list.insert("Potatoes",29,q);break;
            case 3: list.insert("Tomato",25,q);break;
            case 4: list.insert("Carrot",45,q);break;
            case 5: list.insert("Garlic",149,q);break;
            case 6: list.insert("Capsicum",119,q);break;
            case 7: list.insert("Pumpkin",45,q);break;
            case 8: list.insert("Cabbage",35,q);break;
            case 9: list.insert("Cauliflower",39,q);break;
            case 10: list.insert("Green Chilli",25,q);break;
            case 11: list.insert("Chicken", 139, q); break;
            case 12: list.insert("Beef", 449, q); break;
            case 13: list.insert("Mutton", 549, q); break;
            case 14: list.insert("Shrimp", 399, q); break;
            case 15: list.insert("Hilsa", 699, q); break;
            case 16: list.insert("Beef keema", 925, q); break;
            case 17: list.insert("Butter", 120, q); break;
            case 18: list.insert("Milk", 70, q); break;
            case 19: list.insert("Cheese", 150, q); break;
            case 20: list.insert("Yogurt",90, q); break;
            case 21: list.insert("Cream", 280, q); break;
            case 22: list.insert("Black Pepper",49, q); break;
            case 23: list.insert("Chili Powder", 39, q); break;
            case 24: list.insert("Cumin", 49, q); break;
            case 25: list.insert("Garlic Powder", 29, q); break;
            case 26: list.insert("salt", 39, q); break;
            case 27: list.insert("Cinnamon", 49, q); break;
            case 28: list.insert("Cardamom", 149, q); break;
            case 29: list.insert("Bay leaves", 19, q); break;
            case 30: list.insert("Cloves", 59, q); break;
            case 31: list.insert("Crackers", 120, q); break;
            case 32: list.insert("Nuts", 100, q); break;
            case 33: list.insert("Oats", 120, q); break;
            case 34: list.insert("Popcorn", 40, q); break;
            case 35: list.insert("Chips", 45, q); break;
            case 36: list.insert("Noodles", 140, q); break;
            case 37: list.insert("Soups", 40, q); break;
            case 38: list.insert("Biscuit", 60, q); break;
            case 39: list.insert("Rice", 65, q); break;
            case 40: list.insert("Flour", 45, q); break;
            case 41: list.insert("Wheat Bread", 40, q); break;
            case 42: list.insert("Masoor Dal", 120, q); break;
            case 43: list.insert("Mugh dal", 100, q); break;
        }


    }


}

