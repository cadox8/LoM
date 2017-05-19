package me.cadox8.LoM.states;

import lombok.Getter;
import lombok.Setter;

public class State {

    public enum States {
        LOBBY, GAME, FINISHED, DISABLED;
    }

    @Getter @Setter private States state;

    public State(){
        setState(States.LOBBY);
    }
}
