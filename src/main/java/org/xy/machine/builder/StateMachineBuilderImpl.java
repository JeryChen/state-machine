package org.xy.machine.builder;

import org.xy.machine.State;
import org.xy.machine.StateMachine;
import org.xy.machine.StateMachineFactory;
import org.xy.machine.enums.TransitionType;
import org.xy.machine.impl.StateMachineImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <功能介绍><br>
 * <p>
 * <状态机构建器实现>
 *
 * @author xy on 2022/1/24.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class StateMachineBuilderImpl<S, E, C> implements StateMachineBuilder<S, E, C> {

    /**
     * StateMap 与 stateMachine 相同，因为状态机的核心是对状态的引用
     */
    private final Map<S, State<S, E, C>> stateMap = new ConcurrentHashMap<>();

    private final StateMachineImpl<S, E, C> stateMachine = new StateMachineImpl<>(stateMap);

    /**
     * 构建单个外部过渡构建器
     *
     * @return 外部过渡构建器
     */
    @Override
    public ExternalTransitionBuilder<S, E, C> externalTransition() {
        return new TransitionBuilderImpl<>(stateMap, TransitionType.EXTERNAL);
    }

    /**
     * 构建多源外部过渡构建器
     *
     * @return 外部过渡构建器
     */
    @Override
    public ExternalTransitionsBuilder<S, E, C> externalTransitions() {
        return new TransitionsBuilderImpl<>(stateMap, TransitionType.EXTERNAL);
    }

    /**
     * 构建内部过渡构建器
     *
     * @return 内部过渡构建器
     */
    @Override
    public InternalTransitionBuilder<S, E, C> internalTransition() {
        return new TransitionBuilderImpl<>(stateMap, TransitionType.INTERNAL);
    }

    /**
     * 构建状态机
     *
     * @param machineId 状态机标识id
     *
     * @return 状态机
     */
    @Override
    public StateMachine<S, E, C> build(String machineId) {
        stateMachine.setMachineId(machineId);
        stateMachine.setReady(true);
        StateMachineFactory.register(stateMachine);
        return stateMachine;
    }
}
