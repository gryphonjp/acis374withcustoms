package net.sf.l2j.roboto.ai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.sf.l2j.roboto.FakePlayer;
import net.sf.l2j.roboto.helpers.FakeHelpers;
import net.sf.l2j.roboto.model.HealingSpell;
import net.sf.l2j.roboto.model.OffensiveSpell;
import net.sf.l2j.roboto.model.SpellUsageCondition;
import net.sf.l2j.roboto.model.SupportSpell;

import net.sf.l2j.gameserver.model.ShotType;

/**
 * @author Elfocrash
 *
 */
public class TitanAI extends CombatAI
{
	public TitanAI(FakePlayer character)
	{
		super(character);
	}
	
	@Override
	public void thinkAndAct()
	{
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
	protected double changeOfUsingSkill() {
		return 0.10;
	}
	
	@Override
	protected ShotType getShotType()
	{
		return ShotType.SOULSHOT;
	}
	
	@Override
	protected List<OffensiveSpell> getOffensiveSpells()
	{
		List<OffensiveSpell> _offensiveSpells = new ArrayList<>();
		_offensiveSpells.add(new OffensiveSpell(315, 1));
		_offensiveSpells.add(new OffensiveSpell(190, 2));
		_offensiveSpells.add(new OffensiveSpell(362, 3));
		return _offensiveSpells; 
	}
	
	@Override
	public List<SupportSpell> getSelfSupportSpells()
	{
		List<SupportSpell> _selfSupportSpells = new ArrayList<>();
		_selfSupportSpells.add(new SupportSpell(139, SpellUsageCondition.LESSHPPERCENT, 30, 1));
		_selfSupportSpells.add(new SupportSpell(176, SpellUsageCondition.LESSHPPERCENT, 30, 2));
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