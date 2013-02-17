package com.runecore.env.model.player;

import java.util.LinkedList;
import java.util.List;

import com.runecore.env.model.Entity;
import com.runecore.env.model.def.PlayerDefinition;
import com.runecore.network.GameSession;

/**
 * Player.java
 * @author Harry Andreas<harry@runecore.org>
 * Feb 10, 2013
 */
public class Player extends Entity {

    /**
     * Variables for the Player
     * No primative types in here!
     */
    private PlayerDefinition definition;
    private final GameSession session;
    private final Skills skills;
    private final Looks looks;
    private final List<Player> localPlayers;
    private final boolean[] playerExists = new boolean[2048];
    
    /**
     * Construct the Player instance
     * @param session The GameSession for the Player
     * @param definition The PlayerDefinition for this Player instance
     */
    public Player(GameSession session, PlayerDefinition definition) {
	this.definition = definition;
	this.session = session;
	this.session.setPlayer(this);
	this.skills = new Skills(this);
	this.looks = new Looks();
	this.localPlayers = new LinkedList<Player>();
    }
    
    @Override
    public void tick() {
	getWalking().getNextEntityMovement();
    }
    
    @Override
    public PlayerDefinition getDefinition() {
	return definition;
    }
    
    public GameSession getSession() {
	return session;
    }

    public Skills getSkills() {
	return skills;
    }

    public Looks getLooks() {
	return looks;
    }

    public List<Player> getLocalPlayers() {
	return localPlayers;
    }

    public boolean[] getPlayerExists() {
	return playerExists;
    }

}