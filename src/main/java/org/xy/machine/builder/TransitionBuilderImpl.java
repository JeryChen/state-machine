package org.xy.machine.builder;

import org.xy.machine.Action;
import org.xy.machine.Condition;
import org.xy.machine.State;
import org.xy.machine.Transition;
import org.xy.machine.enums.TransitionType;
import org.xy.machine.impl.StateHelper;

import java.util.Map;

/**
 * <功能介绍><br>
 * <p>
 * <转换生成器实现>
 *
 * @author xy on 2022/1/24.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class TransitionBuilderImpl<S, E, C> implements ExternalTransitionBuilder<S, E, C>, InternalTransitionBuilder<S, E, C>, From<S, E, C>, On<S, E, C>, To<S, E, C> {

    public final Map<S, State<S, E, C>> stateMap;

    private State<S, E, C> source;

    protected State<S, E, C> target;

    private Transition<S, E, C> transition;

    public final TransitionType transitionType;

    public TransitionBuilderImpl(Map<S, State<S, E, C>> stateMap, TransitionType transitionType) {
        this.stateMap = stateMap;
        this.transitionType = transitionType;
    }

    /**
     * 构建转换源状态
     *
     * @param stateId 状态标识id
     *
     * @return 从子句生成器
     */
    @Override
    public From<S, E, C> from(S stateId) {
        source = StateHelper.getState(stateMap, stateId);
        return this;
    }

    /**
     * 构建转换目标状态并返回子句构建器
     *
     * @param stateId 状态标识id
     *
     * @return 到子句生成器
     */
    @Override
    public To<S, E, C> to(S stateId) {
        target = StateHelper.getState(stateMap, stateId);
        return this;
    }

    /**
     * 建立内部过度
     *
     * @param stateId 过度状态标识id
     *
     * @return "到"子句生成器
     */
    @Override
    public To<S, E, C> within(S stateId) {
        source = target = StateHelper.getState(stateMap, stateId);
        return this;
    }

    /**
     * 为过渡添加条件
     *
     * @param condition 过渡条件
     *
     * @return 当子句生成器
     */
    @Override
    public When<S, E, C> when(Condition<C> condition) {
        transition.setCondition(condition);
        return this;
    }

    /**
     * 构建过度事件
     *
     * @param event 过度事件
     *
     * @return 关于子句生成器
     */
    @Override
    public On<S, E, C> on(E event) {
        transition = source.addTransition(event, target, transitionType);
        return this;
    }

    /**
     * 定义过渡期间要执行的操作
     *
     * @param action 执行的动作
     */
    @Override
    public void perform(Action<S, E, C> action) {
        transition.setAction(action);
    }
}
