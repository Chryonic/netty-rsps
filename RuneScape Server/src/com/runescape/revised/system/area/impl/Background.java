package com.runescape.revised.system.area.impl;

import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

import com.runescape.revised.annotation.AnnotationSystem;
import com.runescape.revised.cache.CacheSystem;
import com.runescape.revised.chain.ChainSystem;
import com.runescape.revised.content.ContentSystem;
import com.runescape.revised.content.account.AccountSystem;
import com.runescape.revised.content.achievement.AchievementSystem;
import com.runescape.revised.content.activity.ActivitySystem;
import com.runescape.revised.content.bank.BankSystem;
import com.runescape.revised.content.bot.BotSystem;
import com.runescape.revised.content.clue.ClueScrollSystem;
import com.runescape.revised.content.cutscene.CutSceneSystem;
import com.runescape.revised.content.dialogue.DialogueSystem;
import com.runescape.revised.content.dicing.DicingSystem;
import com.runescape.revised.content.distractionsdiversions.DistractionsDiversionsSystem;
import com.runescape.revised.content.donation.DonationSystem;
import com.runescape.revised.content.doors.DoorSystem;
import com.runescape.revised.content.dungeon.DungeonSystem;
import com.runescape.revised.content.dupe.DupeSystem;
import com.runescape.revised.content.earningpotential.EarningPotentialSystem;
import com.runescape.revised.content.emotes.EmoteSystem;
import com.runescape.revised.content.event.EventSystem;
import com.runescape.revised.content.forum.ForumSystem;
import com.runescape.revised.content.gambling.GamblingSystem;
import com.runescape.revised.content.grandexchange.GrandExchangeSystem;
import com.runescape.revised.content.gravestone.GraveStoneSystem;
import com.runescape.revised.content.guild.GuildSystem;
import com.runescape.revised.content.hiscores.HiScoresSystem;
import com.runescape.revised.content.item.ItemSystem;
import com.runescape.revised.content.jail.JailSystem;
import com.runescape.revised.content.lag.LagSystem;
import com.runescape.revised.content.lobby.LobbySystem;
import com.runescape.revised.content.location.LocationSystem;
import com.runescape.revised.content.log.LogSystem;
import com.runescape.revised.content.loot.LootSystem;
import com.runescape.revised.content.lottery.LotterySystem;
import com.runescape.revised.content.minigame.MiniGameSystem;
import com.runescape.revised.content.object.ObjectSystem;
import com.runescape.revised.content.party.PartyRoomSystem;
import com.runescape.revised.content.plugin.PluginSystem;
import com.runescape.revised.content.pouch.PouchSystem;
import com.runescape.revised.content.prestige.PrestigeSystem;
import com.runescape.revised.content.punishment.PunishmentSystem;
import com.runescape.revised.content.quest.QuestSystem;
import com.runescape.revised.content.randomevent.RandomEventSystem;
import com.runescape.revised.content.relationship.RelationshipSystem;
import com.runescape.revised.content.reputation.ReputationSystem;
import com.runescape.revised.content.rspsgenerator.RSPSGeneratorSystem;
import com.runescape.revised.content.scripting.ScriptingSystem;
import com.runescape.revised.content.sewers.SewerSystem;
import com.runescape.revised.content.shop.ShopSystem;
import com.runescape.revised.content.skill.SkillSystem;
import com.runescape.revised.content.skill.agility.AgilitySystem;
import com.runescape.revised.content.skill.combat.CombatSystem;
import com.runescape.revised.content.skill.combat.attack.AttackSystem;
import com.runescape.revised.content.skill.combat.consitution.HitpointsSystem;
import com.runescape.revised.content.skill.combat.defense.DefenseSystem;
import com.runescape.revised.content.skill.combat.evolution.CombatEvolutionSystem;
import com.runescape.revised.content.skill.combat.magic.MagicSystem;
import com.runescape.revised.content.skill.combat.prayer.PrayerSystem;
import com.runescape.revised.content.skill.combat.range.RangeSystem;
import com.runescape.revised.content.skill.combat.strength.StrengthSystem;
import com.runescape.revised.content.skill.construction.ConstructionSystem;
import com.runescape.revised.content.skill.cooking.CookingSystem;
import com.runescape.revised.content.skill.crafting.CraftingSystem;
import com.runescape.revised.content.skill.divination.DivinationSystem;
import com.runescape.revised.content.skill.dungeoneering.DungeoneeringSystem;
import com.runescape.revised.content.skill.farming.FarmingSystem;
import com.runescape.revised.content.skill.firemaking.FiremakingSystem;
import com.runescape.revised.content.skill.fishing.FishingSystem;
import com.runescape.revised.content.skill.fletching.FletchingSystem;
import com.runescape.revised.content.skill.herblore.HerbloreSystem;
import com.runescape.revised.content.skill.hunter.HunterSystem;
import com.runescape.revised.content.skill.mining.MiningSystem;
import com.runescape.revised.content.skill.pking.PKingSystem;
import com.runescape.revised.content.skill.runecrafting.RunecraftingSystem;
import com.runescape.revised.content.skill.slayer.SlayerSystem;
import com.runescape.revised.content.skill.smithing.SmithingSystem;
import com.runescape.revised.content.skill.summoning.SummoningSystem;
import com.runescape.revised.content.skill.thieving.ThievingSystem;
import com.runescape.revised.content.skill.woodcutting.WoodcuttingSystem;
import com.runescape.revised.content.social.SocialSystem;
import com.runescape.revised.content.ticket.TicketSystem;
import com.runescape.revised.content.tower.TowerSystem;
import com.runescape.revised.content.travel.TravelSystem;
import com.runescape.revised.content.tutorialisland.TutorialIslandSystem;
import com.runescape.revised.content.vote.VoteSystem;
import com.runescape.revised.content.wilderness.WildernessSystem;
import com.runescape.revised.content.world.WorldSystem;
import com.runescape.revised.creation.CreationSystem;
import com.runescape.revised.logic.LogicSystem;
import com.runescape.revised.logic.cycle.CycleSystem;
import com.runescape.revised.logic.entity.EntitySystem;
import com.runescape.revised.logic.entity.update.UpdateSystem;
import com.runescape.revised.logic.key.KeySystem;
import com.runescape.revised.logic.mission.MissionSystem;
import com.runescape.revised.logic.net.NetworkingSystem;
import com.runescape.revised.logic.net.packets.PacketSystem;
import com.runescape.revised.logic.path.PathSystem;
import com.runescape.revised.logic.pool.PoolSystem;
import com.runescape.revised.server.ServerSystem;
import com.runescape.revised.server.update.UpdateServerSystem;
import com.runescape.revised.system.System;
import com.runescape.revised.system.area.Area;
import com.runescape.revised.system.area.AreaSystem;
import com.runescape.revised.thread.ThreadSystem;
import com.runescape.revised.vps.VPSSystem;

