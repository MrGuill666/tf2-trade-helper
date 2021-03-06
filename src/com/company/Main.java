package com.company;



import tf.tradesearch.base.BotManager;
import tf.tradesearch.base.Item;
import tf.tradesearch.base.TradeBot;
import tf.tradesearch.bot.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class Main {



    public static void main(String[] args) throws MalformedURLException {
        BotManager bm=new BotManager();
        bm.AddBot(new ScrapTf(new URL("https://scrap.tf/items#pricelist")));
        bm.AddBot(new WasdaBot(new URL("http://www.tf2outpost.com/trade/26599888")));
        bm.AddBot(new Tradetf(new URL("http://www.trade.tf/mybots/index")));
        bm.AddBot(new ScraptfTrade(new URL("file:///D://strangebot.txt")));
        bm.AddBot(new Tf2Vendor(new URL("https://tf2vendor.com/browse")));
        bm.AddBot(new WareHouse(new URL("https://www.tf2wh.com/priceguide")));

        bm.Refresh();
        bm.Compare();

        for(List<Item> l: bm.Search("tour of duty")){
            System.out.print(l.get(0).name+":");
            for(Item i:l)
            {
                System.out.print(
                    i.origin+": "+i.sellPrice+" | "
                );
            }
        }


    }
}
