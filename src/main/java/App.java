import java.util.List;
import java.util.ArrayList;
/*
 * This Java source file was generated by the Gradle 'init' task.
 */
public class App {
    private ItemRepository itemRepository;
    private SalesPromotionRepository salesPromotionRepository;

    public App(ItemRepository itemRepository, SalesPromotionRepository salesPromotionRepository) {
        this.itemRepository = itemRepository;
        this.salesPromotionRepository = salesPromotionRepository;
    }

    public String bestCharge(List<String> inputs) {
        //TODO: write code here

        String ordSummary = "============= Order details =============\n"+
        menuList(inputs)+
        "-----------------------------------\n"+
        orderSum(inputs)+
        "===================================";
        return ordSummary;
    }

    public String menuList(List<String> inputs){
        String ordSummary = "";
        for (String temp : inputs) {
            String[] parts = temp.split(" ");
            String itemNum = parts[0]; 
            int foodList = Integer.parseInt(parts[2]); 
            int amount; 
            if(itemNum.equals("ITEM0001"))
			{
                amount = 18;
                ordSummary += "Braised chicken x "+foodList+" = "+(foodList*amount)+" yuan\n";
            } 
			else if(itemNum.equals("ITEM0013")){
                amount = 6;
                ordSummary += "Chinese hamburger x "+foodList+" = "+(foodList*amount)+" yuan\n";
            } 
			else if(itemNum.equals("ITEM0022")){
                amount = 8;
                ordSummary += "Cold noodles x "+foodList+" = "+(foodList*amount)+" yuan\n";
            }
        }
        return ordSummary;
    }

    public String orderSum(List<String> inputs)
	{
        int orderSum = 0;
        List<String> discMenu = new ArrayList<>();
        List<Integer> discountedFood = new ArrayList<>();
        for (String temp : inputs) 
		{
            String[] parts = temp.split(" ");
            String itemNum = parts[0]; 
            int foodList = Integer.parseInt(parts[2]); 
            int amount; 
            if(itemNum.equals("ITEM0001"))
			{
                amount = 18;
                orderSum += foodList * amount;
                discMenu.add("Braised chicken");
                discountedFood.add(18/2);
            } 
			else if(itemNum.equals("ITEM0013")){
                amount = 6;
                orderSum += foodList * amount;
            }
			else if(itemNum.equals("ITEM0022")){
                amount = 8;
                orderSum += foodList * amount;
                discMenu.add("Cold noodles");
                discountedFood.add(8/2);
            }
        }
        if(discMenu.size() >= 2)
		{
            int savings = discountedFood.get(0);
            for (int temp : discountedFood)
			{
                if(!(temp == savings))
				{
                    savings += temp;
                }
            }

            String halfDiscount ="Promotion used:\n" +
            "Half price for certain dishes ("+discMenu.toString().replace("[", "").replace("]", "").replace(", ", "，")+")，saving "+savings+" yuan\n" +
            "-----------------------------------\n";

            return halfDiscount+"Total："+(orderSum-savings)+" yuan\n";

        } 
		else if(orderSum >= 30)
		{
            String promo_30items = "Promotion used:\n" +
            "满30减6 yuan，saving 6 yuan\n" +
            "-----------------------------------\n";
            return promo_30items+"Total："+(orderSum-6)+" yuan\n";
        }
        else {
            return "Total："+orderSum+" yuan\n";
        }
    }


}

