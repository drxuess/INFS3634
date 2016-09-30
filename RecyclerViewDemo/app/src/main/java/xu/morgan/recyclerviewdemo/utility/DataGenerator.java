package xu.morgan.recyclerviewdemo.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import xu.morgan.recyclerviewdemo.model.ShoppingItem;

/**
 * Created by morganxu on 29/09/2016.
 */
public class DataGenerator {
    public static Random randomGen = new Random();

    public static List<ShoppingItem> generateShoppingList(int size){
        List<ShoppingItem> output =  new ArrayList<ShoppingItem>();
        for(int i = 0; i < size; i++){
            ShoppingItem item = new ShoppingItem(generateString(15), generateDouble(50));
            output.add(item);
        }
        return output;
    }

    public static String generateString(int len){
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++){
            char c = chars[randomGen.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }

    public static double generateDouble(int len){
        return randomGen.nextDouble()*len + 1;
    }
}
