package org.xy.machine.impl;

import org.xy.machine.State;
import org.xy.machine.Transition;
import org.xy.machine.Visitor;
import org.xy.machine.enums.TransitionType;
import org.xy.machine.exception.StateMachineException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * <功能介绍><br>
 * <p>
 * <状态实现>
 *
 * @author xy on 2022/1/11.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class StateImpl<S, E, C> implements State<S, E, C> {

    protected final S stateId;

    private Map<E, Transition<S, E, C>> transitions = new HashMap<>();

    public StateImpl(S stateId) {
        this.stateId = stateId;
    }

    /**
     * 获取状态标识符
     *
     * @return 状态标识符
     */
    @Override
    public S getId() {
        return stateId;
    }

    /**
     * 向状态添加流程
     *
     * @param event          事件
     * @param target         目标状态
     * @param transitionType 流转类型
     *
     * @return 流转过程
     */
    @Override
    public Transition<S, E, C> addTransition(E event, State<S, E, C> target, TransitionType transitionType) {
        Transition<S, E, C> newTransition = new TransitionImpl<>();
        newTransition.setSource(this);
        newTransition.setTarget(target);
        newTransition.setEvent(event);
        newTransition.setType(transitionType);

        Debugger.debug("Begin to add new transition: "+ newTransition);
        verify(event, newTransition);
        transitions.put(event, newTransition);
        return newTransition;
    }

    /**
     * 获取流程
     *
     * @param event 事件
     *
     * @return 流转过程
     */
    @Override
    public Optional<Transition<S, E, C>> getTransition(E event) {
        return Optional.ofNullable(transitions.get(event));
    }

    /**
     * 获取所有流程
     *
     * @return 流转过程集合
     */
    @Override
    public Collection<Transition<S, E, C>> getTransitions() {
        return transitions.values();
    }

    /**
     * 接受处理
     *
     * @param visitor 访问者
     *
     * @return 访问者进入和退出结果
     */
    @Override
    public String accept(Visitor visitor) {
        String entry = visitor.visitOnEntry(this);
        String exit = visitor.visitOnExit(this);
        return entry + exit;
    }

    /**
     * Per one source and target state, there is only one transition is allowed
     * @param event
     * @param newTransition
     */
    private void verify(E event, Transition<S,E,C> newTransition) {
        Transition existingTransition = transitions.get(event);
        if(existingTransition != null){
            if(existingTransition.equals(newTransition)){
                throw new StateMachineException(existingTransition+" already Exist, you can not add another one");
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof State){
            State other = (State)obj;
            if(this.stateId.equals(other.getId())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "stateId=" + stateId.toString();
    }
}
