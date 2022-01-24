package org.xy.machine.builder;

import org.xy.machine.Action;
import org.xy.machine.Condition;
import org.xy.machine.State;
import org.xy.machine.Transition;
import org.xy.machine.enums.TransitionType;
import org.xy.machine.impl.StateHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * <功能介绍><br>
 * <p>
 * <>
 *
 * @author xy on 2022/1/24.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class TransitionsBuilderImpl<S, E, C> extends TransitionBuilderImpl<S, E, C> implements ExternalTransitionsBuilder<S, E, C> {

    private List<State<S, E, C>> sources = new ArrayList<>();

    private List<Transition<S, E, C>> transitions = new ArrayList<>();

    public TransitionsBuilderImpl(Map<S, State<S, E, C>> stateMap, TransitionType transitionType) {
        super(stateMap, transitionType);
    }

    /**
     * 多源构建转换源状态
     *
     * @param stateIds 状态标识ids
     *
     * @return 从子句生成器
     */
    @Override
    public From<S, E, C> fromAmong(S... stateIds) {
        Arrays.stream(stateIds)
              .forEach(x -> sources.add(StateHelper.getState(super.stateMap, x)));
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
        transitions.stream()
                   .peek(x -> x.setCondition(condition));
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
        sources.stream()
               .peek(x -> transitions.add(x.addTransition(event, super.target, super.transitionType)));
        return this;
    }

    /**
     * 定义过渡期间要执行的操作
     *
     * @param action 执行的动作
     */
    @Override
    public void perform(Action<S, E, C> action) {
        transitions.stream()
                   .peek(x -> x.setAction(action));
    }
}
