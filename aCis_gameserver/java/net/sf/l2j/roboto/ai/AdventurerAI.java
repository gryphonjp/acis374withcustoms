package net.sf.l2j.roboto.ai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.sf.l2j.roboto.FakePlayer;
import net.sf.l2j.roboto.helpers.FakeHelpers;
import net.sf.l2j.roboto.model.HealingSpell;
import net.sf.l2j.roboto.model.OffensiveSpell;
import net.sf.l2j.roboto.model.SupportSpell;

import net.sf.l2j.gameserver.model.ShotType;

/**
 * @author Elfocrash
 *
 */
public class AdventurerAI extends CombatAI
{
	public AdventurerAI(FakePlayer character)
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
		tryTargetRandomCreatureByTypeInRadius(FakeHelpers.getTestTargetClass(), FakeHelpers.getTestTargetRange());		
		tryAttackingUsingFighterOffensiveSkill();
		setBusyThinking(false);
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
		_offensiveSpells.add(new OffensiveSpell(263, 4));
		_offensiveSpells.add(new OffensiveSpell(12, 1));
		_offensiveSpells.add(new OffensiveSpell(11, 2));
		_offensiveSpells.add(new OffensiveSpell(4, 3));
		_offensiveSpells.add(new OffensiveSpell(409, 5));
		_offensiveSpells.add(new OffensiveSpell(344, 6));
		_offensiveSpells.add(new OffensiveSpell(358, 7));
		return _offensiveSpells; 
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
	
	@Override
	protected List<SupportSpell> getSelfSupportSpells() {
		return Collections.emptyList();
	}
}