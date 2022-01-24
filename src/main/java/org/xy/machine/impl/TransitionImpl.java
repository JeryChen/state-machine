package org.xy.machine.impl;

import org.xy.machine.Action;
import org.xy.machine.Condition;
import org.xy.machine.State;
import org.xy.machine.Transition;
import org.xy.machine.enums.TransitionType;
import org.xy.machine.exception.StateMachineException;

/**
 * <功能介绍><br>
 * <p>
 * <流转实现>
 *
 * @author xy on 2022/1/11.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class TransitionImpl<S, E, C> implements Transition<S, E, C> {

    private State<S, E, C> source;

    private State<S, E, C> target;

    private E event;

    private Condition<C> condition;

    private Action<S,E,C> action;

    private TransitionType type = TransitionType.EXTERNAL;

    /**
     * 获取此转换的源状态
     *
     * @return 源状态
     */
    @Override
    public State<S, E, C> getSource() {
        return source;
    }

    /**
     * 设置源状态
     *
     * @param state 源状态
     */
    @Override
    public void setSource(State<S, E, C> state) {
        this.source = state;
    }

    /**
     * 获取事件
     *
     * @return 事件
     */
    @Override
    public E getEvent() {
        return event;
    }

    /**
     * 设置事件
     *
     * @param event 事件
     */
    @Override
    public void setEvent(E event) {
        this.event = event;
    }

    /**
     * 设置流转类型
     *
     * @param type 流转类型
     */
    @Override
    public void setType(TransitionType type) {
        this.type = type;
    }

    /**
     * 获取此转换的目标状态
     *
     * @return 目标状态
     */
    @Override
    public State<S, E, C> getTarget() {
        return target;
    }

    /**
     * 设置目标状态
     *
     * @param state 目标状态
     */
    @Override
    public void setTarget(State<S, E, C> state) {
        this.target = state;
    }

    /**
     * 获取条件
     *
     * @return 条件
     */
    @Override
    public Condition<C> getCondition() {
        return condition;
    }

    /**
     * 设置条件
     *
     * @param condition 条件
     */
    @Override
    public void setCondition(Condition<C> condition) {
        this.condition = condition;
    }

    /**
     * 获取动作
     *
     * @return 动作
     */
    @Override
    public Action<S, E, C> getAction() {
        return action;
    }

    /**
     * 设置动作
     *
     * @param action 动作
     */
    @Override
    public void setAction(Action<S, E, C> action) {
        this.action = action;
    }

    /**
     * 做从源状态到目标状态的转换
     *
     * @param ctx 上下文信息
     *
     * @return 目标状态
     */
    @Override
    public State<S, E, C> transit(C ctx) {
        Debugger.debug("Do transition: "+this);
        this.verify();
        if(condition == null || condition.isSatisfied(ctx)){
            if(action != null){
                action.execute(source.getId(), target.getId(), event, ctx);
            }
            return target;
        }
        Debugger.debug("Condition is not satisfied, stay at the "+source+" state ");
        return source;
    }

    /**
     * 验证转换正确性
     */
    @Override
    public void verify() {
        if(type== TransitionType.INTERNAL && source != target) {
            throw new StateMachineException(String.format("Internal transition source state '%s' " +
                    "and target state '%s' must be same.", source, target));
        }
    }

    @Override
    public String toString() {
        return source + "-[" + event.toString() +", "+type+"]->" + target;
    }

    @Override
    public boolean equals(Object anObject){
        if(anObject instanceof Transition){
            Transition other = (Transition)anObject;
            if(this.event.equals(other.getEvent())
                    && this.source.equals(other.getSource())
                    && this.target.equals(other.getTarget())){
                return true;
            }
        }
        return false;
    }
}
