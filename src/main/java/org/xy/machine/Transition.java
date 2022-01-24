package org.xy.machine;

import org.xy.machine.enums.TransitionType;

/**
 * <功能介绍><br>
 * <p>
 * <流转>
 * 表示从一个状态到另一个状态
 *
 * @author xy on 2022/1/10.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface Transition<S, E, C> {

    /**
     * 获取此转换的源状态
     *
     * @return 源状态
     */
    State<S, E, C> getSource();

    /**
     * 设置源状态
     *
     * @param state 源状态
     */
    void setSource(State<S, E, C> state);

    /**
     * 获取事件
     *
     * @return 事件
     */
    E getEvent();

    /**
     * 设置事件
     *
     * @param event 事件
     */
    void setEvent(E event);

    /**
     * 设置流转类型
     *
     * @param type 流转类型
     */
    void setType(TransitionType type);

    /**
     * 获取此转换的目标状态
     *
     * @return 目标状态
     */
    State<S, E, C> getTarget();

    /**
     * 设置目标状态
     *
     * @param state 目标状态
     */
    void setTarget(State<S, E, C> state);

    /**
     * 获取条件
     *
     * @return 条件
     */
    Condition<C> getCondition();

    /**
     * 设置条件
     *
     * @param condition 条件
     */
    void setCondition(Condition<C> condition);

    /**
     * 获取动作
     *
     * @return 动作
     */
    Action<S, E, C> getAction();

    /**
     * 设置动作
     *
     * @param action 动作
     */
    void setAction(Action<S, E, C> action);

    /**
     * 做从源状态到目标状态的转换
     *
     * @param ctx 上下文信息
     *
     * @return 目标状态
     */

    State<S, E, C> transit(C ctx);

    /**
     * 验证转换正确性
     */
    void verify();
}
