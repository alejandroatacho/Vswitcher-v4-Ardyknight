# V4 Ardy Knight Thieving Script

**By Hinamizawa & Dinkystick Script**

## User Variables
- `foodId`: ID of the food item to eat when Hitpoints are low. (391 for manta, 385 for shark)
- `minHp`: Minimum Hitpoints level to start eating food.

## Usage
1. Set the appropriate values for the user variables: `foodId` and `minHp`.
2. Run the script in the vicinity of the Ardy Knight thieving area.
3. The script will perform the following actions:

   - If Hitpoints are below the minimum level and food is available, the script will eat the food to restore Hitpoints.
   - If the coin pouch counter reaches the gambling counter, the script will open the coin pouches. //Random Human Behaviour
   - If Hitpoints are above the minimum level and food is available, the script will attempt to pickpocket the Knight of Ardougne.
   - If the food counter reaches zero and the player is not at the bank, the script will walk to the bank location.
   - If the food counter reaches zero and the player is at the bank, the script will handle banking operations, including withdrawing food.

**Note**: Please ensure that you have the necessary food in your inventory and are in the Ardy Knight thieving area before running the script.

