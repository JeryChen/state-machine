package org.xy.machine;

import org.xy.machine.enums.TransitionType;

import java.util.Collection;
import java.util.Optional;

/**
 * <功能介绍><br>
 * <p>
 * <状态>
 *
 * @author xy on 2022/1/10.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface State<S, E, C> extends Visitable {

    /**
     * 获取状态标识符
     *
     * @return 状态标识符
     */
    S getId();

    /**
     * 向状态添加流程
     *
     * @param event          事件
     * @param target         目标状态
     * @param transitionType 流转类型
     *
     * @return 流转过程
     */
    Transition<S, E, C> addTransition(E event, State<S, E, C> target, TransitionType transitionType);

    /**
     * 获取流程
     *
     * @param event 事件
     *
     * @return 流转过程
     */
    Optional<Transition<S, E, C>> getTransition(E event);

    /**
     * 获取所有流程
     *
     * @return 流转过程集合
     */
    Collection<Transition<S, E, C>> getTransitions();
}
