package net.sf.l2j.roboto.ai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.sf.l2j.roboto.FakePlayer;
import net.sf.l2j.roboto.ai.addon.IHealer;
import net.sf.l2j.roboto.helpers.FakeHelpers;
import net.sf.l2j.roboto.model.HealingSpell;
import net.sf.l2j.roboto.model.OffensiveSpell;
import net.sf.l2j.roboto.model.SupportSpell;

import net.sf.l2j.gameserver.model.L2Skill.SkillTargetType;
import net.sf.l2j.gameserver.model.ShotType;

/**
 * @author Elfocrash
 *
 */
public class CardinalAI extends CombatAI implements IHealer
{
	public CardinalAI(FakePlayer character)
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
		tryTargetingLowestHpTargetInRadius(_fakePlayer, FakePlayer.class, FakeHelpers.getTestTargetRange());
		tryHealingTarget(_fakePlayer);
		setBusyThinking(false);
	}
	
	@Override
	protected ShotType getShotType()
	{
		return ShotType.BLESSED_SPIRITSHOT;
	}
	
	@Override
	protected List<OffensiveSpell> getOffensiveSpells()
	{		
		return Collections.emptyList();
	}
	
	@Override
	protected List<HealingSpell> getHealingSpells()
	{		
		List<HealingSpell> _healingSpells = new ArrayList<>();
		_healingSpells.add(new HealingSpell(1218, SkillTargetType.TARGET_ONE, 70, 1));		
		_healingSpells.add(new HealingSpell(1217, SkillTargetType.TARGET_ONE, 80, 3));
		return _healingSpells; 
	}
	
	@Override
	protected int[][] getBuffs()
	{
		return FakeHelpers.getMageBuffs();
	}	

	@Override
	protected List<SupportSpell> getSelfSupportSpells() {
		return Collections.emptyList();
	}
}
