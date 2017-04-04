package me.cadox8.LoM.shop;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ShopItem extends ItemStack{

    @Getter private ArrayList<ShopItemType> shoptype = new ArrayList<>();
    @Getter private ArrayList<Integer> effect = new ArrayList<>();
    @Getter @Setter private int price;
    @Getter @Setter private boolean hasParts;
    @Getter private ArrayList<ShopItem> parts = new ArrayList<>();

    private ItemMeta meta;
    private List<String> tempLore = new ArrayList<>();

    public ShopItem(String name, Material mat, ShopItemType type, int effect, int price){
        super(mat);
        shoptype.add(type);
        this.effect.add(effect);
        this.price = price;
        this.hasParts = false;
        this.meta = this.getItemMeta();
        meta.setDisplayName(name);
        tempLore.add(type.getName() + " +" + effect);
        tempLore.add("Price: " + price + " Gold");
        meta.setLore(tempLore);
        this.setItemMeta(meta);
    }
    public ShopItem(String name, Material mat, ShopItemType type, int effect, int price, ArrayList<ShopItem> parts){
        super(mat);
        shoptype.add(type);
        this.effect.add(effect);
        this.price = price;
        this.parts = parts;
        this.hasParts = true;
        this.meta = this.getItemMeta();
        meta.setDisplayName(name);
        tempLore.add(type.getName() + " +" + effect);
        tempLore.add("Price: " + price + " Gold");
        meta.setLore(tempLore);
        this.setItemMeta(meta);
    }
    public ShopItem(String name, Material mat, ArrayList<ShopItemType> type, ArrayList<Integer> effect, int price){
        super(mat);
        shoptype = type;
        this.effect = effect;
        this.price = price;
        this.hasParts = false;
        this.meta = this.getItemMeta();
        meta.setDisplayName(name);
        for(ShopItemType temptype : type){
            tempLore.add(temptype.getName() + " +" + effect);
        }
        tempLore.add("Price: " + price + " Gold");
        meta.setLore(tempLore);
        this.setItemMeta(meta);
    }
    public ShopItem(String name, Material mat, ArrayList<ShopItemType> type, ArrayList<Integer> effect, int price, ArrayList<ShopItem> parts){
        super(mat);
        shoptype = type;
        this.effect = effect;
        this.price = price;
        this.parts = parts;
        this.hasParts = true;
        this.meta = this.getItemMeta();
        meta.setDisplayName(name);
        for(ShopItemType temptype : type){
            tempLore.add(temptype.getName() + " +" + effect);
        }
        tempLore.add("Price: " + price + " Gold");
        meta.setLore(tempLore);
        this.setItemMeta(meta);
    }

    public void addItemType(ShopItemType shoptype, int effect) {
        this.shoptype.add(shoptype);
        this.effect.add(effect);
    }

    public void removeItemType(ShopItemType shoptype){
        for(int i = 0; i < this.shoptype.size(); i++){
            if(this.shoptype.get(i) == shoptype){
                this.shoptype.remove(i);
            }
        }
    }

    public int getPrice(Player player) {
        if(!this.hasParts){
            return price;
        }else{
            int partprice = price;
            for(ShopItem item : parts){
                if(player.getInventory().contains((ItemStack) item)){
                    partprice = partprice - item.getPrice(player);
                }
            }
            return partprice;
        }

    }
    public ItemStack getItemStack(){
        return this.clone();
    }
}
