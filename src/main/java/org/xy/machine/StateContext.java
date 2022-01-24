package org.xy.machine;

/**
 * <功能介绍><br>
 * <p>
 * <状态上下文>
 *
 * @author xy on 2022/1/11.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface StateContext<S, E, C> {

    /**
     * 获取流转过程
     *
     * @return 流转过程
     */
    Transition<S, E, C> getTransition();

    /**
     * 获取状态机
     *
     * @return 状态机
     */
    StateMachine<S, E, C> getStateMachine();
}
