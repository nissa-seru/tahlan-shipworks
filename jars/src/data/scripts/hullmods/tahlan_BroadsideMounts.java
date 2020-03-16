package data.scripts.hullmods;

import com.fs.starfarer.api.combat.BaseHullMod;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;
import com.fs.starfarer.api.impl.campaign.ids.Stats;

public class tahlan_BroadsideMounts extends BaseHullMod {

	public static final float REPAIR_BONUS = 25f;
	public static final float WEAPON_HEALTH_BONUS = 50f;
	//public static final float BALLISTIC_FLUX_MULT = 0.9f;

	public void applyEffectsBeforeShipCreation(HullSize hullSize, MutableShipStatsAPI stats, String id) {

		stats.getCombatEngineRepairTimeMult().modifyMult(id, 1f - REPAIR_BONUS*0.01f);
		stats.getCombatWeaponRepairTimeMult().modifyMult(id, 1f - REPAIR_BONUS*0.01f);
		stats.getWeaponHealthBonus().modifyPercent(id, WEAPON_HEALTH_BONUS);
		//stats.getBallisticWeaponFluxCostMod().modifyMult(id, BALLISTIC_FLUX_MULT);
	}
	
	public String getDescriptionParam(int index, HullSize hullSize) {
		if (index == 0) return "" + (int) WEAPON_HEALTH_BONUS + "%";
		if (index == 1) return "" + (int) REPAIR_BONUS + "%";
		//if (index == 1) return "" + Math.round((1f - BALLISTIC_FLUX_MULT)*100f) + "%";
		return null;
	}

    //Built-in only
    @Override
    public boolean isApplicableToShip(ShipAPI ship) {
        return false;
    }

	@Override
	public boolean affectsOPCosts() {
		return true;
	}

}







