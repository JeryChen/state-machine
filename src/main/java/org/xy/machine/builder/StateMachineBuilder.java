package org.xy.machine.builder;

import org.xy.machine.StateMachine;

/**
 * <功能介绍><br>
 * <p>
 * <状态机构建器>
 *
 * @author xy on 2022/1/24.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface StateMachineBuilder<S, E, C> {

    /**
     * 构建单个外部过渡构建器
     *
     * @return 外部过渡构建器
     */
    ExternalTransitionBuilder<S, E, C> externalTransition();

    /**
     * 构建多源外部过渡构建器
     *
     * @return 外部过渡构建器
     */
    ExternalTransitionsBuilder<S, E, C> externalTransitions();

    /**
     * 构建内部过渡构建器
     *
     * @return 内部过渡构建器
     */
    InternalTransitionBuilder<S, E, C> internalTransition();

    /**
     * 构建状态机
     *
     * @param machineId 状态机标识id
     *
     * @return 状态机
     */
    StateMachine<S, E, C> build(String machineId);
}
