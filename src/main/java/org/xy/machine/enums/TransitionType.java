package org.xy.machine.enums;

/**
 * <功能介绍><br>
 * <p>
 * <流转类型>
 *
 * @author xy on 2022/1/10.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public enum TransitionType {

    /**
     * Implies that the Transition, if triggered, occurs without exiting or entering the source State
     * (i.e., it does not cause a state change). This means that the entry or exit condition of the source
     * State will not be invoked. An internal Transition can be taken even if the SateMachine is in one or
     * more Regions nested within the associated State.
     */
    INTERNAL,

    /**
     * Implies that the Transition, if triggered, will not exit the composite (source) State, but it
     * will exit and re-enter any state within the composite State that is in the current state configuration.
     */
    LOCAL,

    /**
     * Implies that the Transition, if triggered, will exit the composite (source) State.
     */
    EXTERNAL
}