/**
 * The BackgroundArea should have everything.
 * So add everything to the backgroundArea first.
 * Take from the backgroundArea and give it to the foregroundArea.
 * Once completed, remove from foregroundArea and give back to backgroundArea.
 * A complete cycle of it should be occurring; and it should be
 * processing in the background.
 * 
 * @author Josh
 *
 */
public class Background extends Area {

	/**
	 * 
	 */
	private Queue<System> systemQueue;

	/**
	 * An ExecutorService for background tasks.
	 */
	private ExecutorService executorService;

	/**
	 * 
	 */
	private BlockingQueue<Future<System>> pendingSystems;

	/**
	 * Class constructor.
	 */
	public Background() {
		this.setSystemQueue(new PriorityQueue<System>()); // TransferQueue?
		for (final System system : this.getTotalSystems()) {
			this.getSystemQueue().add(system);
		}
		this.setPendingSystems(new LinkedBlockingQueue<Future<System>>());
		this.waitForSystems();
	}

	/** public void executeSystem(final System system) {
		this.getExecutorService().submit(new Runnable() {

			@Override
			public void run() {
				system.executeSystem();
			}
		});
	} */

	/**
	 * Wait for Systems to complete.
	 */
	public void waitForSystems() {
		while (this.getPendingSystems().size() > 0) {
			try {
				this.getPendingSystems().take().get();
			} catch (InterruptedException | ExecutionException ee) {
				ee.printStackTrace();
			}
		}
	}

