package net.sf.l2j.roboto.ai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.sf.l2j.roboto.FakePlayer;
import net.sf.l2j.roboto.ai.addon.IConsumableSpender;
import net.sf.l2j.roboto.helpers.FakeHelpers;
import net.sf.l2j.roboto.model.HealingSpell;
import net.sf.l2j.roboto.model.OffensiveSpell;
import net.sf.l2j.roboto.model.SpellUsageCondition;
import net.sf.l2j.roboto.model.SupportSpell;

import net.sf.l2j.gameserver.model.ShotType;

public class DreadnoughtAI extends CombatAI implements IConsumableSpender {
	
	public DreadnoughtAI(FakePlayer character) {
		super(character);
	}

	@Override
	public void thinkAndAct() {		
		super.thinkAndAct();
		setBusyThinking(true);
		applyDefaultBuffs();
		handleShots();
		selfSupportBuffs();
		tryTargetRandomCreatureByTypeInRadius(FakeHelpers.getTestTargetClass(), FakeHelpers.getTestTargetRange());		
		tryAttackingUsingFighterOffensiveSkill();
		setBusyThinking(false);
	}

	@Override
	protected ShotType getShotType() {
		return ShotType.SOULSHOT;
	}	
	
	@Override
	protected double changeOfUsingSkill() {
		return 0.33;
	}

	@Override
	protected List<OffensiveSpell> getOffensiveSpells() {
		List<OffensiveSpell> _offensiveSpells = new ArrayList<>();
		_offensiveSpells.add(new OffensiveSpell(361, 1));
		_offensiveSpells.add(new OffensiveSpell(347, 2));		
		_offensiveSpells.add(new OffensiveSpell(48, 3));
		_offensiveSpells.add(new OffensiveSpell(452, 4));
		_offensiveSpells.add(new OffensiveSpell(36, 5));		
		return _offensiveSpells;
	}
	
	@Override
	protected List<SupportSpell> getSelfSupportSpells() {
		List<SupportSpell> _selfSupportSpells = new ArrayList<>();
		_selfSupportSpells.add(new SupportSpell(440, SpellUsageCondition.MISSINGCP, 1000, 1));
		return _selfSupportSpells;
	}
	
	@Override
	protected int[][] getBuffs()
	{
		return FakeHelpers.getFighterBuffs();
	}
	
	@Override
	protected List<HealingSpell> getHealingSpells()
	{		
		return Collections.emptyList();
	}

}
