//Title: V4 Ardy Knight Thieving Script By Hinamizawa & Dinkystick
//______________________________________________________________________________________________
// User Variables:
int foodId = 385; // 391 manta, 385 Shark
int minHp = 50; // What hp to eat at
int ardy_knight_id = 12099;
int shadowCast = 1; //0 = no, 1 = yes
//______________________________________________________________________________________________

// Hinamizawa && Dinkystick Variables don't touch,
int food_counter = v.getInventory().count(foodId);
//Coin Pouch Gambling Hinamizawa
int coin_pouch = 22531;
int coin_op = 9764864;
int coin_pouch_slot = v.getInventory().slot(coin_pouch);
int coin_pouch_counter = v.getInventory().count(coin_pouch);
Random random = new Random();
int hina_gambling = 20 + random.nextInt(7);
//Banking info
int bank_id = 10355;
int bank_option = 4;
int dodgyNeckId = 21143;
int neckCounter = v.getInventory().count(dodgyNeckId);
WorldPoint bank_stand = new WorldPoint(2655, 3286, 0);
WorldPoint currentLocation = client.getLocalPlayer().getWorldLocation();

//Collaborated Methods Down Below:
    if (client.getBoostedSkillLevel(Skill.HITPOINTS) <= minHp && (v.getInventory().hasIn(foodId)  || food_counter > 0)) {
        v.getInventory().eat(foodId);
    } else if (!v.getEquipment().hasEquipped(dodgyNeckId)){
            v.getInventory().equip(dodgyNeckId);
    }
    else if (coin_pouch_counter >= hina_gambling) {
        v.invoke("Open-all","<col=ff9040>Coin pouch</col>",2,57,coin_pouch_slot,coin_op,false);
    } else if (client.getBoostedSkillLevel(Skill.HITPOINTS) > minHp && ( v.getInventory().hasIn(foodId) || food_counter > 0) && neckCounter > 0) {
       if (v.getLocalPlayer().hasAnimation(-1) || v.getLocalPlayer().hasAnimation(881) && client.getLocalPlayer().getGraphic() < 245) {
          
            if (client.getLocalPlayer().getGraphic() == 245 && shadowCast == 1){
            v.invoke("Cast","<col=00ff00>Shadow Veil</col>",1,57,-1,14287025,false);

            }
              else if (client.getLocalPlayer().getInteracting() == null && v.getWalking().nearEntity(Entity.NPC, 3297, 10)) {
                v.invoke("Pickpocket","<col=ffff00>Knight of Ardougne<col=ff00> (level-46)",ardy_knight_id,11,0,0,false);// replace me
            }
        }
    }
     else if ((food_counter == 0 || neckCounter == 0) && !currentLocation.equals(bank_stand)) {
         v.getWalking().walk(bank_stand);
         }
             else if (neckCounter == 0 && currentLocation.equals(bank_stand)) {
        GameObject bankBooth = v.getGameObject().findNearest(10355);
        if (bankBooth != null) {
            int bankBoothSceneX = bankBooth.getSceneMinLocation().getX();
            int bankBoothSceneY = bankBooth.getSceneMinLocation().getY();
            v.invoke("Bank","<col=ffff>Bank booth",bank_id,bank_option,bankBoothSceneX, bankBoothSceneY, false);
            v.getCallbacks().afterTicks(3, () -> {
                v.getBank().withdraw(dodgyNeckId, 3);
                v.invoke("Close","",1,57,11,786434,false);
            });
        }
    }
    else if (food_counter == 0 && currentLocation.equals(bank_stand)) {
        GameObject bankBooth = v.getGameObject().findNearest(10355);
        if (bankBooth != null) {
            int bankBoothSceneX = bankBooth.getSceneMinLocation().getX();
            int bankBoothSceneY = bankBooth.getSceneMinLocation().getY();
            v.invoke("Bank","<col=ffff>Bank booth",bank_id,bank_option,bankBoothSceneX, bankBoothSceneY, false);
            v.getCallbacks().afterTicks(3, () -> {
                v.getBank().withdraw(foodId, 20);
                v.invoke("Close","",1,57,11,786434,false);
            });
        }
    }

    food_counter = food_counter;
    neckCounter = neckCounter;