package com.runescape.revised.system.area.impl;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

import com.runescape.revised.system.System;
import com.runescape.revised.system.area.Area;

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

	/** import com.runescape.revised.KeySystem;
import com.runescape.revised.annotation.AnnotationSystem;
import com.runescape.revised.bot.BotSystem;
import com.runescape.revised.cache.CacheSystem;
import com.runescape.revised.cycle.CycleSystem;
import com.runescape.revised.emotes.EmoteSystem;
import com.runescape.revised.lag.LagSystem;
import com.runescape.revised.media.chat.dialogue.DialogueSystem;
import com.runescape.revised.mission.MissionSystem;
import com.runescape.revised.model.entity.EntitySystem;
import com.runescape.revised.model.object.ObjectSystem;
import com.runescape.revised.net.NetworkingSystem;
import com.runescape.revised.packets.PacketSystem; */

	// import com.runescape.revised.system.area.AreaSystem;
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
		return new System[] {
				/** new AnnotationSystem(), new CacheSystem(), new ChainSystem(),
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
				new VPSSystem(), new ScriptingSystem() */
		};
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