	@Override
	public void sendSystem(final System system, final Area area) {
		this.getSystemQueue().remove(system);
		area.getSystemQueue().add(system);
	}

	public System[] getTotalSystems() {
		try {
			return new System[] {
					new AnnotationSystem(), new CacheSystem(), new ChainSystem(),
					new ContentSystem(), new AccountSystem(), new AchievementSystem(),
					new ActivitySystem(), new BankSystem(), new BotSystem(),
					new ClueScrollSystem(), new CutSceneSystem(), new DialogueSystem(),
					new DicingSystem(), new DistractionsDiversionsSystem(),
					new DonationSystem(), new DoorSystem(), new DungeonSystem(),
					new DupeSystem(), new EarningPotentialSystem(), new EmoteSystem(),
					new EventSystem(), new ForumSystem(), new GamblingSystem(),
					new GrandExchangeSystem(), new GraveStoneSystem(), new GuildSystem(),
					new HiScoresSystem(), new ItemSystem(), new JailSystem(),
					new LagSystem(), new LobbySystem(), new LocationSystem(),
					new LogSystem(), new LootSystem(), new LotterySystem(),
					new MiniGameSystem(), new ObjectSystem(), new PartyRoomSystem(),
					new PluginSystem(), new PouchSystem(), new PrestigeSystem(),
					new PunishmentSystem(), new QuestSystem(), new RandomEventSystem(),
					new RelationshipSystem(), new ReputationSystem(),
					new RSPSGeneratorSystem(), new SewerSystem(), new ShopSystem(),
					new SkillSystem(), new AgilitySystem(), new CombatSystem(),
					new AttackSystem(), new HitpointsSystem(), new DefenseSystem(),
					new CombatEvolutionSystem(), new MagicSystem(), new PrayerSystem(),
					new RangeSystem(), new StrengthSystem(), new ConstructionSystem(),
					new CookingSystem(), new CraftingSystem(), new DivinationSystem(),
					new DungeoneeringSystem(), new FarmingSystem(),
					new FiremakingSystem(), new FishingSystem(), new FletchingSystem(),
					new HerbloreSystem(), new HunterSystem(), new MiningSystem(),
					new PKingSystem(), new RunecraftingSystem(), new SlayerSystem(),
					new SmithingSystem(), new SummoningSystem(), new ThievingSystem(),
					new WoodcuttingSystem(), new SocialSystem(), new TicketSystem(),
					new TowerSystem(), new TravelSystem(), new TutorialIslandSystem(),
					new VoteSystem(), new WildernessSystem(), new WorldSystem(),
					new CreationSystem(), new LogicSystem(), new CycleSystem(),
					new EntitySystem(), new UpdateSystem(), new KeySystem(),
					new MissionSystem(), new NetworkingSystem(), new PacketSystem(),
					new PathSystem(), new PoolSystem(), new ServerSystem(),
					new AreaSystem(), new ThreadSystem(), new UpdateServerSystem(),
					new VPSSystem(), new ScriptingSystem()
			};
		} catch (final IOException ioe) {
			// TODO Auto-generated catch block
			ioe.printStackTrace();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.runescape.revised.system.area.Area#getSystems()
	 */
	@Override
	public System[] getSystems() {
		return (System[]) this.getSystemQueue().toArray();
	}

	public void setSystemQueue(final Queue<System> systemQueue) {
		this.systemQueue = systemQueue;
	}

	/*
	 * (non-Javadoc)
	 * @see com.runescape.revised.system.area.Area#getSystemQueue()
	 */
	@Override
	public Queue<System> getSystemQueue() {
		return this.systemQueue;
	}

	public void setExecutorService(final ExecutorService executorService) {
		this.executorService = executorService;
	}

	public ExecutorService getExecutorService() {
		return this.executorService;
	}

	public void setPendingSystems(final BlockingQueue<Future<System>> pendingSystems) {
		this.pendingSystems = pendingSystems;
	}

	public BlockingQueue<Future<System>> getPendingSystems() {
		return this.pendingSystems;
	}
}