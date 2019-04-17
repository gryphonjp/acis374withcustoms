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

public class DuelistAI extends CombatAI implements IConsumableSpender {
	
	public DuelistAI(FakePlayer character) {
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
		return 0.5;
	}

	@Override
	protected List<OffensiveSpell> getOffensiveSpells() {
		List<OffensiveSpell> _offensiveSpells = new ArrayList<>();
		_offensiveSpells.add(new OffensiveSpell(345, 1));
		_offensiveSpells.add(new OffensiveSpell(261, 2));		
		_offensiveSpells.add(new OffensiveSpell(5, 3));		
		_offensiveSpells.add(new OffensiveSpell(6, 4));		
		_offensiveSpells.add(new OffensiveSpell(1, 5));
		return _offensiveSpells;
	}
	
	@Override
	protected List<SupportSpell> getSelfSupportSpells() {
		List<SupportSpell> _selfSupportSpells = new ArrayList<>();
		_selfSupportSpells.add(new SupportSpell(139, 1));
		_selfSupportSpells.add(new SupportSpell(297, 2));
		_selfSupportSpells.add(new SupportSpell(440, SpellUsageCondition.MISSINGCP, 1000, 3));
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
