package me.cadox8.LoM.shop.item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.cadox8.LoM.LoM;
import me.cadox8.LoM.api.LoMPlayer;
import me.cadox8.LoM.champions.ChampionStats;
import org.bukkit.inventory.ItemStack;

import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
public abstract class ShopItem {

    protected final LoM plugin = LoM.getInstance();

    @Getter protected final int id;
    @Getter protected final String name;

    @Getter protected final int price;

    @Getter protected final List<ShopItemType> types;

    @Getter protected ItemStack item;

    @Getter protected List<ShopItem> parts;

    @Getter protected ItemEffects effects;

    protected IShopBought iShopBought;


    public abstract void onBought(LoMPlayer player);
    public abstract void use(LoMPlayer player);


    protected void addEffects(LoMPlayer player) {
        ChampionStats cs = plugin.getGameManager().getChampions().get(player).getChampionStats();

        cs.setAp(cs.getAp() + effects.getMagic());
    }
}
